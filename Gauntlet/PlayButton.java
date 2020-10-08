import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Button
{
    public PlayButton()
    {
        setDeactivatedImage(new GreenfootImage("Buttons/DeactivatedPlay.png"));
        setActivatedImage(new GreenfootImage("Buttons/ActivatedPlay.png"));
        deactivate();
    }
    
    public void confirm()
    {
        super.confirm();
        LevelSelectionMenu levelSelect = new LevelSelectionMenu();
        Greenfoot.setWorld(levelSelect);
    }
}