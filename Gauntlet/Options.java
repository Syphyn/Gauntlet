import java.lang.Math;

/**
 * Options for the game.
 *
 * @author Duy Pham
 * @version 1-4-17
 */
public class Options
{
    /**
     * World Options
     */
    public static int WIDTH = 800;  //the width of the world
    public static int HEIGHT = 600; //the height of the world
    public static double MAX_DIST = Math.sqrt(Math.pow((double) WIDTH, 2.0) + Math.pow((double) HEIGHT, 2.0));  //the maximum possible distance in the world, calculated using the Pythagorean Theorem
    public static int TILE_SIZE = 32;   //the size of a tile
    public static int FRAMERATE = 60;   //sets updates per second, should stay at 60
    public static int INTERVAL = 1000 / FRAMERATE;  //interval in ms between each frames

    /**
     * Level Options
     */
    public static long MENU_WAIT = 250;
    public static int TIME_LIMIT = 300;
    public static double EDGE_PUSH = 10;

    /**
     * UI Options
     */
    public static long FREEZE_FRAME = 200;

    public static int HEART_X = 50;
    public static int HEART_Y = 50;
    public static int HEART_SPACING = 15;

    public static int SCORE_X = WIDTH - 100;
    public static int SCORE_Y = 63;

    public static int TIME_X = WIDTH - 200;
    public static int TIME_Y = 63;

    public static int GAMEOVER_WAIT = 5000;
    public static int CLEAR_WAIT = 5000;

    public static int GAMEOVER_SCREEN_WAIT = 7000;
    public static int CLEAR_SCREEN_WAIT = 7000;

    public static int NAME_PROMPT_X = (int) Options.WIDTH / 2 - 200;
    public static int NAME_PROMPT_Y = (int) Options.HEIGHT / 2 - 200;
    public static int NAME_X = (int) Options.WIDTH / 2 - 100;
    public static int NAME_Y = (int) Options.HEIGHT / 2 + 100;

    /**
     * Physics Options
     */
    public static int UNCLIP_ATTEMPTS = 100;    //how many attemps the physics engine should try to unclip an object
    public static int UNCLIP_DIST = 64; //the maximum distance the engine will attempt to unclip
    public static int UNCLIP_STEP = 4;  //distance added per unclip attempt

    /**
     * Player Options
     */ 
    public static int PLAYER_MAX_HEALTH = 20;
    public static long PLAYER_INVUL_TIME = 1000;
    public static int INVUL_BLINK_RATE = 5;

    public static double MAX_VEL_X = 10;
    public static double MAX_VEL_Y = 20;

    public static double GRAVITY = 0.8;
    public static double JUMP_VEL = 10;
    public static double AIR_HOVER = 0.5;

    public static double AIR_FRICTION = 0.25;
    public static double AIR_ACCEL = 1;

    public static double GROUND_FRICTION = 1;
    public static double GROUND_ACCEL = 2;

    public static double DEATH_X_FRICTION = 0.1;

    public static double ATTACK_SHIFT = 5;

    public static double CLIMB_VEL = 15;
    public static double WALL_STICK_VEL = 2;
    public static long WALL_JUMP_WINDOW = 100;
    public static int WALL_JUMP_CHECK_SHIFT = 10;

    public static double IDLE_TO_RUN_SPEED = 5;
    public static double RUN_TO_IDLE_SPEED = 5;

    /**
     * Slime Options
     */
    public static double SLIME_X_FRICTION = 0.3;
    public static long SLIME_JUMP_INTERVAL = 1000;
    public static int SLIME_SIGHT_RADIUS = 700;

    /**
     * Cardinal Options
     */
    public static double CARDINAL_FRICTION = 0.3;
    public static long CARDINAL_DASH_INTERVAL = 500;
    public static double CARDINAL_DASH_VEL = 15;

    /**
     * Boss Options
     */
    public static int BOSS_MAX_HEALTH = PLAYER_MAX_HEALTH;
    public static long BOSS_WAIT = 1000;
    public static long TELEPORT_COOLDOWN = 10000;
    public static long ATTACK_COOLDOWN = 1000;
    public static int CIRCLE_CHANCE = 3;

    public static int BOSS_HEART_X = 50;
    public static int BOSS_HEART_Y = 70;
    
    public static double BULLET_VEL = 20;

    /**
     * Update Options
     */
    public static boolean SMOOTH_UPDATE = true; //If true, the game will update on a custom timer, not on the original act() command. This custom timer is customized to update smoothly
    public static int SMOOTH_TIMER_ACT_SPEED = 80;  //What speed the Greenfoot speed slider is set to when UPDATE_TYPE is CUSTOM_TIMER
    public static int MAX_CATCH_UP = 10; //When the engine lags behind, how many frames maximun it will attempt to simulate in sucession

    /**
     * Debug Options
     */
    public static boolean PLACEHOLDER = false;
    public static boolean VISIBLE_COLLISIONS = false;   //makes collissions visible
    public static boolean DISPLAY_PLAYER_STATE = false;
    public static boolean FPS_COUNTER = false;  //prints fps every frame

    /**
     * Constructor for objects of class Options
     */
    public Options()
    {
    }
}
