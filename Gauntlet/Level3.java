import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends Room
{
    /**
     * Constructor
     */
    public Level3()
    {
        super();
    }

    /**
     * Smooth update
     */
    public void update()
    {
        super.update();
        if (!getObjects(Boss.class).isEmpty())
            countDown();
    }
}
