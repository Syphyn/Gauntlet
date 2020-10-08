import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StageButton1 extends Button
{
    /**
     * Constructor
     */
    public StageButton1()
    {
        setDeactivatedImage(new GreenfootImage("Buttons/Stage1.png"));
        setActivatedImage(new GreenfootImage("Buttons/Stage2.png"));
        deactivate();
    }

    /**
     * Starts level1
     */
    public void confirm()
    {
        super.confirm();
        Global.score = 0;
        Global.time = 300;
        Global.level = 1;
        R1_0 room = new R1_0();
        room.enter();
        Greenfoot.setWorld(room);
        Global.stopMusic();
        Global.windfortress.playLoop();
    }
}
