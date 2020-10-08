import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cardinal extends Enemy
{
    long nextDashAvail;
    boolean cycle;

    boolean hittingLeft;
    boolean hittingRight;
    boolean hittingUp;
    boolean hittingDown;

    public Cardinal()
    {
        super();

        display = new MidgroundPlayer(this);
        display.add("idle", "Cardinal", 45, 45, 1, 6);
        addPlayer(display);
        display.play("idle", true, 10);

        level = new SolidPlayer(this, "ENEMY", "LEVEL");
        level.add("default", "Collision", 45, 45, 0, 0);
        addPlayer(level);
        level.play("default", false, 0);

        box = new AreaPlayer(this, "ENEMY_BOX", "PLAYER_HIT");
        box.add("default", "Collision", 45, 45, 1, 1);
        addPlayer(box);
        box.play("default", false, 0);

        hit = new AreaPlayer(this, "ENEMY_HIT", "PLAYER_BOX");
        hit.add("default", "Collision", 45, 45, 2, 2);
        addPlayer(hit);
        hit.play("default", false, 0);

        setHealth(1);
        setInvulTime(300);
        setBounce(0.5);

        refreshDash();
    }

    public void update()
    {
        super.update();
        AIActions();
        hit();

        addForce(-Math.signum(getVX()) * Options.CARDINAL_FRICTION, 0);
        if (Math.abs(getVX()) < Options.CARDINAL_FRICTION)
            setVX(0);

        addForce(0, -Math.signum(getVY()) * Options.CARDINAL_FRICTION);
        if (Math.abs(getVY()) < Options.CARDINAL_FRICTION)
            setVY(0);

        applyVel();

        if (getInvul())
        {
            if (Global.updateTime % Options.INVUL_BLINK_RATE == 0)
            {
                if (display.getStyle() != Style.WHITE)
                    display.setStyle(Style.WHITE);
                else
                    display.setStyle(Style.DEFAULT);
            }
        }
        else
            display.setStyle(Style.DEFAULT);

        ((GameWorld) Global.world).freeAddObject(new TrailParticle(), getX(), getY());
        wallHit();
    }

    public void wallHit()
    {
        if (hittingLeft)
        {
            if (level.getClippingLeft(1).isEmpty())
            {
                hittingLeft = false;
            }
        }
        else
        {
            if (!level.getClippingLeft(1).isEmpty())
            {
                hittingLeft = true;
                Greenfoot.playSound("Hit_Hurt7.wav");
            }
        }

        if (hittingRight)
        {
            if (level.getClippingRight(1).isEmpty())
            {
                hittingRight = false;
            }
        }
        else
        {
            if (!level.getClippingRight(1).isEmpty())
            {
                hittingRight = true;
                Greenfoot.playSound("Hit_Hurt7.wav");
            }
        }

        if (hittingUp)
        {
            if (level.getClippingUp(1).isEmpty())
            {
                hittingUp = false;
            }
        }
        else
        {
            if (!level.getClippingUp(1).isEmpty())
            {
                hittingUp = true;
                Greenfoot.playSound("Hit_Hurt7.wav");
            }
        }

        if (hittingDown)
        {
            if (level.getClippingDown(1).isEmpty())
            {
                hittingDown = false;
            }
        }
        else
        {
            if (!level.getClippingDown(1).isEmpty())
            {
                hittingDown = true;
                Greenfoot.playSound("Hit_Hurt7.wav");
            }
        }
    }

    public void refreshDash()
    {
        nextDashAvail = System.currentTimeMillis() + Options.CARDINAL_DASH_INTERVAL;
    }

    public void AIActions()
    {
        if (!Global.world.getObjects(Player.class).isEmpty())
        {
            Player player = Global.world.getObjects(Player.class).get(0);

            if (System.currentTimeMillis() > nextDashAvail)
            {
                if (cycle)
                {
                    if (player.getX() < getX())
                        setV(-Options.CARDINAL_DASH_VEL, 0);
                    else
                        setV(Options.CARDINAL_DASH_VEL, 0);
                    refreshDash();
                }
                else
                {
                    if (player.getY() < getY())
                        setV(0, -Options.CARDINAL_DASH_VEL);
                    else
                        setV(0, Options.CARDINAL_DASH_VEL);
                    refreshDash();
                }
                cycle = !cycle;
            }
        }
    }

    public void stun()
    {
        if (!getInvul())
            refreshDash();
    }

    public void hit()
    {
        if (!hit.getClipping().isEmpty())
        {
            Player player = (Player) hit.getClipping().get(0).getParent();
            if (!player.getInvul())
            {
                for (int i = 0; i < 10; i++)
                    ((GameWorld) Global.world).freeAddObject(new HitParticle(), hit.getX(), hit.getY());
                ((Room) Global.world).freeze(Options.FREEZE_FRAME);
            }
            player.hurt(getX(), getY(), 1);
        }
    }

    public void die(int xPos, int yPos)
    {
        GreenfootImage img = display.getImage();
        for (int x = 0; x < img.getWidth(); x++)
            for (int y = 0; y < img.getHeight(); y++)
                if (img.getColorAt(x, y).getAlpha() != 0 && Greenfoot.getRandomNumber(10) == 0)
                    ((GameWorld) Global.world).freeAddObject(new EnemyParticle(), getX() + x - img.getWidth() / 2, getY() + y - img.getHeight() / 2);
        ((GameWorld) Global.world).freeAddObject(new Explosion(), display.getX(), display.getY());
        Greenfoot.playSound("Explosion15.wav");
        super.die(xPos, yPos);
        Global.score += 200;
    }
}
