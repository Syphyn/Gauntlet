import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelSelection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends GameWorld
{
    private long gameOverEnd;
    private boolean inMenu = true;

    /**
     * Constructor for objects of class LevelSelection.
     * 
     */
    public GameOver()
    {
        super();
        gameOverEnd = System.currentTimeMillis() + Options.GAMEOVER_SCREEN_WAIT;
        freeAddObject(new ImageDisplay("GameOver", Options.WIDTH, Options.HEIGHT, 1, 6, true, 5), Options.WIDTH / 2, Options.HEIGHT / 2);
        
        Global.stopMusic();
        Global.lose.playLoop();
    }

    /**
     * Smooth update
     */
    public void update()
    {
        super.update();
        if (System.currentTimeMillis() > gameOverEnd)
        {
            MainMenu menu = new MainMenu();
            Greenfoot.setWorld(menu);
        }
    }
}
