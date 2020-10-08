import greenfoot.*;
import java.util.*;
import java.lang.reflect.*;

/**
 * Reads user input and assigns tags to input keys
 * 
 * @author Duy Pham
 * @version 1-8-17
 */
public class InputHandler extends Actor
{   
    private static HashMap<String, String> keyMap = new HashMap();

    /**
     * Sets keys to check
     */
    public InputHandler()
    {
        getImage().setTransparency(0);

        for (int i = 97; i <= 122; i++)
            keyMap.put(String.valueOf(Character.toChars(i)), "RELEASED");

        keyMap.put("up", "RELEASED");
        keyMap.put("down", "RELEASED");
        keyMap.put("left", "RELEASED");
        keyMap.put("right", "RELEASED");
        keyMap.put("space", "RELEASED");
        keyMap.put("escape", "RELEASED");
        keyMap.put("/", "RELEASED");
        keyMap.put("\\", "RELEASED");
        keyMap.put("backspace", "RELEASED");
        keyMap.put("enter", "RELEASED");
        keyMap.put("r", "RELEASED");
    }

    /**
     * Updates the status of these keys
     * The possible statuses are:
     * "JUST_PRESSED" - Key has just been pressed
     * "PRESSED" - Key has been pressed for more than 2 frames
     * "JUST_RELEASED" - Key has just been released
     * "RELEASED" - Key has been released for more than 2 frames
     */
    public void update()
    {
        for (String key : keyMap.keySet())
        {
            if (Greenfoot.isKeyDown(key) && isKeyUp(key))
                keyMap.put(key, "JUST_PRESSED");
            else if (Greenfoot.isKeyDown(key) && isKeyJustPressed(key))
                keyMap.put(key, "PRESSED");
            else if (!Greenfoot.isKeyDown(key) && isKeyDown(key))
                keyMap.put(key, "JUST_RELEASED");
            else if (!Greenfoot.isKeyDown(key) && isKeyJustReleased(key))
                keyMap.put(key, "RELEASED");
        }
    }

    /**
     * Get the status of a key
     */
    public static String get(String key)
    {
        return keyMap.get(key);
    }

    /**
     * Check if key is currently down
     */
    public static boolean isKeyDown(String key)
    {
        if (get(key) == "JUST_PRESSED"  || get(key) == "PRESSED")
            return true;
        return false;
    }

    /**
     * Check if key is currently up
     */
    public static boolean isKeyUp(String key)
    {
        if (get(key) == "JUST_RELEASED"  || get(key) == "RELEASED")
            return true;
        return false;
    }

    /**
     * Check if key had just been pressed
     */
    public static boolean isKeyJustPressed(String key)
    {
        if (get(key) == "JUST_PRESSED")
            return true;
        return false;
    }

    /**
     * Check if key is held
     */
    public static boolean isKeyPressed(String key)
    {
        if (get(key) == "PRESSED")
            return true;
        return false;
    }

    /**
     * Check if key had just been released
     */
    public static boolean isKeyJustReleased(String key)
    {
        if (get(key) == "JUST_RELEASED")
            return true;
        return false;
    }

    /**
     * Check if key is released
     */
    public static boolean isKeyReleased(String key)
    {
        if (get(key) == "RELEASED")
            return true;
        return false;
    }
}
