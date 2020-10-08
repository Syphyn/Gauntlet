import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.*;

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageDisplay extends ExtendedActor
{
    private BackgroundPlayer display;

    public ImageDisplay(String name, int width, int height, int start, int end, boolean loop, int fps)
    {
        super();
        getImage().setTransparency(0);
        display = new BackgroundPlayer(this);
        display.add("default", name, width, height, start, end);
        display.play("default", loop, fps);
        addPlayer(display);
    }
}
