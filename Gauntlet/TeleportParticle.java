import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TeleportParticle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TeleportParticle extends Particle
{
    BackgroundPlayer display;
    int life;

    public TeleportParticle()
    {
        super();
        getImage().setTransparency(0);
        display = new BackgroundPlayer(this);
        display.add("default", "Particle", 1, 3, 2, 2);
        addPlayer(display);
        display.play("default", false, 0);
        life = Greenfoot.getRandomNumber(60);
    }

    public void update()
    {
        super.update();
        if (isAtEdge())
            setV(0, 0);
        applyVel();

        life--;
        if (life <= 0)
            delete();
    }
}
