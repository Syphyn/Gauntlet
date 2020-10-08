import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;

/**
 * Write a description of class LevelSelection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NameEnter extends GameWorld
{
    String name  = "";
    String fileName = "leaderboard" + Global.level + ".txt";

    /**
     * Constructor for objects of class LevelSelection.
     * 
     */
    public NameEnter()
    {
        super();
        drawBackground();

        Global.stopMusic();
        if (Global.level != 3)
            Global.white.play();
        else
            Global.way.play();
    }

    /**
     * Draws background
     */
    public void drawBackground()
    {
        GreenfootImage background = new GreenfootImage(Options.WIDTH, Options.HEIGHT);
        background.setColor(new Color(10, 10, 10));
        background.fill();
        background.setColor(Color.WHITE);
        background.setFont(new Font(true, false, 32));
        background.drawString("KILL SCORE: " + Global.score + "\nTIME BONUS: " + Global.time + " x 10 = " + (Global.time * 10) + "\nTOTAL SCORE: " + (Global.score + Global.time * 10)  + "\n\nWHO ARE YOU?", Options.NAME_PROMPT_X, Options.NAME_PROMPT_Y);
        setBackground(background);
    }

    /**
     * Checks inputs, writes to file
     */
    public void input()
    {
        for (int i = 97; i <= 122; i++)
        {
            String value = String.valueOf(Character.toChars(i));
            if (InputHandler.isKeyJustPressed(value) && name.length() < 10)
                name += value;
        }

        if (InputHandler.isKeyJustPressed("backspace") && name.length() > 0)
            name = name.substring(0, name.length() - 1);

        if (InputHandler.isKeyJustPressed("enter"))
        {
            try 
            {
                FileWriter fileWriter = new FileWriter(fileName, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(name + ":" + (Global.score + Global.time * 10));
                bufferedWriter.newLine();

                bufferedWriter.close();
            }
            catch(IOException ex)
            {
                System.out.println(
                    "Error writing to file '"
                    + fileName + "'");
            }

            Leaderboard board = new Leaderboard();
            Greenfoot.setWorld(board);
        }

        name = name.toUpperCase();
    }

    /**
     * Smooth update
     */
    public void update()
    {
        super.update();
        input();

        getBackground().clear();
        drawBackground();
        getBackground().setColor(Color.WHITE);
        getBackground().setFont(new Font(true, false, 32));
        getBackground().drawString(name, Options.NAME_X, Options.NAME_Y);
        repaint();
    }
}
