import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion2 extends Particle
{
    BackgroundPlayer display;

    public Explosion2()
    {
        super();
        getImage().setTransparency(0);
        display = new BackgroundPlayer(this);
        display.add("default", "Particle", 256, 256, 8, 11);
        addPlayer(display);
        display.play("default", false, 10);
    }

    public void start()
    {
        super.start();
        Greenfoot.playSound("Explosion15.wav");
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
