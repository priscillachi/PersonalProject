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


public class BookTimePage extends Page {

    private boolean overHomePageButton = false;
    private boolean overGenerateButton = false;
    private ArrayList<PImage> bookPics = new ArrayList<PImage>();
    private ArrayList<String> books = new ArrayList<String>();
    private ArrayList<String> bookDescriptions = new ArrayList<String>();
    private int index = 0;
    private boolean bookGenerated = false;
    
    public BookTimePage(App app) {
        super(app);
    }

    public void setBackground() {
        this.backgroundImage = app.loadImage(app.getClass().getResource("book-time-background.jpeg").getPath().replace("%20", " "));        
    }

    public void setFont() {
        this.headerFont = app.createFont(app.getClass().getResource("Newake-Font-Demo.otf").getPath().replace("%20", " "), 100);
        this.textFont = app.createFont(app.getClass().getResource("WorkSans.ttf").getPath().replace("%20", " "), 100);
    }

    public void setImages() {

    }

    public void setData() {
        PImage redRising = app.loadImage(app.getClass().getResource("darrow.png").getPath().replace("%20", " "));
        this.bookPics.add(redRising);
        this.books.add("Red Rising Saga by Pierce Brown");
        this.bookDescriptions.add("Epic/high science fiction and space opera.");

        PImage bookOfTheAncestor = app.loadImage(app.getClass().getResource("nona.png").getPath().replace("%20", " "));
        this.bookPics.add(bookOfTheAncestor);
        this.books.add("Book of the Ancestor Series by Mark Lawrence");
        this.bookDescriptions.add("Epic/high fantasy series.");

        PImage mistborn = app.loadImage(app.getClass().getResource("vin.png").getPath().replace("%20", " "));
        this.bookPics.add(mistborn);
        this.books.add("Mistborn Saga by Brandon Sanderson");
        this.bookDescriptions.add("Epic/high fantasy series.");

        PImage firstLaw = app.loadImage(app.getClass().getResource("firstlaw.png").getPath().replace("%20", " "));
        this.bookPics.add(firstLaw);
        this.books.add("The First Law Trilogy by Joe Abercrombie");
        this.bookDescriptions.add("Epic/high fantasy and grimdark series.");

        PImage greatcoats = app.loadImage(app.getClass().getResource("falcio.png").getPath().replace("%20", " "));
        this.bookPics.add(greatcoats);
        this.books.add("Greatcoats Series by Sebastien de Castell");
        this.bookDescriptions.add("High fantasy inspired by The Three Musketeers.");

        PImage chronicleOfTheUnhewnThrone = app.loadImage(app.getClass().getResource("emperors-blades.png").getPath().replace("%20", " "));
        this.bookPics.add(chronicleOfTheUnhewnThrone);
        this.books.add("Chronicle of the Unhewn Throne Series by Brian Staveley");
        this.bookDescriptions.add("Epic/high fantasy series.");

        PImage sixScorchedRoses = app.loadImage(app.getClass().getResource("vale-lilith.png").getPath().replace("%20", " "));
        this.bookPics.add(sixScorchedRoses);
        this.books.add("Six Scorched Roses by Carissa Broadbent");
        this.bookDescriptions.add("Fantasy romance novel exploring mortality.");

        PImage datingIsh = app.loadImage(app.getClass().getResource("dating-ish.jpg").getPath().replace("%20", " "));
        this.bookPics.add(datingIsh);
        this.books.add("Dating-Ish by Penny Reid");
        this.bookDescriptions.add("Slow-burn romance between journalist & computer scientist.");

        PImage greatGatsby = app.loadImage(app.getClass().getResource("gatsby.jpg").getPath().replace("%20", " "));
        this.bookPics.add(greatGatsby);
        this.books.add("The Great Gatsby by F. Scott Fitzgerald");
        this.bookDescriptions.add("Classic novel surrounding human experiences.");

        this.index = app.random.nextInt(this.books.size());
    }

    public void generateRandom() {
        this.index = app.random.nextInt(this.books.size());
    }

    public void drawBackground() {
        app.background(this.backgroundImage);
    }

    public void drawHeader() {
        app.textFont(this.headerFont);
        app.stroke(248, 252, 240);
        app.textSize(150);
        app.textAlign(CENTER, CENTER);
        app.textAlign(CENTER, CENTER);
        app.fill(248, 252, 240);
        app.text("BOOK TIME", 782, 80);
        app.noStroke();
    }

    public void drawDescription() {
        app.textFont(this.textFont);
        app.fill(248, 252, 240);
        app.textSize(17);
        app.textAlign(CENTER, CENTER);
        app.text("So if you know me, you'd know I love books...", 290, 180);
        app.text("i.e. science fiction and fantasy (+ some romance and classics).", 290, 210);
        app.text("You would also know I have eight tattoos...", 290, 240);
        app.text("All of which are inspired by my favourite books...", 290, 270);
        app.text("So here are some of my favourite books ever...", 290, 300);
        app.text("Excuse the ellipses...", 290, 330);
        app.text("I am simply trying to be mysterious...", 290, 360);
        app.text("But alas, I am not xx", 290, 390);
        app.text("Click on the Generate button to generate a book.", 290, 420);
        app.text("Hold down on the button if you want it to keep generating.", 290, 450);
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

        app.fill(211, 211, 211);
        app.rectMode(CENTER);
        app.rect(1334, 956, 300, 90, 20, 20, 20, 20);

        app.textFont(this.headerFont);
        app.textSize(45);
        app.textAlign(CENTER, CENTER);
        app.fill(88,57,39);
        app.text("GENERATE", 1334, 956);
    }

    public void checkMouse() {

    }

    public void checkButton() {
        if (app.mouseX >= 50 && app.mouseX <= 350 && app.mouseY >= 35 && app.mouseY <= 125) {
            this.overHomePageButton = true;
            this.overGenerateButton = false;

        } else if (app.mouseX >= 1184 && app.mouseX <= 1484 && app.mouseY >= 911 && app.mouseY <= 1001) {
            this.overGenerateButton = true;
            this.overHomePageButton = false;

        } else {
            
            this.overHomePageButton = false;
            this.overGenerateButton = false;
        }
    }

    public void checkClickButton() {
    }

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
                this.bookGenerated = false;
                this.generateRandom();
            }

        } else if (this.overGenerateButton == true) {
            app.cursor(HAND);

            app.fill(248, 252, 240);
            app.rectMode(CENTER);
            app.rect(1334, 956, 320, 110, 20, 20, 20, 20);

            app.textFont(this.headerFont);
            app.textSize(45);
            app.textAlign(CENTER, CENTER);
            app.fill(88,57,39);
            app.text("GENERATE", 1334, 956);

            if (app.clicked == true) {
                this.bookGenerated = true;
                this.generateRandom();
            }

        } else {
            app.cursor(ARROW);
        }
    }

    public void highlightHeader() {

    }

    public void generation() {
        if (this.bookGenerated == true) {
            app.image(this.bookPics.get(this.index), 1350, 300);

            app.fill(255);
            app.rectMode(CENTER);
            app.rect(1200, 700, (15*this.books.get(this.index).length()), 46, 20, 20, 20, 20);
            app.textFont(this.textFont);
            app.textSize(25);
            app.textAlign(CENTER, CENTER);
            app.fill(0);
            app.text(this.books.get(this.index), 1200, 700);

            app.fill(255);
            app.rectMode(CENTER);
            app.rect(1200, 750, (15*this.bookDescriptions.get(this.index).length()), 45, 20, 20, 20, 20);
            app.textFont(this.textFont);
            app.textSize(20);
            app.textAlign(CENTER, CENTER);
            app.fill(0);
            app.text(this.bookDescriptions.get(this.index), 1200, 750);
        }
    }
}
