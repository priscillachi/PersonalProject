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


public class MovieTimePage extends Page {
    private ArrayList<String> scienceFictionMovies = new ArrayList<String>();
    private ArrayList<String> romanceMovies = new ArrayList<String>();
    private ArrayList<String> childrensMovies = new ArrayList<String>();
    private ArrayList<String> comedyMovies = new ArrayList<String>();
    private PImage television;
    private boolean overHomePageButton = false;
    private boolean overTelevisionButton = false;
    private boolean televisionOn = false;
    private boolean overXButton = false;
    private boolean overTier1Button = false;
    private boolean overTier2Button = false;
    private boolean overTier3Button = false;


    public MovieTimePage(App app) {
        super(app);
    }

    public void setBackground() {
        this.backgroundImage = app.loadImage(app.getClass().getResource("movie-time-background.jpg").getPath().replace("%20", " "));
    }

    public void setFont() {
        this.headerFont = app.createFont(app.getClass().getResource("Newake-Font-Demo.otf").getPath().replace("%20", " "), 100);
        this.textFont = app.createFont(app.getClass().getResource("WorkSans.ttf").getPath().replace("%20", " "), 100);
    }

    public void setImages() {
        this.television = app.loadImage(app.getClass().getResource("television-2.png").getPath().replace("%20", " "));
    }

    public void setData() {

    }

    public void drawBackground() {
        app.background(this.backgroundImage);

        if (this.televisionOn == false) {
            app.image(this.television, 920, 720, 300, 300);
        }
    }

    public void drawHeader() {
        app.textFont(this.headerFont);
        app.stroke(248, 252, 240);
        app.textSize(150);
        app.textAlign(CENTER, CENTER);
        app.fill(248, 252, 240);
        app.text("MOVIE TIME", 782, 80);
        app.noStroke();
    }
    
    public void drawDescription() {
        app.textFont(this.textFont);
        app.fill(248, 252, 240);
        app.textSize(20);
        app.text("This is another shit game to help me when I am feeling indecisive.", 782, 180);
        app.text("What can I say, I just have the best taste in film xx", 782, 210);
        app.text("I jest... also, I digress... click on the TV to see my movie tastes.", 782, 240);
        app.text("They are unique, down to earth, underground, etc. (the list goes on).", 782, 270);
        app.text("(I am trying to be mysterious, can you tell?)", 782, 300);

        if (this.televisionOn == true) {
            app.rectMode(CENTER);
            app.fill(251, 251, 253);
            app.noStroke();
            app.rect(782, 650, 800, 600, 20, 20, 20, 20);
        }
    }

    public void drawButtons() {
        app.fill(211, 211, 211);
        app.rectMode(CENTER);
        app.rect(200, 400, 300, 90, 20, 20, 20, 20);

        app.textFont(this.headerFont);
        app.textSize(45);
        app.fill(88,57,39);
        app.text("HOME PAGE", 200, 400);

        if (this.televisionOn == true) {
            app.stroke(1, 2, 3);
            app.strokeWeight(5);
            app.line(1140, 370, 1160, 390);
            app.line(1140, 390, 1160, 370);
            app.noStroke();

            app.textFont(this.headerFont);
            app.textSize(45);
            app.fill(1,1,1);
            app.text("MY FAVOURITE MOVIES", 782, 500);
            app.fill(147,98,143);
            app.text("TIER 1", 782, 600);
            app.fill(148, 99, 144);
            app.text("TIER 2", 782, 700);
            app.fill(149, 100, 145);
            app.text("TIER 3", 782, 800);
        }
    }

    public void checkMouse() {

    }

    public void checkButton() {
        if (app.get(app.mouseX, app.mouseY) == app.color(147, 98, 143) || app.get(app.mouseX, app.mouseY) == app.color(0, 65, 194)) {
            this.overTier1Button = true;

        } else if (app.get(app.mouseX, app.mouseY) == app.color(148, 99, 144) || app.get(app.mouseX, app.mouseY) == app.color(1, 66, 195)) {
            this.overTier2Button = true;

        } else if (app.get(app.mouseX, app.mouseY) == app.color(149, 100, 145) || app.get(app.mouseX, app.mouseY) == app.color(2, 67, 196)) {
            this.overTier3Button = true;
        
        } else if (app.mouseX >= 50 && app.mouseX <= 350 && app.mouseY >= 355 && app.mouseY <= 445) {
            this.overHomePageButton = true;

        } else if (app.mouseX >= 770 && app.mouseX <= 1070 && app.mouseY >= 570 && app.mouseY <= 870 && this.televisionOn == false) {
            this.overTelevisionButton = true;

        } else if (app.mouseX >= 1130 && app.mouseX <= 1170 && app.mouseY >=350 && app.mouseY <= 400) {
            this.overXButton = true;
        
        } else {
            this.overTier1Button = false;
            this.overTier2Button = false;
            this.overTier3Button = false;
            this.overHomePageButton = false;
            this.overTelevisionButton = false;
            this.overXButton = false;
        }
    }

    public void checkClickButton() {

    }

    public void highlightButton() {
        if (this.overHomePageButton == true) {
            app.cursor(HAND);

            app.fill(248, 252, 240);
            app.rectMode(CENTER);
            app.rect(200, 400, 320, 110, 20, 20, 20, 20);
    
            app.textFont(this.headerFont);
            app.textSize(45);
            app.fill(88,57,39);
            app.text("HOME PAGE", 200, 400);

            if (app.clicked == true) {
                app.currentPage = app.homePage;
            }

        } else if (this.televisionOn == false && this.overTelevisionButton == true) {
            app.cursor(HAND);

            app.fill(236,230,255);
            app.rectMode(CENTER);
            app.rect(920, 720, 300, 300, 20, 20, 20, 20);

            app.image(this.television, 920, 720, 300, 300);

            if (app.clicked == true) {
                this.televisionOn = true;
            }
        
        } else if (this.overXButton == true && this.televisionOn == true) {
            app.cursor(HAND);
            app.rectMode(CENTER);
            app.fill(211, 211, 211);
            app.rect(1150, 380, 40, 40, 20, 20, 20, 20);

            app.stroke(1, 2, 3);
            app.strokeWeight(5);
            app.line(1140, 370, 1160, 390);
            app.line(1140, 390, 1160, 370);
            app.noStroke();

            if (app.clicked == true) {
                this.televisionOn = false;
            }

        } else if (this.overTier1Button == true && this.televisionOn == true) {
            app.cursor(HAND);
            app.textFont(this.headerFont);
            app.textSize(45);
            app.fill(0, 65, 194);
            app.text("TIER 1", 782, 600);
        
        } else if (this.overTier2Button == true && this.televisionOn == true) {
            app.cursor(HAND);
            app.textFont(this.headerFont);
            app.textSize(45);
            app.fill(1, 66, 195);
            app.text("TIER 2", 782, 700);

        } else if (this.overTier3Button == true && this.televisionOn == true) {
            app.cursor(HAND);
            app.textFont(this.headerFont);
            app.textSize(45);
            app.fill(2, 67, 196);
            app.text("TIER 3", 782, 800);

        } else {
            app.cursor(ARROW);
        }
    }

    public void highlightHeader() {

    }
    public void generation() {

    }
}
