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

public class HomePage extends Page {

    private boolean header = true;
    private boolean description = false;
    private PImage instagramLogo;
    private PImage spotifyLogo;
    private PImage facebookLogo;
    private PImage linkedinLogo;
    private PImage russianRoulette;
    private PImage movieTime;
    private boolean overInstagramButton = false;
    private boolean overSpotifyButton = false;
    private boolean overFacebookButton = false;
    private boolean overLinkedinButton = false;
    private boolean overXButton = false;
    private boolean overRussianRouletteButton = false;
    private boolean overMovieTimeButton = false;

    public HomePage(App app) {
        super(app);
    }

    public void setBackground() {
        this.backgroundImage = app.loadImage(app.getClass().getResource("homepageBackground.JPG").getPath().replace("%20", " "));
    }

    public void setImages() {
        this.instagramLogo = app.loadImage(app.getClass().getResource("instagram-logo.png").getPath().replace("%20", " "));
        this.spotifyLogo = app.loadImage(app.getClass().getResource("spotify-logo.png").getPath().replace("%20", " "));
        this.facebookLogo = app.loadImage(app.getClass().getResource("facebook-logo.png").getPath().replace("%20", " "));
        this.linkedinLogo = app.loadImage(app.getClass().getResource("linkedin-logo.png").getPath().replace("%20", " "));
        this.russianRoulette = app.loadImage(app.getClass().getResource("russian-roulette.png").getPath().replace("%20", " "));
        this.movieTime = app.loadImage(app.getClass().getResource("movie-time.png").getPath().replace("%20", " "));
    }

    public void drawBackground() {
        app.background(this.backgroundImage);
    }

    public void setFont() {
        this.headerFont = app.createFont(app.getClass().getResource("Newake-Font-Demo.otf").getPath().replace("%20", " "), 100);
        this.textFont = app.createFont(app.getClass().getResource("WorkSans.ttf").getPath().replace("%20", " "), 100);
    }

    public void setData() {
    }

    public void drawHeader() {
        //app.rectMode(CENTER);
        //app.fill(255);
        //app.noStroke();
        //app.rect(465, 465, 600, 600, 20, 20, 20, 20);
        if (this.header == true) {
            app.textFont(this.headerFont);
            app.stroke(248, 252, 240);
            app.textSize(150);
            app.textAlign(CENTER, CENTER);
            app.fill(248, 252, 240);
            app.text("PRISCILLA", 782, 173);
            app.noStroke();
        }

        if (this.description == false) {
            app.textFont(this.textFont);
            app.textSize(25);
            app.textAlign(CENTER, CENTER);
            app.fill(255);
            app.text("Some call this narcissism... But click my name above to access the features of this (wonderful) app.", 782, 840);
            app.text("I jest - it's a horrible app, and I will die of mortification after you see it. Also, I did not fuck up the graphics!", 782, 880);
            app.text("This is a picture of my friend Amayah (left) and me (right) taken on a vintage film camera, hence why it is grainy.", 782, 920);
            app.text("The photo is naturally like that. I may be stupid, but not THAT stupid where I'd mess up the graphics...", 782, 960);
        }
    }

    public void checkMouse() {
        if (app.get(app.mouseX, app.mouseY) == app.color(248, 252, 240) || app.get(app.mouseX, app.mouseY) == app.color(88,57,39)) {
            this.header = false;
            app.cursor(HAND);
        }

        if (app.get(app.mouseX, app.mouseY) == app.color(88,57,39)) {
            this.header = false;
            
            if (this.description == false) {
                app.cursor(HAND);
            } else {
                app.cursor(ARROW);
            }
        }

        if (app.get(app.mouseX, app.mouseY) != app.color(248, 252, 240) && app.get(app.mouseX, app.mouseY) != app.color(88,57,39) && this.description != true) {
            this.header = true;
            app.cursor(ARROW);
        }
    }

    public void checkButton() {
        if (this.description == true) {
            if (app.mouseX >= 432 && app.mouseX <= 532 && app.mouseY >=350 && app.mouseY <= 450) {
                this.overInstagramButton = true;

            } else if (app.mouseX >= 632 && app.mouseX <= 732 && app.mouseY >=350 && app.mouseY <= 450) {
                this.overFacebookButton = true;

            } else if (app.mouseX >= 832 && app.mouseX <= 932 && app.mouseY >=350 && app.mouseY <= 450) {
                this.overLinkedinButton = true;

            } else if (app.mouseX >= 1032 && app.mouseX <= 1132 && app.mouseY >=350 && app.mouseY <= 450) {
                this.overSpotifyButton = true;

            } else if (app.mouseX >= 1130 && app.mouseX <= 1170 && app.mouseY >=310 && app.mouseY <= 350) {
                this.overXButton = true;

            } else if (app.mouseX >= 410 && app.mouseX <= 490 && app.mouseY >=690 && app.mouseY <= 770) {
                this.overRussianRouletteButton = true;

            } else if (app.mouseX >= 500 && app.mouseX <= 580 && app.mouseY >=690 && app.mouseY <= 770) {
                this.overMovieTimeButton = true;
                
            } else {
                this.overInstagramButton = false;
                this.overFacebookButton = false;
                this.overLinkedinButton = false;
                this.overSpotifyButton = false;
                this.overXButton = false;
                this.overRussianRouletteButton = false;
                this.overMovieTimeButton = false;
            }

        } else {
            this.overInstagramButton = false;
            this.overFacebookButton = false;
            this.overLinkedinButton = false;
            this.overSpotifyButton = false;
            this.overXButton = false;
            this.overRussianRouletteButton = false;
            this.overMovieTimeButton = false;
        }
    }

    public void highlightButton() {
        if (this.description == true) {
            if (this.overInstagramButton == true) {
                app.cursor(HAND);
                app.rectMode(CENTER);
                app.fill(211, 211, 211);
                app.rect(482, 400, 150, 150, 20, 20, 20, 20);
                app.image(this.instagramLogo, 482, 400, 100, 100);

                app.stroke(1, 2, 3);
                app.strokeWeight(5);
                app.line(1140, 320, 1160, 340);
                app.line(1140, 340, 1160, 320);
                app.noStroke();

            } else if (this.overFacebookButton == true) {
                app.cursor(HAND);
                app.rectMode(CENTER);
                app.fill(211, 211, 211);
                app.rect(682, 400, 150, 150, 20, 20, 20, 20);
                app.image(this.facebookLogo, 682, 400, 100, 100);

                app.stroke(1, 2, 3);
                app.strokeWeight(5);
                app.line(1140, 320, 1160, 340);
                app.line(1140, 340, 1160, 320);
                app.noStroke();

            } else if (this.overLinkedinButton == true) {
                app.cursor(HAND);
                app.rectMode(CENTER);
                app.fill(211, 211, 211);
                app.rect(882, 400, 150, 150, 20, 20, 20, 20);
                app.image(this.linkedinLogo, 882, 400, 100, 100);

                app.stroke(1, 2, 3);
                app.strokeWeight(5);
                app.line(1140, 320, 1160, 340);
                app.line(1140, 340, 1160, 320);
                app.noStroke();

            } else if (this.overSpotifyButton == true) {
                app.cursor(HAND);
                app.rectMode(CENTER);
                app.fill(211, 211, 211);
                app.rect(1082, 400, 150, 150, 20, 20, 20, 20);
                app.image(this.spotifyLogo, 1082, 400, 100, 100);

                app.stroke(1, 2, 3);
                app.strokeWeight(5);
                app.line(1140, 320, 1160, 340);
                app.line(1140, 340, 1160, 320);
                app.noStroke();

            } else if (this.overXButton == true) {
                app.cursor(HAND);
                app.rectMode(CENTER);
                app.fill(211, 211, 211);
                app.rect(1150, 330, 40, 40, 20, 20, 20, 20);

                app.stroke(1, 2, 3);
                app.strokeWeight(5);
                app.line(1140, 320, 1160, 340);
                app.line(1140, 340, 1160, 320);
                app.noStroke();

                if (app.clicked == true) {
                    this.description = false;
                }

            } else if (this.overRussianRouletteButton == true) {
                app.cursor(HAND);
                app.rectMode(CENTER);
                app.fill(211, 211, 211);
                app.rect(450, 730, 90, 90);

                app.imageMode(CENTER);
                app.image(this.russianRoulette, 450, 730, 80, 80);

                if (app.clicked == true) {
                    app.currentPage = app.russianRoulettePage;
                }

            } else if (this.overMovieTimeButton == true) {
                app.cursor(HAND);
                app.rectMode(CENTER);
                app.fill(211, 211, 211);
                app.rect(540, 730, 90, 90);

                app.imageMode(CENTER);
                app.image(this.movieTime, 540, 730, 80, 80);

                if (app.clicked == true) {
                    app.currentPage = app.movieTimePage;
                }

            } else {
                app.cursor(ARROW);
            }
        }
    }

    public void checkClickButton() {
        if (this.overInstagramButton == true) {
            app.link("https://www.instagram.com/priscillachi_/");
        } else if (this.overFacebookButton == true) {
            app.link("https://www.facebook.com/chilannguyenn/");
        } else if (this.overLinkedinButton == true) {
            app.link("https://www.linkedin.com/in/priscilla-nguyen-a0962a218/");
        } else if (this.overSpotifyButton == true) {
            app.link("https://open.spotify.com/user/hqspkj3ekhk1phi09w58jsklz?si=1590c15c25b04d98");
        }
    }

    public void highlightHeader() {
        if (this.header == false) {
            app.textFont(this.headerFont);
            app.stroke(88,57,39);
            app.textSize(160);
            app.textAlign(CENTER, CENTER);
            app.fill(88,57,39);
            app.text("PRISCILLA", 782, 173);
            app.noStroke();

            if (app.clicked == true) {
                this.description = true;
            }
            
        }
    }


    public void drawDescription() {
        if (this.description == true) {
            app.rectMode(CENTER);
            app.fill(251, 251, 253);
            app.noStroke();
            app.rect(782, 600, 800, 600, 20, 20, 20, 20);

            app.textFont(this.textFont);
            app.stroke(0);
            app.textSize(18);
            app.textAlign(CENTER, CENTER);
            app.fill(0);
            app.text("Welcome xx", 782, 495);
            app.text("please do not judge this app... it's a work in progress..", 782, 520);
            app.text("Click any of the above logos to check out my social media...", 782, 555);
            app.text("(not that I'd accept you anyway) x", 782, 580);
            app.text("Click any of the below for games.", 782, 615);
            app.text("They're kind of shit though, just warning you.", 782, 640);
            app.noStroke();
        }
    }

    public void drawButtons() {
        if (this.description == true) {

            app.imageMode(CENTER);
            app.image(this.instagramLogo, 482, 400, 100, 100);
            app.image(this.facebookLogo, 682, 400, 100, 100);
            app.image(this.linkedinLogo, 882, 400, 100, 100);
            app.image(this.spotifyLogo, 1082, 400, 100, 100);

            app.stroke(1, 2, 3);
            app.strokeWeight(5);
            app.line(1140, 320, 1160, 340);
            app.line(1140, 340, 1160, 320);
            app.noStroke();

            app.imageMode(CENTER);
            app.image(this.russianRoulette, 450, 730, 80, 80);
            app.image(this.movieTime, 540, 730, 80, 80);

            //app.rectMode(CENTER);
            //app.noStroke();
            //app.fill(2, 2, 2);
            //app.rect(1100, 860, 60, 10);
            //app.triangle(1130,845,1130,875,1150,860);
        }
    }

    public void generation() {
        
    }

    public void generateRandom() {
        
    }
    
}
