import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelSelection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelectionMenu extends GameWorld
{
    private StageButton1 stageButton1 = new StageButton1();
    private StageButton2 stageButton2 = new StageButton2();
    private StageButton3 stageButton3 = new StageButton3();

    private long stopWait;
    private boolean inMenu = true;

    /**
     * Constructor for objects of class LevelSelection.
     * 
     */
    public LevelSelectionMenu()
    {
        super();
        drawBackground();
        setButtons();
        stopWait = System.currentTimeMillis() + Options.MENU_WAIT;
        prepare();
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
        background.drawString("LEVEL SELECTON", 100, 100);
        setBackground(background);
    }

    /**
     * Setup buttons
     */
    public void setButtons()
    {
        stageButton1.setUpButton(stageButton3);
        stageButton1.setDownButton(stageButton2);

        stageButton2.setUpButton(stageButton1);
        stageButton2.setDownButton(stageButton3);

        stageButton3.setUpButton(stageButton2);
        stageButton3.setDownButton(stageButton1);

        stageButton1.activate();
    }

    /**
     * Starts a level
     */
    public void startStage(GameWorld stage)
    {
        Greenfoot.setWorld(stage);
        inMenu = false;
    }

    /**
     * Called every Options.INTERVAL, smooth
     */
    public void update()
    {
        super.update();
        if (System.currentTimeMillis() > stopWait)
        {
            if (inMenu)
            {
                Button.pressable = true;
                if (InputHandler.isKeyJustPressed("escape"))
                {
                    MainMenu menu = new MainMenu();
                    Greenfoot.setWorld(menu);
                }
                Button.moved = false;
            }
        }
        else
            Button.pressable = false;
    }

    public void prepare()
    {
        super.prepare();
        freeAddObject(stageButton1,100,335);
        freeAddObject(stageButton2,400,335);
        freeAddObject(stageButton3,700,335);
    }
}
