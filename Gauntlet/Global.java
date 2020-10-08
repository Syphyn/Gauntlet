import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Global here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Global  
{   
    public static World world;
    public static int level;
    public static int fps;
    public static int time;
    public static int updateTime;
    public static int score;

    public static GreenfootSound moonsong = new GreenfootSound("Moonsong.wav");
    public static GreenfootSound running = new GreenfootSound("Running Hell.wav");
    public static GreenfootSound windfortress = new GreenfootSound("Wind Fortress.wav");
    public static GreenfootSound scorching = new GreenfootSound("Scorching Back.wav");
    public static GreenfootSound boss = new GreenfootSound("Last Battle.wav");
    public static GreenfootSound lose = new GreenfootSound("Gameover.wav");
    public static GreenfootSound win = new GreenfootSound("Victory!.wav");
    public static GreenfootSound white = new GreenfootSound("White.wav");
    public static GreenfootSound way = new GreenfootSound("The Way Back Home.wav");

    public Global()
    {
    }

    public static void stopMusic()
    {
        moonsong.stop();
        running.stop();
        windfortress.stop();
        scorching.stop();
        boss.stop();
        lose.stop();
        win.stop();
        white.stop();
        way.stop();
    }
}