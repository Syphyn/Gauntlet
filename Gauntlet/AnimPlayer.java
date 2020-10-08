import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Plays animations, has offset
 * 
 * @author Duy Pham
 * @version 1-15-17
 */
public class AnimPlayer extends ExtendedActor
{
    private ExtendedActor parent;
    private HashMap<String, Anim> animMap = new HashMap<String, Anim>();
    private String name;
    private Anim anim;

    private Style style = Style.DEFAULT;
    private boolean paused;
    private double offX;
    private double offY;
    private boolean flipH;
    private boolean flipV;
    private boolean loop;
    private boolean last;
    private int frame = 1;
    private int fps;
    private int time;

    public AnimPlayer(ExtendedActor parent)
    {
        this.parent = parent;
        getImage().setTransparency(0);
    }

    /**
     * Steps through time, refreshes location
     */
    public void update() 
    {
        super.update();

        if (anim != null)
        {
            step();
            refreshLocation();
        }
        else
        {
            getImage().setTransparency(0);
            setImage(new GreenfootImage(1, 1));
        }
    }

    /**
     * Steps one step into the animation
     */
    public void step()
    {   
        /**
         * If time is zero, step one frame, reset time to next frame.
         * If this animation is looped, frame is set to 0.
         */
        if (!paused)
        {
            if (time == 0)
            {
                if (frame == anim.getImages().size())
                {    
                    if (loop)
                    {
                        frame = 1;
                        frameChange();
                    }
                    last = true;
                }
                else
                {
                    frame++;
                    if (getAnim().getImages().size() > 0)
                        frameChange();
                    last = false;
                }
                if (fps != 0)
                    time = 60 / fps;
            }
            else
                last = false;
            time--;
        }
    }

    /**
     * Sets the location of the AnimPlayer to parent position plus offset
     */
    public void refreshLocation()
    {
        if (parent.getTrueX() + offX >= Options.WIDTH)
            tele(Options.WIDTH, parent.getTrueY());
        else if (parent.getTrueX() + offX <= 0)
            tele(0, parent.getTrueY());
        else
            tele(parent.getTrueX() + offX, parent.getTrueY());

        if (parent.getTrueY() + offY >= Options.HEIGHT)
            tele(parent.getTrueX(), Options.HEIGHT);
        else if (parent.getTrueY() + offY <= 0)
            tele(parent.getTrueX(), 0);
        else
            tele(getTrueX(), parent.getTrueY() + offY);
    }

    /**
     * Is called whenever a frame changes
     */
    public void frameChange()
    {
        updateImage();
        change();
    }

    /**
     * Is called when the offset or frame is changed
     */
    public void change()
    {
        refreshLocation();
    }

    /**
     * Sets the image of this AnimPlayer to the image of the frame of the animation
     */
    public void updateImage()
    {
        if (anim != null)
            setImage(getFrameImage());
    }

    /**
     * Adds a new animation to the possible animation map
     */
    public void add(String name, Anim anim)
    {
        animMap.put(name, anim);
    }

    /**
     * Adds a new animation to the possible animation map, dimX and dimY allow for resizing of the image before import
     */
    public void add(String name, String path, int dimX, int dimY, int start, int end)
    {
        animMap.put(name, new Anim(path, dimX, dimY, start, end));
    }

    /**
     * Adds a new animation to the possible animation map
     */
    public void add(String name, String path, int start, int end)
    {
        animMap.put(name, new Anim(path, start, end));
    }

    public void setStyle(Style style)
    {
        this.style = style;
        frameChange();
    }

    public Style getStyle()
    {
        return style;
    }

    /**
     * Plays an animation, just give it a name, if it loops, and how fast (in frames per second) it should go. Interrupt specifies if it should interrupt itself.
     */
    public void play(String name, boolean loop, int fps, boolean interrupt)
    {
        String prevName = getName();

        if (interrupt)
        {
            if (getName() != name)
            {
                if (animMap.containsKey(name))
                {
                    this.name = name;
                    this.loop = loop;
                    this.fps = fps;
                    anim = animMap.get(name);

                    if (fps != 0)
                        time = 60 / fps;
                    frame = 1;

                    frameChange();
                }
                else
                {
                    System.out.println("NO SUCH ANIM:\t" + name);
                    System.out.println("PARENT:\t" + parent);
                }
            }
        }
        else
        {
            if (getName() != name)
            {
                if (animMap.containsKey(name))
                {
                    this.name = name;
                    this.loop = loop;
                    this.fps = fps;
                    anim = animMap.get(name);

                    if (fps != 0)
                        time = 60 / fps;
                    frame = 1;

                    frameChange();
                }
                else
                {
                    System.out.println("NO SUCH ANIM:\t" + name);
                    System.out.println("PARENT:\t" + parent);
                }
            }
        }

        if (getName() != prevName)
            step();
    }

    /**
     * Plays an animation, just give it a name, if it loops, and how fast (in frames per second) it should go.
     */
    public void play(String name, boolean loop, int fps)
    {
        play(name, loop, fps, false);
    }

    public void stop()
    {
        name = "";
        anim = null;
    }

    /**
     * Gets the parent this AnimPlayer is attached to
     */
    public ExtendedActor getParent()
    {
        return parent;
    }

    /**
     * Gets the name of the current animation
     */
    public String getName()
    {
        return name;
    }

    /**
     * Check if name is equal to provided name
     */
    public boolean checkName(String name)
    {
        if (this.name == name)
            return true;
        return false;
    }

    /**
     * Gets the current animation
     */
    public Anim getAnim()
    {
        return anim;
    }

    /**
     * Get the current frame number
     */
    public int getFrame()
    {
        return frame;
    }

    /**
     * Check if frame is equal to provided frame
     */
    public boolean checkFrame(int frame)
    {
        if (this.frame == frame)
            return true;
        return false;
    }

    /**
     * Check if frame is equal to provided frame and time
     */
    public boolean checkFrame(int frame, int time)
    {
        if (checkFrame(frame) && this.time == time)
            return true;
        return false;
    }

    /**
     * Get the current image of the frame
     */
    public GreenfootImage getFrameImage()
    {
        return anim.getSprite(getFrame() - 1, flipH, flipV, style);
    }

    /**
     * Get the X offset
     */
    public double getOffX()
    {
        return offX;
    }

    /**
     * Get the Y offset
     */
    public double getOffY()
    {
        return offY;
    }

    /**
     * Sets offset
     */
    public void setOffset(double offX, double offY)
    {
        this.offX = offX;
        this.offY = offY;
        change();
    }

    /**
     * Sets flips
     */
    public void setFlip(boolean flipH, boolean flipV)
    {
        this.flipH = flipH;
        this.flipV = flipV;
        frameChange();
    }

    /**
     * Get animation time
     */
    public int getTime()
    {
        return time;
    }

    /**
     * Returns true is animation is at the last frame
     */
    public boolean isEnd()
    {
        return last;
    }

    /**
     * Returns if animation is paused
     */
    public boolean getPaused()
    {
        return paused;
    }

    /**
     * Set if animation should be paused
     */
    public void setPaused(boolean paused)
    {
        this.paused = paused;
    }
}
