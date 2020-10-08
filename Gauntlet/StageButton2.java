import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StageButton2 extends Button
{
    /**
     * Constructor
     */
    public StageButton2()
    {
        setDeactivatedImage(new GreenfootImage("Buttons/Stage3.png"));
        setActivatedImage(new GreenfootImage("Buttons/Stage4.png"));
        deactivate();
    }

    /**
     * Starts level2
     */
    public void confirm()
    {
        super.confirm();
        Global.score = 0;
        Global.time = 300;
        Global.level = 2;
        R2_0 room = new R2_0();
        room.enter();
        Greenfoot.setWorld(room);
        Global.stopMusic();
        Global.scorching.playLoop();
    }
}
