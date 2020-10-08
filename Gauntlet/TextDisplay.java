import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextDisplay extends ExtendedActor
{
    GreenfootImage image;

    public TextDisplay(int width, int height, int x, int y, Color bgColor, Color textColor, String text)
    {
        super();
        image = new GreenfootImage(width, height);
        image.setColor(bgColor);
        image.fill();
        image.setColor(textColor);
        image.drawString(text, x, y);
        setImage(image);
    }
}
