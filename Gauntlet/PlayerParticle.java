import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerParticle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerParticle extends Particle
{
    BackgroundPlayer display;
    int life;

    public PlayerParticle()
    {
        super();
        getImage().setTransparency(0);
        display = new BackgroundPlayer(this);
        display.add("default", "Particle", 1, 3, 27, 27);
        addPlayer(display);
        display.play("default", false, 0);
        life = Greenfoot.getRandomNumber(50);
    }

    public void update()
    {
        super.update();
        addForce(0, Math.signum(Greenfoot.getRandomNumber(2) - 1) * 0.2);
        if (isAtEdge())
            setV(0, 0);
        applyVel();

        life--;
        if (life <= 0)
            delete();
    }
}
