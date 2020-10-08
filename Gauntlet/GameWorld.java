import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * The game world. Everything is on this world.
 * 
 * @author Duy Pham
 * @version 1-4-17
 */
public class GameWorld extends World
{
    public InputHandler inputHandler = new InputHandler();
    public boolean paused;

    private boolean start = true;
    private long nextTime;
    private long testTime;

    /**
     * Constructor for objects of class MyWorld.
     */
    public GameWorld()
    {
        // Create a new world according to the world options.
        super(Options.WIDTH, Options.HEIGHT, 1);

        Global.world = this;

        if (Options.SMOOTH_UPDATE)
            Greenfoot.setSpeed(Options.SMOOTH_TIMER_ACT_SPEED);
        else
            Greenfoot.setSpeed(50);            

        setPaintOrder(CollisionPlayer.class, Button.class, ScoreDisplay.class, TimeDisplay.class, ForegroundPlayer.class, MidgroundPlayer.class, BackgroundPlayer.class);
        drawGrid();
    }

    /**
     * Draw the background snap-grid for easier world editing
     */
    public void drawGrid()
    {
        GreenfootImage background = new GreenfootImage(Options.WIDTH, Options.HEIGHT);
        background.setColor(new Color(178, 186, 187));
        background.fill();
        background.setColor(new Color(204, 209, 209));

        for (int x = 0; x < Options.WIDTH; x += Options.TILE_SIZE)
            for (int y = 0; y < Options.HEIGHT; y += Options.TILE_SIZE)
                if ((x / Options.TILE_SIZE + y / Options.TILE_SIZE) % 2 == 0)
                    background.fillRect(x, y, Options.TILE_SIZE, Options.TILE_SIZE);

        setBackground(background);
    }

    /**
     * Runs only on the first act
     */
    public void start()
    {
        if (Options.SMOOTH_UPDATE)
            nextTime = System.currentTimeMillis();
    }

    /**
     * This is the heart of the game. It runs update() after every Options.INTERVAL
     */
    public void act()
    {
        if (start)
        {
            start();
            start = false;
        }

        if (!Options.SMOOTH_UPDATE)
            update();

        if (Options.SMOOTH_UPDATE && System.currentTimeMillis() > nextTime)
        {
            int catchUpCount = Options.MAX_CATCH_UP;
            while (System.currentTimeMillis() > nextTime && catchUpCount > 0)
            {
                update();
                nextTime += Options.INTERVAL;
                catchUpCount--;
            }
            if (catchUpCount < 1)
                nextTime = System.currentTimeMillis() + Options.INTERVAL;
        }
    }

    /**
     * Updates all ExtendedActor
     */
    public void update()
    {
        Global.updateTime++;
        inputHandler.update();

        if (!paused)
            for (ExtendedActor actor : getObjects(ExtendedActor.class))
                if (actor.getIsAlive())
                    actor.update();

        if (System.currentTimeMillis() - testTime != 0)
            Global.fps = (int) (1000 / (System.currentTimeMillis() - testTime));
        testTime = System.currentTimeMillis();

        if (Options.FPS_COUNTER)
            System.out.println(Global.fps);
    }

    /**
     * addObject is overrided to snap to grid
     */
    public void addObject(ExtendedActor actor, int x, int y)
    {
        super.addObject(actor, (x / Options.TILE_SIZE * Options.TILE_SIZE) + (Options.TILE_SIZE / 2), (y / Options.TILE_SIZE * Options.TILE_SIZE) + (Options.TILE_SIZE / 2));
        actor.refreshLocation();
    }

    /**
     * freeAddObject doesn't need to snap to grid
     */
    public void freeAddObject(Actor actor, double x, double y)
    {
        super.addObject(actor, (int) x, (int) y);
        if (actor instanceof ExtendedActor)
        {
            ((ExtendedActor) actor).setTrueX(x);
            ((ExtendedActor) actor).setTrueY(y);
            ((ExtendedActor) actor).refreshLocation();
        }
    }

    /**
     * Sets time until next update
     */
    public void setNextTime(long nextTime)
    {
        this.nextTime = nextTime;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    protected void prepare()
    {
    }
}
