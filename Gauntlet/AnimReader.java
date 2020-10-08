import greenfoot.*;
import java.util.*;
import java.io.File;

/**
 * Useful file functions such as reading an animation folder
 * 
 * @author Duy Pham
 * @version 1-14-17
 */
public class AnimReader
{
    /**
     * Import an animation file.
     * An animation file is a folder containing images/frames of an animation.
     * It returns a list of these images as an ArrayList of GreenfootImages.
     */
    public static ArrayList<GreenfootImage> readAnim(String path, int dimX, int dimY, int start, int end)
    {
        ArrayList<GreenfootImage> images = new ArrayList<GreenfootImage>();
        String substring = path.substring(path.lastIndexOf("/") + 1);
        for (int i = start; i <= end; i++)
        {
            GreenfootImage image = new GreenfootImage(path + "/" + substring + i + ".png");
            image.scale(dimX, dimY);
            images.add(image);
        }
        return images;
    }

    /**
     * Import an animation file.
     * An animation file is a folder containing images/frames of an animation.
     * It returns a list of these images as an ArrayList of GreenfootImages.
     */
    public static ArrayList<GreenfootImage> readAnim(String path, int start, int end)
    {
        ArrayList<GreenfootImage> images = new ArrayList<GreenfootImage>();
        for (int i = start; i <= end; i++)
            images.add(new GreenfootImage(path + "/" + path + i + ".png"));
        return images;
    }
}
