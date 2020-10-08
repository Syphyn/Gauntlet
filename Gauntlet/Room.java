import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SwitchableRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Room extends GameWorld
{
    public ResetButton resetButton = new ResetButton();
    public QuitButton quitButton = new QuitButton();

    public boolean prevFreeze;
    public long freezeTime;

    private boolean isGameOver;
    private boolean isStageClear;
    private long gameOverEnd;
    private long stageClearEnd;

    /**
     * Constructor
     */
    public Room()
    {
        super();
        drawBackground();
        setupButtons();
    }

    /**
     * Draws background
     */
    public void drawBackground()
    {
        GreenfootImage background = new GreenfootImage(Options.WIDTH, Options.HEIGHT);
        if (System.currentTimeMillis() < freezeTime)
        {
            // background.setColor(Color.RED);
            background.setColor(Color.WHITE);
        }
        else
        {
            background.setColor(new Color(3, 94, 123));
        }
        background.fill();
        setBackground(background);
    }

    /**
     * Smooth update
     */
    public void update()
    {
        super.update();

        if (paused)
            Button.moved = false;

        if (InputHandler.isKeyJustPressed("escape"))
        {
            if (!paused)
                pause();
            else
                unpause();
        }

        if (System.currentTimeMillis() < freezeTime && !prevFreeze)
        {
            drawBackground();
            paused = true;
            prevFreeze = true;

            for (ExtendedActor actor : getObjects(ExtendedActor.class))
            {
                if (actor instanceof Block)
                    ((Block) actor).display.setStyle(Style.WHITE);
                if (actor instanceof Enemy)
                    ((Enemy) actor).display.setStyle(Style.RED);
                if (actor instanceof Player)
                    ((Player) actor).display.setStyle(Style.BLACK);
                if (actor instanceof PlayerDeathParticle)
                    ((PlayerDeathParticle) actor).display.setStyle(Style.BLACK);
                if (actor instanceof BossDeathParticle)
                    ((BossDeathParticle) actor).display.setStyle(Style.RED);       
            }
        }
        else if (System.currentTimeMillis() > freezeTime && prevFreeze)
        {
            drawBackground();
            paused = false;
            prevFreeze = false;

            for (ExtendedActor actor : getObjects(ExtendedActor.class))
            {
                if (actor instanceof Block)
                    ((Block) actor).display.setStyle(Style.DEFAULT);
                if (actor instanceof Enemy)
                    ((Enemy) actor).display.setStyle(Style.DEFAULT);
                if (actor instanceof Player)
                    ((Player) actor).display.setStyle(Style.DEFAULT);
                if (actor instanceof PlayerDeathParticle)
                    ((PlayerDeathParticle) actor).display.setStyle(Style.DEFAULT);
                if (actor instanceof BossDeathParticle)
                    ((BossDeathParticle) actor).display.setStyle(Style.DEFAULT);
            }
        }

        if (isGameOver && System.currentTimeMillis() > gameOverEnd)
        {
            GameOver gameOver = new GameOver();
            Greenfoot.setWorld(gameOver);
        }
        if (isStageClear && System.currentTimeMillis() > stageClearEnd)
        {
            StageCleared stageClear = new StageCleared();
            Greenfoot.setWorld(stageClear);
        }
    }

    /**
     * Decriment time every second, game over when time <= 0
     */
    public void countDown()
    {
        if (Global.updateTime % 60 == 0)
        {
            Global.time--;
            if (Global.time <= 0)
                gameOver(0);
        }
    }

    /**
     * Starts the game over process after delay
     */
    public void gameOver(long delay)
    {
        gameOverEnd = System.currentTimeMillis() + delay;
        isGameOver = true;
    }

    /**
     * Starts the stage cleared process after delay
     */
    public void win(long delay)
    {
        stageClearEnd = System.currentTimeMillis() + delay;
        isStageClear = true;
    }

    /**
     * Freezes game for a certain time. For adding impact to hits
     */
    public void freeze(long time)
    {
        freezeTime = System.currentTimeMillis() + time;
    }

    /**
     * Setup buttons
     */
    public void setupButtons()
    {
        quitButton.setUpButton(resetButton);
        quitButton.setDownButton(resetButton);

        resetButton.setUpButton(quitButton);
        resetButton.setDownButton(quitButton);
    }

    /**
     * Pauses game
     */
    public void pause()
    {
        resetButton.activate();
        addObject(quitButton, Options.WIDTH / 2 - 50, Options.HEIGHT / 2);
        addObject(resetButton, Options.WIDTH / 2 + 50, Options.HEIGHT / 2);

        paused = true;
    }

    /**
     * Unpauses game
     */
    public void unpause()
    {
        quitButton.deactivate();
        resetButton.deactivate();

        removeObject(quitButton);
        removeObject(resetButton);

        paused = false;
    }

    /**
     * Switch to another room
     */
    public void switchRoom(Room room, GameActor actor, double x, double y)
    {
        exit();
        GameActor clone = actor.copy();
        room.freeAddObject(clone, x, y);
        actor.delete();
        room.enter();
        Greenfoot.setWorld(room);
    }

    /**
     * Called when room is switched to
     */
    public void enter()
    {
        setNextTime(System.currentTimeMillis() + Options.INTERVAL);
        freeAddObject(new HeartDisplay((DamageActor) getObjects(Player.class).get(0), Options.PLAYER_MAX_HEALTH), Options.HEART_X, Options.HEART_Y);
        freeAddObject(new ScoreDisplay(), Options.SCORE_X, Options.SCORE_Y);
        freeAddObject(new TimeDisplay(), Options.TIME_X, Options.TIME_Y);
    }

    /**
     * Called when room is switched out of
     */
    public void exit()
    {
    }
}