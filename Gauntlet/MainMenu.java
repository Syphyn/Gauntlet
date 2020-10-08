import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends GameWorld
{
    private PlayButton playButton = new PlayButton();
    private HelpButton helpButton = new HelpButton();

    private long stopWait;
    private boolean inMenu = true;

    /**
     * Constructor for objects of class MenuWorld.
     * 
     */
    public MainMenu()
    {
        super();
        Global.updateTime = 0;
        drawBackground();
        setButtons();
        stopWait = System.currentTimeMillis() + Options.MENU_WAIT;
        prepare();
    }

    public void start()
    {
        super.start();
        Global.stopMusic();
        Global.moonsong.playLoop();
    }

    /**
     * Draws the background
     */
    public void drawBackground()
    {
        GreenfootImage background = new GreenfootImage(Options.WIDTH, Options.HEIGHT);
        background.setColor(new Color(10, 10, 10));
        // background.setColor(Color.BLACK);
        background.fill();
        // background.setColor(new Color(229, 205, 200));
        background.setColor(Color.WHITE);
        background.fillRect(0, Options.HEIGHT / 2, Options.WIDTH, Options.HEIGHT / 2);
        background.setFont(new Font(true, false, 64));
        background.drawString("GAUNTLET", 300, 300);
        background.setColor(new Color(10, 10, 10));
        background.setFont(new Font(true, false, 12));
        background.drawString("GAME CONTAINS FLASHING LIGHTS", 520, 550);
        setBackground(background);
    }

    /**
     * Setup buttons
     */
    public void setButtons()
    {
        playButton.setUpButton(helpButton);
        playButton.setDownButton(helpButton);

        helpButton.setUpButton(playButton);
        helpButton.setDownButton(playButton);

        playButton.activate();
    }

    /**
     * Run every Options.INTERVAL, default is 60fps
     */
    public void update()
    {
        super.update();
        if (System.currentTimeMillis() > stopWait)
        {
            Button.pressable = true;
            if (inMenu)
                Button.moved = false;   //prevents button skipping
        }
        else
            Button.pressable = false;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void prepare()
    {
        super.prepare();
        addObject(playButton,100,200);
        addObject(helpButton,100,400);
    }
}
