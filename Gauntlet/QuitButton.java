import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuitButton extends Button
{
    public QuitButton()
    {
        setDeactivatedImage(new GreenfootImage("Buttons/DeactivatedQuit.png"));
        setActivatedImage(new GreenfootImage("Buttons/ActivatedQuit.png"));
        deactivate();
    }

    public void confirm()
    {
        super.confirm();
        MainMenu room = new MainMenu();
        Greenfoot.setWorld(room);
    }
}
