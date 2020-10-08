import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StageButton3 extends Button
{
    /**
     * Constructor
     */
    public StageButton3()
    {
        setDeactivatedImage(new GreenfootImage("Buttons/Stage5.png"));
        setActivatedImage(new GreenfootImage("Buttons/Stage6.png"));
        deactivate();
    }

    /**
     * Starts level3
     */
    public void confirm()
    {
        super.confirm();
        Global.score = 0;
        Global.time = 300;
        Global.level = 3;
        R3_1 room = new R3_1();
        room.enter();
        Greenfoot.setWorld(room);
        Global.stopMusic();
        Global.boss.playLoop();
    }
}
