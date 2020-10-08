import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends Room
{
    /**
     * Constructor
     */
    public Tutorial()
    {
        super();
    }

    /**
     * Adds standard menu items, except for time
     */
    public void enter()
    {
        setNextTime(System.currentTimeMillis() + Options.INTERVAL);
        freeAddObject(new HeartDisplay((DamageActor) getObjects(Player.class).get(0), Options.PLAYER_MAX_HEALTH), Options.HEART_X, Options.HEART_Y);
        freeAddObject(new ScoreDisplay(), Options.SCORE_X, Options.SCORE_Y);
    }
}
