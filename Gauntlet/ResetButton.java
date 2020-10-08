import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResetButton extends Button
{
    public ResetButton()
    {
        setDeactivatedImage(new GreenfootImage("Buttons/DeactivatedOptions.png"));
        setActivatedImage(new GreenfootImage("Buttons/ActivatedOptions.png"));
        deactivate();
    }

    public void confirm()
    {
        super.confirm();
        Global.score = 0;
        Global.time = Options.TIME_LIMIT;
        Room room = null;
        if (Global.world instanceof Tutorial)
            room = new R0_0();
        else if (Global.world instanceof Level1)
            room = new R1_0();
        else if (Global.world instanceof Level2)
            room = new R2_0();
        else if (Global.world instanceof Level3)
            room = new R3_1();

        room.enter();
        Greenfoot.setWorld(room);
    }
}
