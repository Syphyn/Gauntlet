import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Room
{
    /**
     * Constructor
     */
    public Level1()
    {
        super();
    }

    /**
     * Smooth update
     */
    public void update()
    {
        super.update();
        if (!getObjects(ExtendedActor.class).isEmpty())
        {
            for (ExtendedActor actor : getObjects(ExtendedActor.class))
            {
                if (actor.getX() < 2)
                {
                    actor.setVX(Options.EDGE_PUSH);
                }
            }
        }
        countDown();
    }
}
