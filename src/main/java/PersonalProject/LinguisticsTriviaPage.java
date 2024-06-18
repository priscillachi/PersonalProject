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

import java.io.*;
import java.util.*;

import com.jogamp.opengl.GLProfile;

public class LinguisticsTriviaPage extends Page {
    private boolean overHomePageButton = false;
    private boolean overStartQuizButton = false;
    private boolean overEndQuizButton = false;
    private boolean quizStarted = false;
    private ArrayList<String> questions = new ArrayList<String>();
    private ArrayList<String[]> answers = new ArrayList<String[]>();
    private ArrayList<String[]> responses = new ArrayList<String[]>();
    private ArrayList<String> correctAnswer = new ArrayList<String>();
    private int index;
    private int timer = 0;

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
        this.questions.add("What is the most common language of Iran?");
        String[] answers1 = {"Arabic", "Hindi", "Farsi", "Kurdish"};
        String[] responses1 = {"Incorrect!", "Incorrect!", "Correct! Iran is a majority Persian country. The language for Persian is Farsi", "Close! Kurdish is one of the most common, but not the most"};
        this.answers.add(answers1);
        this.responses.add(responses1);
        this.correctAnswer.add("Farsi");

        this.questions.add("How many tones does Manderin have?");
        String[] answers2 = {"Four", "Eight", "Five", "Three"};
        String[] responses2 = {"Correct!", "Incorrect!", "Incorrect!", "Incorrect!"};
        this.answers.add(answers2);
        this.responses.add(responses2);
        this.correctAnswer.add("Four");

        this.questions.add("Which of the following is correct about the Hebrew language?");
        String[] answers3 = {"It is a dead language", "It was originally revived by Yiddish speakers", "It was originally revived by Aramaic speakers", "Its only modern usage is in liturgy"};
        String[] responses3 = {"Incorrect! It has been revived", "Correct!", "Incorrect! It was revived by Yiddish speakers", "Incorrect! It has been revived for daily usage"};
        this.answers.add(answers3);
        this.responses.add(responses3);
        this.correctAnswer.add("It was originally revived by Yiddish speakers");

        this.questions.add("Which is the following is correct about tonal languages?");
        String[] answers4 = {"Their speakers cannot speak non-tonal languages", "All tonal languages are written in the latin alphabet", "Korean is a tonal language", "On average, their speakers are more likely to have perfect pitch"};
        String[] responses4 = {"Incorrect!", "Incorrect!", "Incorrect! Korean has no tones", "Correct! Musical perception is different for tonal language speakers"};
        this.answers.add(answers4);
        this.responses.add(responses4);
        this.correctAnswer.add("On average, their speakers are more likely to have perfect pitch");

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

        } else if (app.mouseX >= 50 && app.mouseX <= 350 && app.mouseY >= 160 && app.mouseY <= 250 && this.quizStarted == false) {
            this.overStartQuizButton = true;

        } else if (app.mouseX >= 1184 && app.mouseX <= 1484 && app.mouseY >= 160 && app.mouseY <= 250 && this.quizStarted == true) {
            this.overEndQuizButton = true;

        } else {
            this.overHomePageButton = false;
            this.overStartQuizButton = false;
            this.overEndQuizButton = false;
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
            }

        } else {
            app.cursor(ARROW);
        }
    }

    public void highlightHeader() {}

    public void generation() { // in this case, this is for the quiz itself
        if (this.quizStarted == true) {
            app.rectMode(CENTER);
            app.fill(251, 251, 253);
            app.noStroke();
            app.rect(782, 650, 800, 600, 20, 20, 20, 20);
            
            if (this.timer <= 800) {
                app.rectMode(CORNER);
                app.fill(0);
                app.noStroke();
                app.rect(382, 350, this.timer, 30, 20, 20, 20, 20);

                this.timer += 1.6;

                app.rectMode(CENTER);

                app.textAlign(CENTER, CENTER);
                app.textFont(textFont);
                app.textSize(20);
                app.text(this.questions.get(this.index), 782, 400);
            }
        }
    }
}
