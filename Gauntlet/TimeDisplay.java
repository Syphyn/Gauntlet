import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimeDisplay extends ExtendedActor
{
    GreenfootImage image;

    public TimeDisplay()
    {
        super();
        image = new GreenfootImage(256, 256);
        image.setColor(Color.WHITE);
        image.setFont(new Font(true, false, 12));
        image.drawString(String.valueOf(Global.time), image.getWidth() / 2, image.getHeight() / 2 + 10);
        setImage(image);
    }

    public void update()
    {
        super.update();
        image.clear();
        image.setColor(Color.WHITE);
        image.setFont(new Font(true, false, 12));
        image.drawString(String.valueOf(Global.time), image.getWidth() / 2, image.getHeight() / 2 + 10);
        setImage(image);
    }
}
