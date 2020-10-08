import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R2_0 extends R2_1
{
    public R2_0()
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
        addObject(player,127,424);
    }
}
