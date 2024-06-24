package PersonalProject;

import org.checkerframework.checker.units.qual.A;
import processing.core.*;
import static processing.core.PConstants.*;
import processing.opengl.*;
import processing.data.JSONArray;
import processing.data.JSONObject;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.*;

import java.io.*;
import java.util.*;

import com.jogamp.opengl.GLProfile;

public class LinguisticsTriviaPage extends Page {
    private boolean overHomePageButton = false;
    private boolean overStartQuizButton = false;
    private boolean overEndQuizButton = false;
    private boolean overIndex0 = false;
    private boolean overIndex1 = false;
    private boolean overIndex2 = false;
    private boolean overIndex3 = false;
    private boolean quizStarted = false;
    private boolean printScore = false;
    private boolean responseOn = false;
    private ArrayList<String> questions;
    private ArrayList<String[]> answers;
    private ArrayList<String[]> responses;
    private ArrayList<Integer> correctAnswer;
    private int index;
    private int timer = 0;
    private int score;
    private int responseTimer = 0;
    private int answerChosen = 9;
    private int size;

    public LinguisticsTriviaPage(App app) {
        super(app);
    }
    
    public void setBackground() {
        this.backgroundImage = app.loadImage(app.getClass().getResource("linguistics-trivia-page.jpg").getPath().replace("%20", " "));
    }

    public void setFont() {
        this.headerFont = app.createFont(app.getClass().getResource("Newake-Font-Demo.otf").getPath().replace("%20", " "), 100);
        this.textFont = app.createFont(app.getClass().getResource("WorkSans.ttf").getPath().replace("%20", " "), 100);
    }

    public void setImages() {}

    public void setData() {
        this.questions = new ArrayList<String>();
        this.answers = new ArrayList<String[]>();
        this.responses = new ArrayList<String[]>();
        this.correctAnswer = new ArrayList<Integer>();

        this.questions.add("What is the most common language of Iran?");
        String[] answers1 = {"Arabic", "Hindi", "Farsi", "Kurdish"};
        String[] responses1 = {"Incorrect", "Incorrect", "Correct", "Incorrect"};
        this.answers.add(answers1);
        this.responses.add(responses1);
        this.correctAnswer.add(2);

        this.questions.add("How many tones does Manderin have?");
        String[] answers2 = {"Four", "Eight", "Five", "Three"};
        String[] responses2 = {"Correct", "Incorrect", "Incorrect", "Incorrect"};
        this.answers.add(answers2);
        this.responses.add(responses2);
        this.correctAnswer.add(0);

        this.questions.add("Which of the following is correct about the Hebrew language?");
        String[] answers3 = {"It is a dead language", "It was originally revived by Yiddish speakers", "It was originally revived by Aramaic speakers", "Its only modern usage is in liturgy"};
        String[] responses3 = {"Incorrect as it has been revived", "Correct", "Incorrect as it was revived by Yiddish speakers", "Incorrect as it has been revived for daily usage"};
        this.answers.add(answers3);
        this.responses.add(responses3);
        this.correctAnswer.add(1);

        this.questions.add("Which is the following is correct about tonal languages?");
        String[] answers4 = {"Their speakers cannot speak non-tonal languages", "All tonal languages are written in the latin alphabet", "Korean is a tonal language", "On average, their speakers are more likely to have perfect pitch"};
        String[] responses4 = {"Incorrect", "Incorrect", "Incorrect as Korean has no tones", "Correct"};
        this.answers.add(answers4);
        this.responses.add(responses4);
        this.correctAnswer.add(3);

        this.size = this.questions.size();
        this.index = app.random.nextInt(this.questions.size());
    }

    public void generateRandom() {
        this.index = app.random.nextInt(this.questions.size());
    }

    public void drawBackground() {
        app.background(this.backgroundImage);
    }

    public void drawHeader() {}

    public void drawDescription() {
        app.textFont(this.textFont);
        app.fill(0);
        app.textSize(17);
        app.textAlign(CENTER, CENTER);

        app.text("My current hyperfixation at the moment is linguistics.", 980, 80);
        app.text("Here is a quiz for you. If you get below 70%, you are dumb.", 980, 110);
        app.text("I am kidding, you are not dumb.", 980, 140);
        app.text("Don't get offended. Have fun xx", 980, 170);
    }

    public void drawButtons() {
        app.fill(211, 211, 211);
        app.rectMode(CENTER);
        app.rect(230, 80, 300, 90, 20, 20, 20, 20);

        app.textFont(this.headerFont);
        app.textSize(45);
        app.textAlign(CENTER, CENTER);
        app.fill(88,57,39);
        app.text("HOME PAGE", 230, 80);

        if (this.quizStarted == false) {
            app.fill(211, 211, 211);
            app.rectMode(CENTER);
            app.rect(230, 205, 300, 90, 20, 20, 20, 20);

            app.textFont(this.headerFont);
            app.textSize(45);
            app.textAlign(CENTER, CENTER);
            app.fill(88,57,39);
            app.text("START QUIZ", 230, 205);
        }

        if (this.quizStarted == true) {
            app.fill(211, 211, 211);
            app.rectMode(CENTER);
            app.rect(1334, 205, 300, 90, 20, 20, 20, 20);

            app.textFont(this.headerFont);
            app.textSize(45);
            app.textAlign(CENTER, CENTER);
            app.fill(88,57,39);
            app.text("END QUIZ", 1334, 205);
        }
    }

    public void checkMouse() {}

    public void checkButton() {
        if (app.mouseX >= 50 && app.mouseX <= 350 && app.mouseY >= 35 && app.mouseY <= 125) {
            this.overHomePageButton = true;
            this.overStartQuizButton = false;
            this.overEndQuizButton = false;
            this.overIndex0 = false;
            this.overIndex1 = false;
            this.overIndex2 = false;
            this.overIndex3 = false;

        } else if (app.mouseX >= 50 && app.mouseX <= 350 && app.mouseY >= 160 && app.mouseY <= 250 && this.quizStarted == false) {
            this.overStartQuizButton = true;
            this.overHomePageButton = false;
            this.overEndQuizButton = false;
            this.overIndex0 = false;
            this.overIndex1 = false;
            this.overIndex2 = false;
            this.overIndex3 = false;

        } else if (app.mouseX >= 1184 && app.mouseX <= 1484 && app.mouseY >= 160 && app.mouseY <= 250 && this.quizStarted == true) {
            this.overEndQuizButton = true;
            this.overHomePageButton = false;
            this.overStartQuizButton = false;
            this.overIndex0 = false;
            this.overIndex1 = false;
            this.overIndex2 = false;
            this.overIndex3 = false;

        } else if (app.mouseX >= 382 && app.mouseX <= 782 && app.mouseY >= 450 && app.mouseY <= 700 && this.quizStarted == true && this.responseOn == false) {
            this.overIndex0 = true;
            this.overHomePageButton = false;
            this.overStartQuizButton = false;
            this.overEndQuizButton = false;
            this.overIndex1 = false;
            this.overIndex2 = false;
            this.overIndex3 = false;

        } else if (app.mouseX >= 782 && app.mouseX <= 1182 && app.mouseY >= 450 && app.mouseY <= 700 && this.quizStarted == true && this.responseOn == false) {
            this.overIndex1 = true;
            this.overHomePageButton = false;
            this.overStartQuizButton = false;
            this.overEndQuizButton = false;
            this.overIndex0 = false;
            this.overIndex2 = false;
            this.overIndex3 = false;

        } else if (app.mouseX >= 382 && app.mouseX <= 782 && app.mouseY >= 700 && app.mouseY <= 950 && this.quizStarted == true && this.responseOn == false) {
            this.overIndex2 = true;
            this.overHomePageButton = false;
            this.overStartQuizButton = false;
            this.overEndQuizButton = false;
            this.overIndex0 = false;
            this.overIndex1 = false;
            this.overIndex3 = false;

        } else if (app.mouseX >= 782 && app.mouseX <= 1182 && app.mouseY >= 700 && app.mouseY <= 950 && this.quizStarted == true && this.responseOn == false) {
            this.overIndex3 = true;
            this.overHomePageButton = false;
            this.overStartQuizButton = false;
            this.overEndQuizButton = false;
            this.overIndex0 = false;
            this.overIndex1 = false;
            this.overIndex2 = false;

        } else {
            this.overHomePageButton = false;
            this.overStartQuizButton = false;
            this.overEndQuizButton = false;
            this.overIndex0 = false;
            this.overIndex1 = false;
            this.overIndex2 = false;
            this.overIndex3 = false;
        }
    }

    public void checkClickButton() {}

    public void highlightButton() {
        if (this.overHomePageButton == true) {
            app.cursor(HAND);

            app.fill(248, 252, 240);
            app.rectMode(CENTER);
            app.rect(230, 80, 320, 110, 20, 20, 20, 20);
    
            app.textFont(this.headerFont);
            app.textSize(45);
            app.textAlign(CENTER, CENTER);
            app.fill(88,57,39);
            app.text("HOME PAGE", 230, 80);

            if (app.clicked == true) {
                app.currentPage = app.homePage;
                this.quizStarted = false;
                this.generateRandom();
                this.timer = 0;
                this.printScore = false;
                this.score = 0;
                this.responseOn = false;
                this.responseTimer = 0;
                this.setData();
            }

        } else if (this.overStartQuizButton == true && this.quizStarted == false) {
            app.cursor(HAND);

            app.fill(248, 252, 240);
            app.rectMode(CENTER);
            app.rect(230, 205, 320, 110, 20, 20, 20, 20);
    
            app.textFont(this.headerFont);
            app.textSize(45);
            app.textAlign(CENTER, CENTER);
            app.fill(88,57,39);
            app.text("START QUIZ", 230, 205);

            if (app.clicked == true) {
                this.quizStarted = true;
                this.score = 0;
                this.generateRandom();
                this.timer = 0;
                this.printScore = false;
                this.responseOn = false;
                this.responseTimer = 0;
                this.setData();
            }
            
        } else if (this.overEndQuizButton == true && this.quizStarted == true) {
            app.cursor(HAND);

            app.fill(248, 252, 240);
            app.rectMode(CENTER);
            app.rect(1334, 205, 320, 110, 20, 20, 20, 20);
    
            app.textFont(this.headerFont);
            app.textSize(45);
            app.textAlign(CENTER, CENTER);
            app.fill(88,57,39);
            app.text("END QUIZ", 1334, 205);

            if (app.clicked == true) {
                this.quizStarted = false;
                this.generateRandom();
                this.timer = 0;
                this.printScore = true;
                this.responseOn = false;
                this.responseTimer = 0;
            }

        } else if (this.overIndex0 == true && this.quizStarted == true && this.overIndex1 == false && this.overIndex2 == false && this.overIndex3 == false) {
            app.cursor(HAND);

            if (app.clicked == true) {
                if (this.correctAnswer.get(this.index) == 0) {
                    this.score += 1;
                }

                this.answerChosen = 0;

                this.responseOn = true;

                this.timer = 800;                
            }

        } else if (this.overIndex1 == true && this.quizStarted == true && this.overIndex0 == false && this.overIndex2 == false && this.overIndex3 == false) {
            app.cursor(HAND);

            if (app.clicked == true) {
                if (this.correctAnswer.get(this.index) == 1) {
                    this.score += 1;
                }

                this.answerChosen = 1;

                this.responseOn = true;

                this.timer = 800;
            }

        } else if (this.overIndex2 == true && this.quizStarted == true && this.overIndex0 == false && this.overIndex1 == false && this.overIndex3 == false) {
            app.cursor(HAND);

            if (app.clicked == true) {
                if (this.correctAnswer.get(this.index) == 2) {
                    this.score += 1;
                }

                this.answerChosen = 2;

                this.responseOn = true;

                this.timer = 800;
            }

        } else if (this.overIndex3 == true && this.quizStarted == true && this.overIndex0 == false && this.overIndex1 == false && this.overIndex2 == false) {
            app.cursor(HAND);

            if (app.clicked == true) {
                if (this.correctAnswer.get(this.index) == 3) {
                    this.score += 1;
                }

                this.answerChosen = 3;

                this.responseOn = true;

                this.timer = 800;
            }

        } else {
            app.cursor(ARROW);
        }
    }

    public void highlightHeader() {}

    public void generation() { // in this case, this is for the quiz itself
        if (this.questions.size() == 0) {
            this.responseOn = false;
            this.printScore = true;
            this.quizStarted = false;
        }

        if (this.quizStarted == true) {
            app.rectMode(CENTER);
            app.fill(251, 251, 253);
            app.noStroke();
            app.rect(782, 650, 800, 600, 20, 20, 20, 20);
            
            if (this.timer == 0) {
                this.generateRandom();
            }

            if (this.timer <= 800 && this.responseOn == false && this.printScore == false) {

                app.rectMode(CORNER);
                app.fill(0);
                app.noStroke();
                app.rect(382, 350, this.timer, 30, 20, 20, 20, 20);

                this.timer += 1.6;

                app.rectMode(CENTER);

                app.textAlign(CENTER, CENTER);
                app.textFont(this.textFont);
                app.textSize(20);
                app.text(this.questions.get(this.index), 782, 400);

                app.rectMode(CENTER);
                app.fill(236,96,96);
                app.rect(582, 575, 400, 250);
                app.fill(185,120,231);
                app.rect(982, 575, 400, 250);
                app.fill(174,55,133);
                app.rect(582, 825, 400, 250);
                app.fill(82,142,225);
                app.rect(982, 825, 400, 250);

                app.fill(0);
                app.textSize(15);
                app.text(this.answers.get(this.index)[0], 582, 575);
                app.text(this.answers.get(this.index)[1], 982, 575);
                app.text(this.answers.get(this.index)[2], 582, 825);
                app.text(this.answers.get(this.index)[3], 982, 825);
            }

            if (this.timer >= 800) {

                this.responseOn = true;

                if (this.questions.size() == 0) {
                    this.responseOn = false;
                    this.printScore = true;
                    this.quizStarted = false;
                }
                
                if (this.responseOn == true && this.responseTimer <= 800) {

                    app.rectMode(CORNER);
                    app.fill(0);
                    app.noStroke();
                    app.rect(382, 350, this.responseTimer, 30, 20, 20, 20, 20);
            
                    app.rectMode(CENTER);
                    app.textAlign(CENTER, CENTER);
                    app.fill(0);
                    app.textFont(this.headerFont);
                    app.textSize(50);

                    if (this.answerChosen == 9) {
                        app.text("Time's up", 782, 650);
                    } else {
                        app.text(this.responses.get(index)[this.answerChosen], 782, 650);

                    }

                    this.responseTimer += 4;

                } 

                if (this.responseTimer >= 800) {

                    this.questions.remove(this.index);
                    this.answers.remove(this.index);
                    this.responses.remove(this.index);
                    this.correctAnswer.remove(this.index);

                    this.answerChosen = 9; // this is greater than 4 therefore will equate to no answer chosen
                    this.responseOn = false;
                    this.responseTimer = 0;
                    this.timer = 0;

                    
                }
            }

        }

        if (this.printScore == true) {
            app.rectMode(CENTER);
            app.fill(251, 251, 253);
            app.noStroke();
            app.rect(782, 650, 800, 600, 20, 20, 20, 20);

            app.textAlign(CENTER, CENTER);
            app.fill(0);
            app.textFont(this.headerFont);
            app.textSize(50);
            String scoreOut = "You scored " + Integer.toString(this.score) + " out of " + Integer.toString(this.size);
            app.text(scoreOut, 782, 650);

            this.setData();
        }
    }
}
