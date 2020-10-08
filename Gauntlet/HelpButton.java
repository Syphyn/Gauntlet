import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpButton extends Button
{
    public HelpButton()
    {
        setDeactivatedImage(new GreenfootImage("Buttons/DeactivatedHelp.png"));
        setActivatedImage(new GreenfootImage("Buttons/ActivatedHelp.png"));
        deactivate();
    }

    public void confirm()
    {
        super.confirm();
        R0_0 room = new R0_0();
        room.enter();
        Greenfoot.setWorld(room);
        Global.stopMusic();
        Global.running.playLoop();
    }
}
