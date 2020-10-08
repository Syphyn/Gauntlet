import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DamageActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DamageActor extends GameActor
{
    private int health;
    private long nextDamage;
    private long invulTime;
    private boolean invul;

    public void setInvulTime(long invulTime)
    {
        this.invulTime = invulTime;
    }

    public boolean getInvul()
    {
        return invul;
    }

    public void hurt(int xPos, int yPos, int health)
    {
        if (!invul)
        {
            this.health -= health;
            if (this.health <= 0)
                die(xPos, yPos);
            nextDamage = System.currentTimeMillis() + invulTime;
            stun();
        }
    }

    public void stun()
    {
    }

    public void update()
    {
        super.update();
        if (System.currentTimeMillis() > nextDamage)
            invul = false;
        else
            invul = true;
    }

    public void die(int xPos, int yPos)
    {
        delete();
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getHealth()
    {
        return health;
    }
}
