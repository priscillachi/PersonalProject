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


public class RussianRoulettePage extends Page {
    private PImage megamind;
    private PImage ednaMode;
    private PImage lordFarquaad;
    private boolean overCheapEatsButton = false;
    private boolean overCasualFineDiningButton = false;
    private boolean overFineDiningButton = false;
    private boolean overHomePageButton = false;
    private boolean overRestartButton = false;
    private ArrayList<String> cheapEats = new ArrayList<String>();
    private ArrayList<String> casualFineDining = new ArrayList<String>();
    private ArrayList<String> fineDining = new ArrayList<String>();
    private boolean restaurantGenerated = false;
    private String restaurant;
    private int indexCheapEats;
    private int indexCasualFineDining;
    private int indexFineDining;
    private Random random = new Random();


    public RussianRoulettePage(App app) {
        super(app);
    }

    public void setBackground() {
        this.backgroundImage = app.loadImage(app.getClass().getResource("russian-roulette-background.jpg").getPath().replace("%20", " "));
    }

    public void setFont() {
        this.headerFont = app.createFont(app.getClass().getResource("Newake-Font-Demo.otf").getPath().replace("%20", " "), 100);
        this.textFont = app.createFont(app.getClass().getResource("WorkSans.ttf").getPath().replace("%20", " "), 100);
    }

    public void setImages() {
        this.megamind = app.loadImage(app.getClass().getResource("megamind.png").getPath().replace("%20", " "));
        this.ednaMode = app.loadImage(app.getClass().getResource("edna-mode.png").getPath().replace("%20", " "));
        this.lordFarquaad = app.loadImage(app.getClass().getResource("lord-farquaad.png").getPath().replace("%20", " "));
    }

    public void setData() {
        this.cheapEats.add("The Drunk Dumpling in Newtown");
        this.cheapEats.add("Chinese Noodle House in Haymarket");
        this.cheapEats.add("Boon Cafe in Haymarket");
        this.cheapEats.add("Maenam in Strathfield");
        this.cheapEats.add("Mamak in Haymarket");
        this.cheapEats.add("Fratelli Fresh in Darling Harbour or Manly");
        this.cheapEats.add("VN Street Food in Marrickville");
        this.cheapEats.add("Chat Thai in Haymarket");
        this.cheapEats.add("Mappen Noodle Bar in Town Hall");
        this.cheapEats.add("Oiden Bowl Bar in Town Hall");
        this.cheapEats.add("Ho Jiak in Town Hall");
        this.cheapEats.add("Enjoy Mie in Haymarket");

        this.casualFineDining.add("Chin Chin in Surry Hills");
        this.casualFineDining.add("Tokki in Surry Hills");
        this.casualFineDining.add("Kaiza Izakaya in Newtown");
        this.casualFineDining.add("Vasco in Newtown");
        this.casualFineDining.add("Bella Brutta in Newtown");
        this.casualFineDining.add("Cicerone in Surry Hills");
        //this.casualFineDining.add("Ms G's in Potts Point");
        this.casualFineDining.add("Ezra in Potts Point");
        this.casualFineDining.add("Franca in Potts Point");
        this.casualFineDining.add("Cho Cho San in Potts Point");
        this.casualFineDining.add("Queen Chow in Newtown");
        this.casualFineDining.add("Ito in Surry Hills");
        this.casualFineDining.add("King Clarence in Wynyard");
        //this.casualFineDining.add("Totti's in Rozelle or Bondi or Wynyard");
        this.casualFineDining.add("Hustlers Syd in Wynyard");
        this.casualFineDining.add("Izgara in Potts Point");
        this.casualFineDining.add("Lotus in Barangaroo");
        this.casualFineDining.add("Belly Bao in Newtown");
        this.casualFineDining.add("China Diner in Double Bay or Bondi or Tramsheds");
        this.casualFineDining.add("MuMu in Wynyard");
        //this.casualFineDining.add("Jimmy's Falafel in Wynyard");
        this.casualFineDining.add("Fabbrica Pasta Shop in Martin Place");
        this.casualFineDining.add("Pellegrino 2000 in Surry Hills");
        this.casualFineDining.add("Mille Vini in Surry Hills");

        this.fineDining.add("Aria in Circular Quay");
        this.fineDining.add("Bennelong in Circular Quay");
        //this.fineDining.add("Penelope's in Circular Quay");
        this.fineDining.add("Icebergs in Bondi");
        this.fineDining.add("Firedoor in Surry Hills");
        this.fineDining.add("Cirrus in Barangaroo");
        this.fineDining.add("Quay in The Rocks");
        this.fineDining.add("Catalina in Rose Bay");
        //this.fineDining.add("Mimi's in Coogee");
        this.fineDining.add("Restaurant Hubert in Sydney CBD");
        this.fineDining.add("Mr Wong in Wynyard");

        this.indexCheapEats = this.random.nextInt(this.cheapEats.size());

        this.indexCasualFineDining = this.random.nextInt(this.casualFineDining.size());

        this.indexFineDining = this.random.nextInt(this.fineDining.size());
    }

    public void drawBackground() {
        app.background(this.backgroundImage);

        app.imageMode(CENTER);
        app.image(this.megamind, 785, 700, (float)106.5, 304);
        app.image(this.ednaMode, 610, 590, (float)84.67, 190);
        app.image(this.lordFarquaad, 900, 420, 86, 240);
    }

    public void drawHeader() {
        app.textFont(this.headerFont);
        app.stroke(248, 252, 240);
        app.textSize(150);
        app.textAlign(CENTER, CENTER);
        app.fill(248, 252, 240);
        app.text("RUSSIAN ROULETTE", 782, 80);
        app.noStroke();
    }

    public void drawDescription() {
        app.textFont(this.textFont);
        app.fill(248, 252, 240);
        app.textSize(20);
        app.text("This Russian Roulette game is kinda shit... It serves the purpose of recommending me restaurants in Sydney when I am feeling indecisive.", 782, 180);
        app.text("It might help you, it might not. Use it if you want - I don't really care... you might think my taste in food is terrible though xx", 782, 210);
        app.text("Click one of the buttons on the right side to generate a restaurant in that category. Left button for the home page.", 782, 240);
        app.text("P.S. these are my favourite cartoon villains.", 782, 270);
    }

    public void drawButtons() {
        if (this.overCheapEatsButton == false && this.restaurantGenerated == false) {
            app.textFont(this.headerFont);
            app.textSize(45);
            app.fill(194, 24, 7);
            app.text("CHEAP EATS", 1300, 400);
        }
        
        if (this.overCasualFineDiningButton == false && this.restaurantGenerated == false) {
            app.textFont(this.headerFont);
            app.textSize(45);
            app.fill(195, 25, 8);
            app.text("CASUAL FINE DINING", 1300, 600);
        }

        if (this.overFineDiningButton == false && this.restaurantGenerated == false) {
            app.textFont(this.headerFont);
            app.textSize(45);
            app.fill(196, 26, 9);
            app.text("FINE DINING", 1300, 800);
        }

        app.fill(211, 211, 211);
        app.rectMode(CENTER);
        app.rect(200, 400, 300, 90, 20, 20, 20, 20);

        app.textFont(this.headerFont);
        app.textSize(45);
        app.fill(88,57,39);
        app.text("HOME PAGE", 200, 400);

        if (this.restaurantGenerated == true) {
            app.fill(211, 211, 211);
            app.rectMode(CENTER);
            app.rect(1364, 900, 300, 80, 20, 20, 20, 20);
    
            app.textFont(this.headerFont);
            app.textSize(45);
            app.fill(88,57,39);
            app.text("RESTART", 1364, 900);
        }
    }
    
    public void checkMouse() {
    }

    public void checkButton() {
        if (app.get(app.mouseX, app.mouseY) == app.color(194, 24, 7) || app.get(app.mouseX, app.mouseY) == app.color(0, 65, 194)) {
            this.overCheapEatsButton = true;
        } else if (app.get(app.mouseX, app.mouseY) == app.color(195, 25, 8) || app.get(app.mouseX, app.mouseY) == app.color(1, 66, 195)) {
            this.overCasualFineDiningButton = true;
        } else if (app.get(app.mouseX, app.mouseY) == app.color(196, 26, 9) || app.get(app.mouseX, app.mouseY) == app.color(2, 67, 196)) {
            this.overFineDiningButton = true;
        } else if (app.mouseX >= 50 && app.mouseX <= 350 && app.mouseY >= 355 && app.mouseY <= 445) {
            this.overHomePageButton = true;
        } else if (app.mouseX >= 1214 && app.mouseX <= 1514 && app.mouseY >= 860 && app.mouseY <= 940) {
            this.overRestartButton = true;
        } else {
            this.overCheapEatsButton = false;
            this.overCasualFineDiningButton = false;
            this.overFineDiningButton = false;
            this.overHomePageButton = false;
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
            app.fill(88,57,39);
            app.text("HOME PAGE", 200, 400);

            if (app.clicked == true) {
                app.currentPage = app.homePage;
            }

        } else if (this.overCheapEatsButton == true && this.restaurantGenerated == false) {
            app.cursor(HAND);
            app.textFont(this.headerFont);
            app.textSize(45);
            app.fill(0, 65, 194);
            app.text("CHEAP EATS", 1300, 400);

            if (app.clicked == true) {
                this.restaurantGenerated = true;
                this.restaurant = this.cheapEats.get(this.indexCheapEats);
            }

        } else if (this.overCasualFineDiningButton == true && this.restaurantGenerated == false) {
            app.cursor(HAND);
            app.textFont(this.headerFont);
            app.textSize(45);
            app.fill(1, 66, 195);
            app.text("CASUAL FINE DINING", 1300, 600);

            if (app.clicked == true) {
                this.restaurantGenerated = true;
                this.restaurant = this.casualFineDining.get(this.indexCasualFineDining);
            }

        } else if (this.overFineDiningButton == true && this.restaurantGenerated == false) {
            app.cursor(HAND);
            app.textFont(this.headerFont);
            app.textSize(45);
            app.fill(2, 67, 196);
            app.text("FINE DINING", 1300, 800);

            if (app.clicked == true) {
                this.restaurantGenerated = true;
                this.restaurant = this.fineDining.get(this.indexFineDining);
            }

        } else if (this.overRestartButton == true && this.restaurantGenerated == true) {
            app.cursor(HAND);

            app.fill(248, 252, 240);
            app.rectMode(CENTER);
            app.rect(1364, 900, 320, 100, 20, 20, 20, 20);
    
            app.textFont(this.headerFont);
            app.textSize(45);
            app.fill(88,57,39);
            app.text("RESTART", 1364, 900);

            if (app.clicked == true) {
                this.restaurantGenerated = false;
                this.setData();
            }

        } else {
            app.cursor(ARROW);
        }
    }

    public void generation() {
        if (this.restaurantGenerated == true) {
            app.fill(88,57,39);
            app.rectMode(CENTER);
            app.rect(782, 600, (40*this.restaurant.length()), 140, 20, 20, 20, 20);

            app.textFont(this.headerFont);
            app.strokeWeight(80);
            app.textSize(70);
            app.fill(248, 252, 240);
            app.text(this.restaurant, 782, 600);
        }
    }

    public void highlightHeader() {

    }
    
}
