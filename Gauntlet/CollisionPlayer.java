import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.Math;

/**
 * Animation that handles collisions, drags the actor along with it when it hits another CollisionAnimPlayer
 * 
 * @author Duy Pham
 * @version 1-15-17
 */
public class CollisionPlayer extends AnimPlayer
{
    private String group;
    private ArrayList<String> mask;
    private ArrayList<CollisionPlayer> prevPlayers;

    /**
     * Constructor
     */
    public CollisionPlayer(ExtendedActor parent, String group, ArrayList<String> mask)
    {
        super(parent);
        this.group = group;
        this.mask = mask;
    }

    /**
     * Constructor
     */
    public CollisionPlayer(ExtendedActor parent, String group, String mask)
    {
        super(parent);
        this.group = group;
        this.mask = new ArrayList<String>(Arrays.asList(mask));
    }

    public void change()
    {
        super.change();

        if (Options.VISIBLE_COLLISIONS)
            getImage().setTransparency(100);    //makes the hitbox invisible
        else
            getImage().setTransparency(0);    //makes the hitbox invisible
    }

    /**
     * Move by distance left, returns any clipping collisionPlayers
     */
    public ArrayList<CollisionPlayer> getClippingLeft(int distance)
    {
        ArrayList<CollisionPlayer> collisions = new ArrayList<CollisionPlayer>();
        if (getIsAlive() && getParent().getIsAlive())
        {
            double prevTrueX = getTrueX();
            double prevTrueY = getTrueY();

            move(-distance, 0);
            collisions.addAll(getClipping());
            tele(prevTrueX, prevTrueY);
        }
        return collisions;
    }

    /**
     * Move by distance right, returns any clipping collisionPlayers
     */
    public ArrayList<CollisionPlayer> getClippingRight(int distance)
    {
        ArrayList<CollisionPlayer> collisions = new ArrayList<CollisionPlayer>();
        if (getIsAlive() && getParent().getIsAlive())
        {
            double prevTrueX = getTrueX();
            double prevTrueY = getTrueY();

            move(distance, 0);
            collisions.addAll(getClipping());
            tele(prevTrueX, prevTrueY);
        }
        return collisions;
    }

    /**
     * Move by distance up, returns any clipping collisionPlayers
     */
    public ArrayList<CollisionPlayer> getClippingUp(int distance)
    {
        ArrayList<CollisionPlayer> collisions = new ArrayList<CollisionPlayer>();
        if (getIsAlive() && getParent().getIsAlive())
        {
            double prevTrueX = getTrueX();
            double prevTrueY = getTrueY();

            move(0, -distance);
            collisions.addAll(getClipping());
            tele(prevTrueX, prevTrueY);
        }
        return collisions;
    }

    /**
     * Move by distance down, returns any clipping collisionPlayers
     */
    public ArrayList<CollisionPlayer> getClippingDown(int distance)
    {
        ArrayList<CollisionPlayer> collisions = new ArrayList<CollisionPlayer>();
        if (getIsAlive() && getParent().getIsAlive())
        {
            double prevTrueX = getTrueX();
            double prevTrueY = getTrueY();

            move(0, distance);
            collisions.addAll(getClipping());
            tele(prevTrueX, prevTrueY);
        }
        return collisions;
    }

    /**
     * Return the touching collisionPlayers of the mask that intersets this collisionPlayer
     */
    public ArrayList<CollisionPlayer> getTouching()
    {
        ArrayList<CollisionPlayer> collisions = new ArrayList<CollisionPlayer>();
        if (getIsAlive() && getParent().getIsAlive())
        {
            double prevTrueX = getTrueX();
            double prevTrueY = getTrueY();

            move(1, -1);
            collisions.addAll(getClipping());
            tele(prevTrueX, prevTrueY);
            move(1, 1);
            collisions.addAll(getClipping());
            tele(prevTrueX, prevTrueY);
            move(-1, 1);
            collisions.addAll(getClipping());
            tele(prevTrueX, prevTrueY);
            move(-1, -1);
            collisions.addAll(getClipping());
            tele(prevTrueX, prevTrueY);
        }
        return collisions;
    }

    /**
     * Returns the collisionPlayers of the mask that intersects this collisionPlayer
     */
    public ArrayList<CollisionPlayer> getClipping()
    {
        ArrayList<CollisionPlayer> collisions = new ArrayList<CollisionPlayer>();
        if (getAnim() != null)
            if (getIsAlive() && getParent().getIsAlive())
            {
                for (CollisionPlayer collisionPlayer : getIntersectingObjects(CollisionPlayer.class))
                    if (mask.contains(collisionPlayer.group))
                        collisions.add(collisionPlayer);
            }
        return collisions;
    }
}
