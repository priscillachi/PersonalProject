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

public abstract class Page {

    protected PImage backgroundImage;
    protected App app;
    protected PFont headerFont;
    protected PFont textFont;

    public Page(App app) {
        this.app = app;
    }

    public abstract void setBackground();
    public abstract void setFont();
    public abstract void setImages();
    public abstract void setData();
    public abstract void generateRandom();

    public abstract void drawBackground();
    public abstract void drawHeader();
    public abstract void drawDescription();
    public abstract void drawButtons();

    public abstract void checkMouse();
    public abstract void checkButton();
    public abstract void checkClickButton();
    public abstract void highlightButton();
    public abstract void highlightHeader();
    public abstract void generation();


}
