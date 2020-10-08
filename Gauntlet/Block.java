import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * A block. Doesn't really do anything except block the player
 * 
 * @author Duy Pham
 * @version 1-14-17
 */
public class Block extends GameActor
{   
    DisplayPlayer display;
    SolidPlayer level;

    public Block()
    {
        super();
    }

    public void start()
    {
        super.start();

        display = new DisplayPlayer(this);
        display.add("block", "Block", 0, 0);
        addPlayer(display);
        display.play("block", false, 0);

        level = new SolidPlayer(this, "LEVEL", "PLAYER");
        level.add("default", "Block", 0, 0);
        addPlayer(level);
        level.play("default", false, 0);
    }
}
