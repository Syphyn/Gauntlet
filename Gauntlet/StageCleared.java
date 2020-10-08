import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class LevelSelection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StageCleared extends GameWorld
{
    private long stageClearedEnd;
    private boolean inMenu = true;

    /**
     * Constructor for objects of class LevelSelection.
     * 
     */
    public StageCleared()
    {
        super();
        stageClearedEnd = System.currentTimeMillis() + Options.CLEAR_SCREEN_WAIT;
        freeAddObject(new ImageDisplay("ActCleared", Options.WIDTH, Options.HEIGHT, 1, 1, true, 5), Options.WIDTH / 2, Options.HEIGHT / 2);

        Global.stopMusic();
        Global.win.play();
    }

    /**
     * Smoothly updates
     */
    public void update()
    {
        super.update();
        if (System.currentTimeMillis() > stageClearedEnd)   //after a delay, switch to name enter screen
        {
            NameEnter nameEnter = new NameEnter();
            Greenfoot.setWorld(nameEnter);
        }
    }
}
