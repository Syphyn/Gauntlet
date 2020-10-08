import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class R0_0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R0_0 extends R0_1
{

    /**
     * Constructor for objects of class R0_0.
     * 
     */
    public R0_0()
    {
        super();
        prepare();
    }

    public void enter()
    {
        super.enter();
        Global.score = 0;
    }

    public void prepare()
    {
        super.prepare();
        Player player = new Player();
        addObject(player,118,405);
    }
}
