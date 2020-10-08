import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class SolidPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AreaPlayer extends CollisionPlayer
{
    public AreaPlayer(ExtendedActor parent, String group, ArrayList<String> mask)
    {
        super(parent, group, mask);
    }

    public AreaPlayer(ExtendedActor parent, String group, String mask)
    {
        super(parent, group, mask);
    }
}
