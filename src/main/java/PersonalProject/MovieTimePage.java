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
    private ArrayList<String> tier1Movies = new ArrayList<String>();
    private ArrayList<String> tier2Movies = new ArrayList<String>();
    private ArrayList<String> tier3Movies = new ArrayList<String>();
    private PImage television;
    private boolean overHomePageButton = false;
    private boolean overTelevisionButton = false;
    private boolean televisionOn = false;
    private boolean overXButton = false;
    private boolean overTier1Button = false;
    private boolean overTier2Button = false;
    private boolean overTier3Button = false;
    private boolean overRestartButton = false;
    private boolean movieGenerated = false;
    private int indexTier1;
    private int indexTier2;
    private int indexTier3;
    private String movie;

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
        this.tier1Movies.add("Gattaca");
        this.tier1Movies.add("Whiplash");
        this.tier1Movies.add("Blade Runner");
        this.tier1Movies.add("Blade Runner 2049");
        this.tier1Movies.add("Inception");
        this.tier1Movies.add("Arrival");
        this.tier1Movies.add("Star Wars Episode III Revenge of the Sith");
        this.tier1Movies.add("12 Years a Slave");
        this.tier1Movies.add("Django Unchained");
        this.tier1Movies.add("Lincoln");

        this.tier2Movies.add("The Dictator");
        this.tier2Movies.add("How to Train Your Dragon");
        this.tier2Movies.add("Rise of the Guardians");
        this.tier2Movies.add("Babylon");
        this.tier2Movies.add("La La Land");
        this.tier2Movies.add("The Hunger Games");
        this.tier2Movies.add("The Help");

        this.tier3Movies.add("10 Things I Hate About You");
        this.tier3Movies.add("Frozen");
        this.tier3Movies.add("This Is 40");
        this.tier3Movies.add("The Other Woman");
        this.tier3Movies.add("Knocked Up");
        this.tier3Movies.add("Borat");

        this.indexTier1 = app.random.nextInt(this.tier1Movies.size());
        this.indexTier2 = app.random.nextInt(this.tier2Movies.size());
        this.indexTier3 = app.random.nextInt(this.tier3Movies.size());
    }

    public void generateRandom() {
        this.indexTier1 = app.random.nextInt(this.tier1Movies.size());
        this.indexTier2 = app.random.nextInt(this.tier2Movies.size());
        this.indexTier3 = app.random.nextInt(this.tier3Movies.size());  
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
        app.textAlign(CENTER, CENTER);
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

        if (this.televisionOn == true && this.movieGenerated == false) {
            app.stroke(1, 2, 3);
            app.strokeWeight(5);
            app.line(1140, 370, 1160, 390);
            app.line(1140, 390, 1160, 370);
            app.noStroke();

            app.textFont(this.headerFont);
            app.textAlign(CENTER, CENTER);
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

        if (this.movieGenerated == true) {
            app.fill(211, 211, 211);
            app.rectMode(CENTER);
            app.rect(1364, 900, 300, 80, 20, 20, 20, 20);
    
            app.textFont(this.headerFont);
            app.textSize(45);
            app.textAlign(CENTER, CENTER);
            app.fill(88,57,39);
            app.text("RESTART", 1364, 900);
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

        } else if (app.mouseX >= 1214 && app.mouseX <= 1514 && app.mouseY >= 860 && app.mouseY <= 940) {
            this.overRestartButton = true;
        
        } else {
            this.overTier1Button = false;
            this.overTier2Button = false;
            this.overTier3Button = false;
            this.overHomePageButton = false;
            this.overTelevisionButton = false;
            this.overXButton = false;
            this.overRestartButton = false;
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
            app.textAlign(CENTER, CENTER);
            app.fill(88,57,39);
            app.text("HOME PAGE", 200, 400);

            if (app.clicked == true) {
                app.currentPage = app.homePage;
                this.movieGenerated = false;
                this.televisionOn = false;
                this.generateRandom();
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

        } else if (this.overTier1Button == true && this.televisionOn == true && this.movieGenerated == false) {
            app.cursor(HAND);
            app.textFont(this.headerFont);
            app.textSize(45);
            app.textAlign(CENTER, CENTER);
            app.fill(0, 65, 194);
            app.text("TIER 1", 782, 600);

            if (app.clicked == true) {
                this.movieGenerated = true;
                this.movie = this.tier1Movies.get(this.indexTier1);
            }
        
        } else if (this.overTier2Button == true && this.televisionOn == true && this.movieGenerated == false) {
            app.cursor(HAND);
            app.textFont(this.headerFont);
            app.textSize(45);
            app.textAlign(CENTER, CENTER);
            app.fill(1, 66, 195);
            app.text("TIER 2", 782, 700);

            if (app.clicked == true) {
                this.movieGenerated = true;
                this.movie = this.tier2Movies.get(this.indexTier2);
            }

        } else if (this.overTier3Button == true && this.televisionOn == true && this.movieGenerated == false) {
            app.cursor(HAND);
            app.textFont(this.headerFont);
            app.textSize(45);
            app.textAlign(CENTER, CENTER);
            app.fill(2, 67, 196);
            app.text("TIER 3", 782, 800);

            if (app.clicked == true) {
                this.movieGenerated = true;
                this.movie = this.tier3Movies.get(this.indexTier3);
            }
        
        } else if (this.overRestartButton == true && this.movieGenerated == true) {
            app.cursor(HAND);

            app.fill(248, 252, 240);
            app.rectMode(CENTER);
            app.rect(1364, 900, 320, 100, 20, 20, 20, 20);
    
            app.textFont(this.headerFont);
            app.textSize(45);
            app.textAlign(CENTER, CENTER);
            app.fill(88,57,39);
            app.text("RESTART", 1364, 900);

            if (app.clicked == true) {
                this.movieGenerated = false;
                this.generateRandom();
            }

        } else {
            app.cursor(ARROW);
        }
    }

    public void highlightHeader() {

    }

    public void generation() {
        if (this.movieGenerated == true) {
            app.fill(88,57,39);
            app.rectMode(CENTER);
            app.rect(782, 600, (40*this.movie.length()), 140, 20, 20, 20, 20);

            app.textFont(this.headerFont);
            app.strokeWeight(80);
            app.textSize(70);
            app.textAlign(CENTER, CENTER);
            app.fill(248, 252, 240);
            app.text(this.movie, 782, 600);
        }
    }
}
