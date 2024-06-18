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

public class App extends PApplet {

    public static int WIDTH = 1564;
    public static int HEIGHT = 1036; 

    public static final int FPS = 60;

    public static Random random = new Random();

    public HomePage homePage = new HomePage(this);
    public RussianRoulettePage russianRoulettePage = new RussianRoulettePage(this);
    public MovieTimePage movieTimePage = new MovieTimePage(this);
    public BookTimePage bookTimePage = new BookTimePage(this);
    public LinguisticsTriviaPage linguisticsTriviaPage = new LinguisticsTriviaPage(this);

    public Page currentPage = this.homePage;

    public boolean clicked = false;

    public App() {
        ;
    }

    /**
     * Initialise the setting of the window size.
     */
	@Override
    public void settings() {
        //GLProfile.initSingleton();
        size(WIDTH, HEIGHT);
    }

    /**
     * Load all resources such as images. Initialise the elements such as the player and map elements.
     */
	@Override
    public void setup() {

        frameRate(FPS);

        this.homePage.setBackground();
        this.homePage.setFont();
        this.homePage.setImages();
        this.homePage.setData();

        this.russianRoulettePage.setBackground();
        this.russianRoulettePage.setFont();
        this.russianRoulettePage.setImages();
        this.russianRoulettePage.setData();

        this.movieTimePage.setBackground();
        this.movieTimePage.setFont();
        this.movieTimePage.setImages();
        this.movieTimePage.setData();

        this.bookTimePage.setBackground();
        this.bookTimePage.setFont();
        this.bookTimePage.setImages();
        this.bookTimePage.setData();

        this.linguisticsTriviaPage.setBackground();
        this.linguisticsTriviaPage.setFont();
        this.linguisticsTriviaPage.setImages();
        this.linguisticsTriviaPage.setData();
    }

    /**
     * Receive key pressed signal from the keyboard.
     */
	@Override
    public void keyPressed(KeyEvent event){
        
    }

    /**
     * Receive key released signal from the keyboard.
     */
	@Override
    public void keyReleased(){
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.clicked = true;
        this.currentPage.checkClickButton();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.clicked = false;
    }

    @Override
    public void mouseMoved() {
        this.currentPage.checkMouse();
        this.currentPage.checkButton();
    }

    @Override
    public void mouseDragged() {
        this.currentPage.checkMouse();
        this.currentPage.checkButton(); 
    }

    /**
     * Draw all elements in the game by current frame.
     */
	@Override
    public void draw() {
        this.currentPage.checkMouse();
        this.currentPage.checkButton();
        this.currentPage.drawBackground();
        this.currentPage.drawHeader();
        this.currentPage.highlightHeader();
        this.currentPage.drawDescription();
        this.currentPage.drawButtons();
        this.currentPage.highlightButton();
        this.currentPage.generation();


        //----------------------------------
        //display HUD:
        //----------------------------------
        //TODO

        //----------------------------------
        //display scoreboard:
        //----------------------------------
        //TODO
        
		//----------------------------------
        //----------------------------------

        //TODO: Check user action
    }


    public static void main(String[] args) {
        PApplet.main("PersonalProject.App");
    }

}
