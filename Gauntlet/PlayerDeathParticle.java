import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerDeathParticle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerDeathParticle extends Particle
{
    MidgroundPlayer display;
    SolidPlayer level;

    int life = 100;
    public PlayerDeathParticle()
    {
        super();
        getImage().setTransparency(0);

        level = new SolidPlayer(this, "PLAYER", "LEVEL");
        level.add("default", "Collision", 40, 70, 0, 0);
        level.setOffset(0, 90);
        addPlayer(level);
        level.play("default", false, 0);

        display = new MidgroundPlayer(this);
        display.add("air", "One", 256, 256, 42, 42);
        display.add("ground", "One", 256, 256, 43, 43);
        display.setOffset(0, 110);
        addPlayer(display);
        refreshDisplay();
    }

    public void update()
    {
        super.update();

        addForce(0, Options.GRAVITY);
        addForce(-Math.signum(getVX()) * Options.DEATH_X_FRICTION, 0);
        if (Math.abs(getVX()) < Options.DEATH_X_FRICTION)
            setVX(0);

        refreshDisplay();
        if (getX() > Options.WIDTH - 2 || getX() < 2)
            setVX(0);
        applyVel();

        if (life >= 50 && Greenfoot.getRandomNumber(10) == 0)
        {
            ((Room) Global.world).freeze(Options.FREEZE_FRAME / 2);
            ((GameWorld) Global.world).freeAddObject(new Explosion2(), display.getX() + Greenfoot.getRandomNumber(101) - 50, display.getY() + Greenfoot.getRandomNumber(101) - 50);
        }

        life--;
        if (life <= 0)
        {
            GreenfootImage img = display.getImage();
            for (int x = 0; x < img.getWidth(); x++)
                for (int y = 0; y < img.getHeight(); y++)
                    if (img.getColorAt(x, y).getAlpha() != 0 && Greenfoot.getRandomNumber(1) == 0)
                        ((GameWorld) Global.world).freeAddObject(new PlayerParticle(), getX() + x - img.getWidth() / 2, getY() + y - img.getHeight() / 2 + 110);
            ((GameWorld) Global.world).freeAddObject(new Lightning(), display.getX(), display.getY());
            ((Room) Global.world).freeze(Options.FREEZE_FRAME);
            delete();
            ((Room) Global.world).gameOver(Options.GAMEOVER_WAIT);
        }
        else
        {
            GreenfootImage img = display.getImage();
            for (int x = 0; x < img.getWidth(); x++)
                for (int y = 0; y < img.getHeight(); y++)
                    if (img.getColorAt(x, y).getAlpha() != 0 && Greenfoot.getRandomNumber(1000) == 0)
                        ((GameWorld) Global.world).freeAddObject(new PlayerParticle(), getX() + x - img.getWidth() / 2, getY() + y - img.getHeight() / 2 + 110);
        }
    }

    public void refreshDisplay()
    {
        if (getVX() < 0)
            display.setFlip(false, false);
        else if (getVX() > 0)
            display.setFlip(true, false);

        if (level.getClippingDown(1).isEmpty())
            display.play("air", false, 0);
        else
            display.play("ground", false, 0);
    }
}
