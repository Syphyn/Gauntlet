import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Enemy1 here.
 * 
 * @author Danny Vo
 * @version (a version number or a date)
 */
public class Slime2 extends Enemy
{
    long nextJumpAvail;

    public Slime2()
    {
        super();

        display = new MidgroundPlayer(this);
        display.add("idle", "Slime-II", 50, 50, 1, 9);
        display.add("jump", "Slime-II", 50, 50, 10, 18);
        addPlayer(display);
        display.play("idle", true, 10);

        level = new SolidPlayer(this, "ENEMY", "LEVEL");
        level.add("default", "Collision", 50, 50, 0, 0);
        addPlayer(level);
        level.play("default", false, 0);

        box = new AreaPlayer(this, "ENEMY_BOX", "PLAYER_HIT");
        box.add("default", "Collision", 50, 50, 1, 1);
        addPlayer(box);
        box.play("default", false, 0);

        hit = new AreaPlayer(this, "ENEMY_HIT", "PLAYER_BOX");
        hit.add("default", "Collision", 25, 25, 2, 2);
        addPlayer(hit);
        hit.play("default", false, 0);

        setHealth(2);
        setInvulTime(300);
        setBounce(0.5);

        refreshJump();
    }

    public void update()
    {
        super.update();
        addForce(0, Options.GRAVITY);
        AIActions();

        addForce(-Math.signum(getVX()) * Options.SLIME_X_FRICTION, 0);
        if (Math.abs(getVX()) < Options.SLIME_X_FRICTION)
            setVX(0);

        if (level.getClippingDown(1).isEmpty())
        {
            hit();
            display.play("jump", true, 10, true);
        }
        else
            display.play("idle", true, 10, true);

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

        ((GameWorld) Global.world).freeAddObject(new TrailParticle(), getX(), getY() + 15);
    }

    public void refreshJump()
    {
        nextJumpAvail = System.currentTimeMillis() + Options.SLIME_JUMP_INTERVAL;
    }

    public void AIActions()
    {
        if (!Global.world.getObjects(Player.class).isEmpty())
        {
            Player player = Global.world.getObjects(Player.class).get(0);
            double dist = Math.sqrt(Math.pow(player.getX() - getX(), 2) + Math.pow(player.getY() - getY(), 2));
            if (dist < Options.SLIME_SIGHT_RADIUS)
            {
                if (player.getX() < getX())
                    addForce(-0.2, 0);
                if (player.getX() > getX())
                    addForce(0.2, 0);
                if (!level.getClippingDown(1).isEmpty() && System.currentTimeMillis() > nextJumpAvail)
                {
                    if (player.getX() < getX())
                    {
                        if (Greenfoot.getRandomNumber(3) == 0)
                        {
                            setV(10, -15);
                            Greenfoot.playSound("353250__zuzek06__slimejump.wav");
                            refreshJump();
                        }
                        else
                        {
                            setV(-10, -15);
                            Greenfoot.playSound("353250__zuzek06__slimejump.wav");
                            refreshJump();
                        }
                    }
                    else if (player.getX() > getX())
                    {
                        if (Greenfoot.getRandomNumber(3) == 0)
                        {
                            setV(-10, -15);
                            Greenfoot.playSound("353250__zuzek06__slimejump.wav");
                            refreshJump();
                        }
                        else
                        {
                            setV(10, -15);
                            Greenfoot.playSound("353250__zuzek06__slimejump.wav");
                            refreshJump();
                        }
                    }
                }
            }
            else
            {
                int random = Greenfoot.getRandomNumber(5);
                if (!level.getClippingDown(1).isEmpty() && System.currentTimeMillis() > nextJumpAvail)
                {
                    if (random == 1)
                    {
                        setV(-10, -15);
                        Greenfoot.playSound("353250__zuzek06__slimejump.wav");
                        refreshJump();
                    }
                    else if (random == 2)
                    {
                        setV(10, -15);
                        Greenfoot.playSound("353250__zuzek06__slimejump.wav");
                        refreshJump();
                    }
                }
            }
        }
    }

    public void stun()
    {
        if (!getInvul())
            refreshJump();
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
        Global.score += 100;
    }
}
