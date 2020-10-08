import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends Room
{
    /**
     * Constructor
     */
    public Level2()
    {
        super();
    }

    public void update()
    {
        super.update();
        if (!getObjects(ExtendedActor.class).isEmpty())
        {
            for (ExtendedActor actor : getObjects(ExtendedActor.class))
            {
                if (actor.getY() > Options.HEIGHT - 2)
                {
                    actor.setVY(-Options.EDGE_PUSH * 1.50);
                    if (actor instanceof Player)
                        ((Player) actor).airJumpAvail = true;
                }
            }
        }
        countDown();
    }
}
