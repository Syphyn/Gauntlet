import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R3_1 extends Level3
{
    public R3_1()
    {
        super();
        prepare();
    }

    public void enter()
    {
        super.enter();
        Global.score = 0;
        freeAddObject(new HeartDisplay((DamageActor) getObjects(Boss.class).get(0), Options.BOSS_MAX_HEALTH), Options.BOSS_HEART_X, Options.BOSS_HEART_Y);
    }

    public void prepare()
    {
        Block block = new Block();
        addObject(block,23,585);
        Block block2 = new Block();
        addObject(block2,8,553);
        Block block3 = new Block();
        addObject(block3,8,528);
        Block block4 = new Block();
        addObject(block4,14,495);
        Block block5 = new Block();
        addObject(block5,14,453);
        Block block6 = new Block();
        addObject(block6,14,429);
        Block block7 = new Block();
        addObject(block7,12,378);
        Block block8 = new Block();
        addObject(block8,11,393);
        Block block9 = new Block();
        addObject(block9,11,334);
        Block block10 = new Block();
        addObject(block10,7,292);
        Block block11 = new Block();
        addObject(block11,8,276);
        Block block12 = new Block();
        addObject(block12,12,234);
        Block block13 = new Block();
        addObject(block13,14,210);
        Block block14 = new Block();
        addObject(block14,12,165);
        Block block15 = new Block();
        addObject(block15,11,141);
        Block block16 = new Block();
        addObject(block16,6,107);
        Block block17 = new Block();
        addObject(block17,2,64);
        Block block18 = new Block();
        addObject(block18,2,48);
        Block block19 = new Block();
        addObject(block19,17,15);
        Block block20 = new Block();
        addObject(block20,781,12);
        Block block21 = new Block();
        addObject(block21,786,40);
        Block block22 = new Block();
        addObject(block22,790,79);
        Block block23 = new Block();
        addObject(block23,784,120);
        Block block24 = new Block();
        addObject(block24,777,147);
        Block block25 = new Block();
        addObject(block25,777,178);
        Block block26 = new Block();
        addObject(block26,782,212);
        Block block27 = new Block();
        addObject(block27,785,252);
        Block block28 = new Block();
        addObject(block28,785,273);
        Block block29 = new Block();
        addObject(block29,786,301);
        Block block30 = new Block();
        addObject(block30,785,331);
        Block block31 = new Block();
        addObject(block31,784,363);
        Block block32 = new Block();
        addObject(block32,785,407);
        Block block33 = new Block();
        addObject(block33,791,432);
        Block block34 = new Block();
        addObject(block34,790,469);
        Block block35 = new Block();
        addObject(block35,786,495);
        Block block36 = new Block();
        addObject(block36,786,531);
        Block block37 = new Block();
        addObject(block37,797,563);
        Block block38 = new Block();
        addObject(block38,785,579);
        Block block39 = new Block();
        addObject(block39,759,580);
        Block block40 = new Block();
        addObject(block40,716,585);
        Block block41 = new Block();
        addObject(block41,671,581);
        Block block42 = new Block();
        addObject(block42,686,588);
        Block block43 = new Block();
        addObject(block43,629,579);
        Block block44 = new Block();
        addObject(block44,574,581);
        Block block45 = new Block();
        addObject(block45,589,582);
        Block block46 = new Block();
        addObject(block46,519,582);
        Block block47 = new Block();
        addObject(block47,476,582);
        Block block48 = new Block();
        addObject(block48,500,580);
        Block block49 = new Block();
        addObject(block49,438,580);
        Block block50 = new Block();
        addObject(block50,398,579);
        Block block51 = new Block();
        addObject(block51,366,583);
        Block block52 = new Block();
        addObject(block52,328,583);
        Block block53 = new Block();
        addObject(block53,304,584);
        Block block54 = new Block();
        addObject(block54,273,588);
        Block block55 = new Block();
        addObject(block55,242,582);
        Block block56 = new Block();
        addObject(block56,207,584);
        Block block57 = new Block();
        addObject(block57,167,584);
        Block block58 = new Block();
        addObject(block58,137,584);
        Block block59 = new Block();
        addObject(block59,106,588);
        Block block60 = new Block();
        addObject(block60,71,582);
        Block block61 = new Block();
        addObject(block61,52,584);
        Block block62 = new Block();
        addObject(block62,53,25);
        Block block63 = new Block();
        addObject(block63,84,23);
        Block block64 = new Block();
        addObject(block64,113,21);
        Block block65 = new Block();
        addObject(block65,150,21);
        Block block66 = new Block();
        addObject(block66,185,19);
        Block block67 = new Block();
        addObject(block67,221,19);
        Block block68 = new Block();
        addObject(block68,250,23);
        Block block69 = new Block();
        addObject(block69,272,23);
        Block block70 = new Block();
        addObject(block70,309,23);
        Block block71 = new Block();
        addObject(block71,337,19);
        Block block72 = new Block();
        addObject(block72,366,18);
        Block block73 = new Block();
        addObject(block73,403,18);
        Block block74 = new Block();
        addObject(block74,428,18);
        Block block75 = new Block();
        addObject(block75,458,18);
        Block block76 = new Block();
        addObject(block76,491,18);
        Block block77 = new Block();
        addObject(block77,519,16);
        Block block78 = new Block();
        addObject(block78,564,15);
        Block block79 = new Block();
        addObject(block79,601,15);
        Block block80 = new Block();
        addObject(block80,640,15);
        Block block81 = new Block();
        addObject(block81,628,15);
        Block block82 = new Block();
        addObject(block82,694,15);
        Block block83 = new Block();
        addObject(block83,728,15);
        Block block84 = new Block();
        addObject(block84,749,15);
        Player player = new Player();
        addObject(player,80,428);
        Boss boss = new Boss();
        addObject(boss,Options.WIDTH/2,428);
    }
}
