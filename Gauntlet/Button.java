import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    public static boolean moved = false;
    public static boolean pressable = true;

    private boolean isActive = false;
    private Button upButton;
    private Button downButton;
    private GreenfootImage deactivatedImage;
    private GreenfootImage activatedImage;

    /**
     * Constructor
     */
    public Button()
    {
    }

    /**
     * Sets the deactivated image
     */
    public void setDeactivatedImage(GreenfootImage deactivatedImage)
    {
        this.deactivatedImage = deactivatedImage;
    }

    /**
     * Sets the activated image
     */
    public void setActivatedImage(GreenfootImage activatedImage)
    {
        this.activatedImage = activatedImage;
    }

    /**
     * Sets the button when you press up/left
     */
    public void setUpButton(Button upButton)
    {
        this.upButton = upButton;
    }

    /**
     * Sets the button when you press down/right
     */
    public void setDownButton(Button downButton)
    {
        this.downButton = downButton;
    }

    /**
     * Checks for input every frame
     */
    public void act() 
    {
        if (getActive())
        {
            if (!moved && pressable)
            {
                if (InputHandler.isKeyJustPressed("space") || InputHandler.isKeyJustPressed("enter"))
                {
                    confirm();
                    moved = true;
                }
                else if (InputHandler.isKeyJustPressed("up") || InputHandler.isKeyJustPressed("left") || InputHandler.isKeyJustPressed("a") || InputHandler.isKeyJustPressed("w"))
                {
                    deactivate();
                    upButton.activate();
                    moved = true;
                }
                else if (InputHandler.isKeyJustPressed("down") || InputHandler.isKeyJustPressed("right") || InputHandler.isKeyJustPressed("d") || InputHandler.isKeyJustPressed("s"))
                {
                    deactivate();
                    downButton.activate();
                    moved = true;
                }
            }
        }
    }

    /**
     * Called when confirmed
     */
    public void confirm()
    {
        Greenfoot.playSound("Blip_Select53.wav");
    }

    /**
     * Called when activated
     */
    public void activate()
    {
        isActive = true;
        setImage(activatedImage);
    }

    /**
     * Called when deactivated
     */
    public void deactivate()
    {
        isActive = false;
        setImage(deactivatedImage);
    }

    /**
     * Gets if button is active
     */
    public boolean getActive()
    {
        return isActive;
    }
}
