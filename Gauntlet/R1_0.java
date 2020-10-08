import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R1_0 extends R1_1
{
    public R1_0()
    {
        super();
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
        addObject(player,208,396);
    }
}
