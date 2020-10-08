import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;

/**
 * Write a description of class LevelSelection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leaderboard extends GameWorld
{
    private long stopWait;

    String name  = "";
    String fileName = "leaderboard" + Global.level + ".txt";
    String line = null;

    LinkedList<String> names = new LinkedList<String>();
    LinkedList<Integer> scores = new LinkedList<Integer>();

    /**
     * Constructor for objects of class LevelSelection.
     * 
     */
    public Leaderboard()
    {
        super();

        stopWait = System.currentTimeMillis() + Options.MENU_WAIT;
        refreshScores();
        drawBackground();
    }

    /**
     * Refreshes names and scores list with the leaderboard file
     */
    public void refreshScores()
    {
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null)
            {
                String[] separatedScore = line.split(":");
                names.add(separatedScore[0]);
                scores.add(Integer.parseInt(separatedScore[1]));
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) 
        {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }

        Collections.reverse(names);
        Collections.reverse(scores);
    }

    /**
     * Draws backgorund
     */
    public void drawBackground()
    {
        GreenfootImage background = new GreenfootImage(Options.WIDTH, Options.HEIGHT);
        background.setColor(new Color(10, 10, 10));
        background.fill();
        background.setColor(Color.WHITE);
        background.setFont(new Font(true, false, 32));
        background.drawString("LATEST SCORES", 100, 50);
        background.setFont(new Font(true, false, 12));
        background.drawString("PRESS / AND \\ TO CLEAR LEADERBOARD", 520, 600);
        background.setColor(Color.WHITE);
        background.setFont(new Font(true, false, 32));

        for (int i = 0; i < names.size() && i < 10; i++)
            background.drawString(String.valueOf(i + 1) + ". " + names.get(i) + "   -   " + scores.get(i), 100, 50 + 50 * (i + 1));
        setBackground(background);
    }

    /**
     * Smooth update
     */
    public void update()
    {
        super.update();

        if (System.currentTimeMillis() > stopWait)
            if (InputHandler.isKeyJustPressed("enter"))
            {
                MainMenu menu = new MainMenu();
                Greenfoot.setWorld(menu);
            }
            else if (InputHandler.isKeyDown("/") && InputHandler.isKeyDown("\\"))
            {
                try 
                {
                    FileWriter fileWriter = new FileWriter(fileName);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    bufferedWriter.write("");

                    bufferedWriter.close();
                }
                catch(IOException ex)
                {
                    System.out.println(
                        "Error writing to file '"
                        + fileName + "'");
                }

                names.clear();
                scores.clear();
                refreshScores();
                drawBackground();
            }
    }
}
