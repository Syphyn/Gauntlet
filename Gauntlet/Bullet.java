import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Particle
{
    BackgroundPlayer display;
    SolidPlayer level;
    AreaPlayer hit;
    int life;

    public Bullet(double vx, double vy)
    {
        super();
        getImage().setTransparency(0);

        display = new BackgroundPlayer(this);
        display.add("right", "Particle", 512, 512, 21, 22);
        display.add("diag", "Particle", 512, 512, 23, 24);
        display.add("up", "Particle", 512, 512, 25, 26);
        addPlayer(display);

        level = new SolidPlayer(this, "PARTICLE", "LEVEL");
        level.add("default", "Collision", 10, 10, 0, 0);
        addPlayer(level);
        level.play("default", false, 0);

        hit = new AreaPlayer(this, "ENEMY_HIT", "PLAYER_BOX");
        hit.add("default", "Collision", 5, 5, 2, 2);
        addPlayer(hit);
        hit.play("default", false, 0);

        setV(vx, vy);
        updateAnim();

        life = 25;
    }

    public void update()
    {
        super.update();

        applyVel();
        updateAnim();
        hit();

        life--;
        if (life <= 0 || !level.getTouching().isEmpty())
            delete();
    }

    public void updateAnim()
    {
        if (getVX() < 0)
        {
            if (getVY() < 0)
            {
                display.setFlip(true, false);
                display.play("diag", true, 5);
            }
            else if (getVY() > 0)
            {
                display.setFlip(true, true);
                display.play("diag", true, 5);
            }
            else
            {
                display.setFlip(true, false);
                display.play("right", true, 5);
            }
        }
        else if (getVX() > 0)
        {
            if (getVY() < 0)
            {
                display.setFlip(false, false);
                display.play("diag", true, 5);
            }
            else if (getVY() > 0)
            {
                display.setFlip(false, true);
                display.play("diag", true, 5);
            }
            else
            {
                display.setFlip(false, false);
                display.play("right", true, 5);
            }
        }
        else
        {
            if (getVY() < 0)
            {
                display.setFlip(false, false);
                display.play("up", true, 5);
            }
            else if (getVY() > 0)
            {
                display.setFlip(false, true);
                display.play("up", true, 5);
            }
        }
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
}
