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
    }

    public void checkMouse() {

    }

    public void checkButton() {
        if (app.mouseX >= 30 && app.mouseX <= 330 && app.mouseY >= 35 && app.mouseY <= 125) {
            this.overHomePageButton = true;
        } else {
            this.overHomePageButton = false;
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
                this.setData();
            }
        }
    }

    public void highlightHeader() {

    }

    public void generation() {

    }
}
