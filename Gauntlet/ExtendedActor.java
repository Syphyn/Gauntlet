import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
import java.util.*;

/**
 * Extends Actor class, adds velocity and other useful stuff
 * 
 * @author Duy Pham
 * @version 1-14-17
 */
public class ExtendedActor extends Actor
{
    private boolean start = true;
    private boolean isAlive = true;

    private ArrayList<AnimPlayer> animPlayers = new ArrayList<AnimPlayer>();
    private double bounce;

    private double x;
    private double y;
    private double vX;
    private double vY;

    /**
     * Constructor
     */
    public ExtendedActor()
    {
        super();
    }

    /**
     * Runs on first update
     */
    public void start()
    {
        addAnimObjects();
        refreshLocation();
    }

    /**
     * Smooth update
     */
    public void update()
    {
        if (start)
        {
            start();
            start = false;
        }
    }

    /**
     * Adds all anim players to the world
     */
    public void addAnimObjects()
    {
        List<AnimPlayer> players = Global.world.getObjects(AnimPlayer.class);
        for (AnimPlayer animPlayer : animPlayers)
            if (!players.contains(animPlayer))
                ((GameWorld) Global.world).freeAddObject(animPlayer, getX(), getY());
    }

    /**
     * Refreshes all of the AnimPlayers' positions
     */
    public void refreshLocation()
    {
        for (AnimPlayer animPlayer : animPlayers)
            animPlayer.refreshLocation();
    }

    /**
     * Shifts the object by its velocity
     * If it contains a colision module, it will stops when it hits a coliding class.
     */
    public void applyVel()
    {
        boolean hasCollisionPlayer = false;
        for (AnimPlayer animPlayer : animPlayers)
            if (animPlayer instanceof SolidPlayer)
            {
                hasCollisionPlayer = true;
                animPlayer.refreshLocation();
                double prevVX = getVX();
                boolean collided = false;
                for (int i = 0; i < Math.abs(prevVX); i++)
                {
                    move(Math.signum(prevVX), 0);
                    animPlayer.refreshLocation();

                    if (!((SolidPlayer) animPlayer).getClipping().isEmpty())
                    {
                        collided = true;
                        move(-Math.signum(prevVX), 0);
                        setVX(-prevVX * bounce);
                        setTrueX(getX());
                        continue;
                    }
                }
                if (!collided)
                    setTrueX(getTrueX() + ((int) prevVX - prevVX));
            }

        for (AnimPlayer animPlayer : animPlayers)
        {
            if (animPlayer instanceof SolidPlayer)
            {
                hasCollisionPlayer = true;
                animPlayer.refreshLocation();
                double prevVY = getVY();
                boolean collided = false;
                for (int i = 0; i < Math.abs(prevVY); i++)
                {
                    move(0, Math.signum(prevVY));
                    animPlayer.refreshLocation();

                    if (!((SolidPlayer) animPlayer).getClipping().isEmpty())
                    {
                        collided = true;
                        move(0, -Math.signum(prevVY));
                        setVY(-prevVY * bounce);
                        setTrueY(getY());
                        continue;
                    }
                }
                if (!collided)
                    setTrueY(getTrueY() + ((int) prevVY - prevVY));
            }
        }

        if (!hasCollisionPlayer)
            move(getVX(), getVY());

        refreshLocation();
    }

    /**
     * Gets if the actor has been started
     */
    public boolean getStart()
    {
        return start;
    }

    /**
     * Sets start
     */
    public void setStart(boolean start)
    {
        this.start = start;
    }

    /**
     * Gets if the actor is alive
     */
    public boolean getIsAlive()
    {
        return isAlive;
    }

    /**
     * Sets if the actor is allive
     */
    public void setIsAlive(boolean isAlive)
    {
        this.isAlive = isAlive;
    }

    /**
     * Returns the animPlayers array
     */
    public ArrayList<AnimPlayer> getPlayers()
    {
        return animPlayers;
    }

    /**
     * Add an AnimPlayer to animPlayers
     */
    public void addPlayer(AnimPlayer animPlayer)
    {
        animPlayers.add(animPlayer);
        addAnimObjects();
    }

    /**
     * Removes the actor from the world
     */
    public void delete()
    {
        for (AnimPlayer animPlayer : animPlayers)
            if (animPlayer.getIsAlive())
                animPlayer.delete();
        if (Global.world != null)
            Global.world.removeObject(this);
        setIsAlive(false);
    }

    /**
     * Sets the true position of the actor
     */
    public void setTruePos(double x, double y)
    {
        setTrueX(x);
        setTrueY(y);   
    }

    /**
     * Sets location of actor without snapping to grid
     */
    public void tele(double x, double y)
    {
        setTruePos(x, y);
        super.setLocation((int) x, (int) y);
    }

    /**
     * Shifts the actor without snapping to the grid, x is horizonal offset, y is vertical offset
     */
    public void move(double x, double y)
    {
        tele(getTrueX() + x, getTrueY() + y);
    }

    /**
     * setLocation is overided to snap to grid for easier editing with editor
     */
    public void setLocation(int x, int y)
    {
        tele((x / Options.TILE_SIZE * Options.TILE_SIZE) + (Options.TILE_SIZE / 2), (y / Options.TILE_SIZE * Options.TILE_SIZE) + (Options.TILE_SIZE / 2));
    }

    /**
     * Sets bounciness of the actor
     */
    public void setBounce(double bounce)
    {
        this.bounce = bounce;
    }

    /**
     * Sets velX and velY
     */
    public void setV(double vX, double vY)
    {
        setVX(vX);
        setVY(vY);
    }

    /**
     * Adds x to velX and y to velY
     */
    public void addForce(double x, double y)
    {
        setV(getVX() + x, getVY() + y);
    }

    /**
     * Gets animPlayers
     */
    public ArrayList<AnimPlayer> getAnimPlayers()
    {
        return animPlayers;
    }

    /**
     * Return the true x value of this actor
     */
    public double getTrueX()
    {
        return x;
    }

    /**
     * Sets the true x value of this actor
     */
    public void setTrueX(double x)
    {
        this.x = x;
    }

    /**
     * Return the true y value of this actor
     */
    public double getTrueY()
    {
        return y;
    }

    /**
     * Sets the true y value of this actor
     */
    public void setTrueY(double y)
    {
        this.y = y;
    }

    /**
     * Overrides getX() to return true x cast to int
     */
    public int getX()
    {
        return (int) getTrueX();
    }

    /**
     * Overrides getY() to return true y cast to int
     */
    public int getY()
    {
        return (int) getTrueY();
    }

    /**
     * Gets the x velocity
     */
    public double getVX()
    {
        return vX;
    }

    /**
     * Sets the x velocity
     */
    public void setVX(double vX)
    {
        this.vX = vX;
    }

    /**
     * Gets the y velocity
     */
    public double getVY()
    {
        return vY;
    }

    /**
     * Sets the y velocity
     */
    public void setVY(double vY)
    {
        this.vY = vY;
    }
}