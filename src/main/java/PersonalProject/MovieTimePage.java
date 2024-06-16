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
    private boolean overHomePageButton;


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
        app.image(this.television, 920, 720, 300, 300);
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
    }

    public void drawButtons() {
        app.fill(211, 211, 211);
        app.rectMode(CENTER);
        app.rect(200, 400, 300, 90, 20, 20, 20, 20);

        app.textFont(this.headerFont);
        app.textSize(45);
        app.fill(88,57,39);
        app.text("HOME PAGE", 200, 400);
    }

    public void checkMouse() {

    }

    public void checkButton() {
        if (app.mouseX >= 50 && app.mouseX <= 350 && app.mouseY >= 355 && app.mouseY <= 445) {
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
            app.rect(200, 400, 320, 110, 20, 20, 20, 20);
    
            app.textFont(this.headerFont);
            app.textSize(45);
            app.fill(88,57,39);
            app.text("HOME PAGE", 200, 400);

            if (app.clicked == true) {
                app.currentPage = app.homePage;
            }

        } else {
            app.cursor(ARROW);
        }
    }

    public void highlightHeader() {

    }
    public void generation() {

    }
}
