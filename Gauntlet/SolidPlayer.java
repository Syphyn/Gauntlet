import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class SolidPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SolidPlayer extends CollisionPlayer
{
    public SolidPlayer(ExtendedActor parent, String group, ArrayList<String> mask)
    {
        super(parent, group, mask);
    }

    public SolidPlayer(ExtendedActor parent, String group, String mask)
    {
        super(parent, group, mask);
    }

    /**
     * Is called whenever a frame changes
     * Detects and unclips any collisions that result out of an expanding hitbox
     */
    public void change()
    {
        super.change();
        if (getWorld() != null && !getClipping().isEmpty())
            unclipSpiral();
    }

    /**
     * Brute force unclip. Searches in a spiral, whichever x and y value doesn't colide is the new x and y position
     */
    public void unclipSpiral()
    {
        double prevX = getTrueX();
        double prevY = getTrueY();

        for (int offX = 0; offX < Options.UNCLIP_DIST; offX += Options.UNCLIP_STEP)
            for (int offY = 0; offY < Options.UNCLIP_DIST; offY += Options.UNCLIP_STEP)
            {
                tele(prevX + offX, prevY + offY);
                if (!getClipping().isEmpty())
                    tele(prevX, prevY);
                else
                {
                    getParent().tele(getX(), getY());
                    return;
                }

                tele(prevX + offX, prevY - offY);
                if (!getClipping().isEmpty())
                    tele(prevX, prevY);
                else
                {
                    getParent().tele(getX(), getY());
                    return;
                }

                tele(prevX - offX, prevY + offY);
                if (!getClipping().isEmpty())
                    tele(prevX, prevY);
                else
                {
                    getParent().tele(getX(), getY());
                    return;
                }

                tele(prevX - offX, prevY - offY);
                if (!getClipping().isEmpty())
                    tele(prevX, prevY);
                else
                {
                    getParent().tele(getX(), getY());
                    return;
                }
            }
    }
}
