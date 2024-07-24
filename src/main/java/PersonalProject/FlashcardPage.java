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

import com.jogamp.opengl.GLProfile;;

public class FlashcardPage extends Page {
    private boolean overHomePageButton;
    private boolean overAddFashcardButton;
    private boolean overResetButton;
    private ArrayList<String> questions;
    private ArrayList<String> answers;

    public FlashcardPage(App app) {
        super(app);
    }
    
    public void setBackground() {
        this.backgroundImage = app.loadImage(app.getClass().getResource("flashcard-background.jpg").getPath().replace("%20", " "));
    }

    public void setFont() {
        this.headerFont = app.createFont(app.getClass().getResource("Newake-Font-Demo.otf").getPath().replace("%20", " "), 100);
        this.textFont = app.createFont(app.getClass().getResource("WorkSans.ttf").getPath().replace("%20", " "), 100);
    }

    public void setImages() {

    }

    public void setData() {

    }

    public void generateRandom() {

    }

    public void drawBackground() {
        app.background(this.backgroundImage);
    }

    public void drawHeader() {
        app.textFont(this.headerFont);
        app.stroke(248, 252, 240);
        app.textSize(150);
        app.textAlign(CENTER, CENTER);
        app.fill(248, 252, 240);
        app.text("FLASHCARDS", 782, 80);
        app.noStroke();
    }

    public void drawDescription() {

    }

    public void drawButtons() {
        app.fill(211, 211, 211);
        app.rectMode(CENTER);
        app.rect(180, 80, 300, 90, 20, 20, 20, 20);

        app.textFont(this.headerFont);
        app.textSize(45);
        app.textAlign(CENTER, CENTER);
        app.fill(88,57,39);
        app.text("HOME PAGE", 180, 80);

        app.fill(211, 211, 211);
        app.rectMode(CENTER);
        app.rect(782, 518, 400, 90, 20, 20, 20, 20);

        app.textFont(this.headerFont);
        app.textSize(45);
        app.textAlign(CENTER, CENTER);
        app.fill(88,57,39);
        app.text("ADD FLASHCARDS", 782, 518);

        app.fill(211, 211, 211);
        app.rectMode(CENTER);
        app.rect(1334, 956, 300, 90, 20, 20, 20, 20);

        app.textFont(this.headerFont);
        app.textSize(45);
        app.textAlign(CENTER, CENTER);
        app.fill(88,57,39);
        app.text("RESET", 1334, 956);
    }

    public void checkMouse() {

    }

    public void checkButton() {
        if (app.mouseX >= 30 && app.mouseX <= 330 && app.mouseY >= 35 && app.mouseY <= 125) {
            this.overHomePageButton = true;
            this.overAddFashcardButton = false;
            this.overResetButton = false;
        } else if (app.mouseX >= 582 && app.mouseX <= 982 && app.mouseY >= 473 && app.mouseY <= 563) {
            this.overAddFashcardButton = true;
            this.overHomePageButton = false;
            this.overResetButton = false;
        } else if (app.mouseX >= 1184 && app.mouseX <= 1484 && app.mouseY >= 911 && app.mouseY <= 1001) {
            this.overResetButton = true;
            this.overHomePageButton = false;
            this.overAddFashcardButton = false;
        } else {
            this.overHomePageButton = false;
            this.overAddFashcardButton = false;
            this.overResetButton = false;
        }
    }

    public void checkClickButton() {

    }

    public void highlightButton() {
        if (this.overHomePageButton == true) {
            app.cursor(HAND);

            app.fill(248, 252, 240);
            app.rectMode(CENTER);
            app.rect(180, 80, 320, 110, 20, 20, 20, 20);
    
            app.textFont(this.headerFont);
            app.textSize(45);
            app.textAlign(CENTER, CENTER);
            app.fill(88,57,39);
            app.text("HOME PAGE", 180, 80);

            if (app.clicked == true) {
                app.currentPage = app.homePage;
                this.generateRandom();
                this.questions = new ArrayList<String>();
                this.answers = new ArrayList<String>();
            }

        } else if (this.overAddFashcardButton == true) {
            app.cursor(HAND);

            app.fill(248, 252, 240);
            app.rectMode(CENTER);
            app.rect(782, 518, 420, 110, 20, 20, 20, 20);
    
            app.textFont(this.headerFont);
            app.textSize(45);
            app.textAlign(CENTER, CENTER);
            app.fill(88,57,39);
            app.text("ADD FLASHCARDS", 782, 518);

            if (app.clicked == true) {
                ;
            }

        } else if (this.overResetButton == true) {
            app.cursor(HAND);

            app.fill(248, 252, 240);
            app.rectMode(CENTER);
            app.rect(1334, 956, 320, 110, 20, 20, 20, 20);

            app.textFont(this.headerFont);
            app.textSize(45);
            app.textAlign(CENTER, CENTER);
            app.fill(88,57,39);
            app.text("RESET", 1334, 956);

            if (app.clicked == true) {
                ;
            }
        }
    }

    public void highlightHeader() {

    }

    public void generation() {

    }
}
