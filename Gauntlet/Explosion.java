import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Particle
{
    BackgroundPlayer display;

    public Explosion()
    {
        super();
        getImage().setTransparency(0);
        display = new BackgroundPlayer(this);
        display.add("default", "Particle", 256, 256, 4, 7);
        addPlayer(display);
        display.play("default", false, 20);
    }

    public void update()
    {
        super.update();
        if (isAtEdge())
            setV(0, 0);
        applyVel();

        if (display.isEnd())
            delete();
    }
}
