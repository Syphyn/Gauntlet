import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.Math;

/**
 * Frames for an animation
 * 
 * @author Duy Pham
 * @version 1-14-17
 */
public class Anim
{
    private ArrayList<GreenfootImage> images;   //the array of images of all the frames of this animation

    public Anim(String path, int dimX, int dimY, int start, int end)
    {
        this.images = AnimReader.readAnim(path, dimX, dimY, start, end);
    }

    public Anim(String path, int start, int end)
    {
        this.images = AnimReader.readAnim(path, start, end);
    }

    public Anim(ArrayList<GreenfootImage> images)
    {
        this.images = images;
    }

    public ArrayList<GreenfootImage> getImages()
    {
        return images;
    }

    public GreenfootImage getSprite(int frame, boolean flipH, boolean flipV, Style style)
    {
        GreenfootImage output = new GreenfootImage(images.get(frame));
        if (flipH)
            output.mirrorHorizontally();
        if (flipV)
            output.mirrorVertically();

        switch(style)
        {
            case BLACK:
            for (int x = 0; x < output.getWidth(); x++)
                for (int y = 0; y < output.getWidth(); y++)
                    if (output.getColorAt(x, y).getAlpha() != 0)
                        output.setColorAt(x, y, Color.BLACK);
            break;
            case WHITE:
            for (int x = 0; x < output.getWidth(); x++)
                for (int y = 0; y < output.getWidth(); y++)
                    if (output.getColorAt(x, y).getAlpha() != 0)
                        output.setColorAt(x, y, Color.WHITE);
            break;
            case RED:
            for (int x = 0; x < output.getWidth(); x++)
                for (int y = 0; y < output.getWidth(); y++)
                    if (output.getColorAt(x, y).getAlpha() != 0)
                        output.setColorAt(x, y, Color.RED);
            break;
        }

        return output;
    }
}
