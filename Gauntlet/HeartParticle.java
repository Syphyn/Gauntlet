import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.*;

/**
 * Write a description of class HeartParticle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeartParticle extends Particle
{
    BackgroundPlayer display;
    int life;

    public HeartParticle()
    {
        super();
        getImage().setTransparency(0);
        display = new BackgroundPlayer(this);
        display.add("default", "Particle", 2, 2, 1, 1);
        addPlayer(display);
        display.play("default", false, 0);
        life = Greenfoot.getRandomNumber(30);
    }

    public void update()
    {
        super.update();
        addForce(Math.signum(Greenfoot.getRandomNumber(3) - 1) * 0.2, Math.signum(Greenfoot.getRandomNumber(4) - 1) * 0.2);
        if (isAtEdge())
            setV(0, 0);
        applyVel();

        life--;
        if (life <= 0)
            delete();
    }
}
