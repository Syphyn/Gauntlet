import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * All objects that are considered game actors are objects that are in game and are not just to help game actor
 * 
 * @author Duy Pham
 * @version 1-23-17
 */
public class GameActor extends ExtendedActor
{
    /**
     * Constructor
     */
    public GameActor()
    {
        super();
        if (!Options.PLACEHOLDER)
            getImage().setTransparency(0);
    }

    public void start()
    {
        super.start();
        if (Options.PLACEHOLDER)
            getImage().setTransparency(0);
    }

    public GameActor copy()
    {
        return null;
    }
}
