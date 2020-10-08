import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class R0_4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R0_4 extends Tutorial
{

    /**
     * Constructor for objects of class R0_4.
     * 
     */
    public R0_4()
    {
        super();
        freeAddObject(new ImageDisplay("Tutorial", 128, 128, 7, 11, true, 10), 200, 200);
        prepare();
    }

    public void update()
    {
        super.update();
        if (Global.updateTime % 100 == 0)
        {
            freeAddObject(new Slime(), Options.WIDTH /2 + (Greenfoot.getRandomNumber(3) - 1) * 100, 200);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void prepare()
    {
        Block block = new Block();
        addObject(block,11,589);
        Block block2 = new Block();
        addObject(block2,12,561);
        Block block3 = new Block();
        addObject(block3,11,510);
        Block block4 = new Block();
        addObject(block4,8,528);
        Block block5 = new Block();
        addObject(block5,13,459);
        Block block6 = new Block();
        addObject(block6,8,430);
        Block block7 = new Block();
        addObject(block7,9,402);
        Block block8 = new Block();
        addObject(block8,22,354);
        Block block9 = new Block();
        addObject(block9,5,334);
        Block block10 = new Block();
        addObject(block10,5,306);
        Block block11 = new Block();
        addObject(block11,9,265);
        Block block12 = new Block();
        addObject(block12,14,243);
        Block block13 = new Block();
        addObject(block13,17,197);
        Block block14 = new Block();
        addObject(block14,17,166);
        Block block15 = new Block();
        addObject(block15,17,148);
        Block block16 = new Block();
        addObject(block16,20,112);
        Block block17 = new Block();
        addObject(block17,17,78);
        Block block18 = new Block();
        addObject(block18,17,51);
        Block block19 = new Block();
        addObject(block19,12,9);
        Block block20 = new Block();
        addObject(block20,50,3);
        Block block21 = new Block();
        addObject(block21,76,12);
        Block block22 = new Block();
        addObject(block22,83,12);
        Block block23 = new Block();
        addObject(block23,121,12);
        Block block24 = new Block();
        addObject(block24,131,12);
        Block block25 = new Block();
        addObject(block25,165,11);
        Block block26 = new Block();
        addObject(block26,183,10);
        Block block27 = new Block();
        addObject(block27,200,7);
        Block block28 = new Block();
        addObject(block28,231,7);
        Block block29 = new Block();
        addObject(block29,254,6);
        Block block30 = new Block();
        addObject(block30,290,6);
        Block block31 = new Block();
        addObject(block31,326,6);
        Block block32 = new Block();
        addObject(block32,344,6);
        Block block33 = new Block();
        addObject(block33,245,7);
        Block block34 = new Block();
        addObject(block34,277,7);
        Block block35 = new Block();
        addObject(block35,279,7);
        Block block36 = new Block();
        addObject(block36,351,10);
        Block block37 = new Block();
        addObject(block37,373,11);
        Block block38 = new Block();
        addObject(block38,409,11);
        Block block39 = new Block();
        addObject(block39,468,10);
        Block block40 = new Block();
        addObject(block40,479,10);
        Block block41 = new Block();
        addObject(block41,437,17);
        Block block42 = new Block();
        addObject(block42,453,17);
        Block block43 = new Block();
        addObject(block43,505,20);
        Block block44 = new Block();
        addObject(block44,505,20);
        Block block45 = new Block();
        addObject(block45,524,19);
        Block block46 = new Block();
        addObject(block46,536,16);
        Block block47 = new Block();
        addObject(block47,555,16);
        Block block48 = new Block();
        addObject(block48,567,15);
        Block block49 = new Block();
        addObject(block49,587,11);
        Block block50 = new Block();
        addObject(block50,602,11);
        Block block51 = new Block();
        addObject(block51,622,11);
        Block block52 = new Block();
        addObject(block52,639,11);
        Block block53 = new Block();
        addObject(block53,658,11);
        Block block54 = new Block();
        addObject(block54,686,11);
        Block block55 = new Block();
        addObject(block55,716,11);
        Block block56 = new Block();
        addObject(block56,735,11);
        Block block57 = new Block();
        addObject(block57,755,11);
        Block block58 = new Block();
        addObject(block58,772,12);
        Block block59 = new Block();
        addObject(block59,797,12);
        Block block60 = new Block();
        addObject(block60,798,27);
        Block block61 = new Block();
        addObject(block61,794,43);
        Block block62 = new Block();
        addObject(block62,790,61);
        Block block63 = new Block();
        addObject(block63,790,86);
        Block block64 = new Block();
        addObject(block64,791,100);
        Block block65 = new Block();
        addObject(block65,797,137);
        Block block66 = new Block();
        addObject(block66,796,172);
        Block block67 = new Block();
        addObject(block67,794,192);
        Block block68 = new Block();
        addObject(block68,794,201);
        Block block69 = new Block();
        addObject(block69,794,217);
        Block block70 = new Block();
        addObject(block70,794,246);
        Block block71 = new Block();
        addObject(block71,794,263);
        Block block72 = new Block();
        addObject(block72,794,273);
        Block block73 = new Block();
        addObject(block73,797,301);
        Block block74 = new Block();
        addObject(block74,798,327);
        Block block75 = new Block();
        addObject(block75,798,356);
        Block block76 = new Block();
        addObject(block76,798,372);
        Block block77 = new Block();
        addObject(block77,798,397);
        Block block78 = new Block();
        addObject(block78,798,403);
        Block block79 = new Block();
        addObject(block79,796,444);
        Block block80 = new Block();
        addObject(block80,793,460);
        Block block81 = new Block();
        addObject(block81,793,475);
        Block block82 = new Block();
        addObject(block82,792,508);
        Block block83 = new Block();
        addObject(block83,792,540);
        Block block84 = new Block();
        addObject(block84,788,565);
        Block block85 = new Block();
        addObject(block85,788,569);
        Block block86 = new Block();
        addObject(block86,788,588);
        Block block87 = new Block();
        addObject(block87,758,591);
        Block block88 = new Block();
        addObject(block88,728,592);
        Block block89 = new Block();
        addObject(block89,695,593);
        Block block90 = new Block();
        addObject(block90,617,594);
        Block block91 = new Block();
        addObject(block91,591,594);
        Block block92 = new Block();
        addObject(block92,647,587);
        Block block93 = new Block();
        addObject(block93,659,587);
        Block block94 = new Block();
        addObject(block94,563,587);
        Block block95 = new Block();
        addObject(block95,503,588);
        Block block96 = new Block();
        addObject(block96,487,588);
        Block block97 = new Block();
        addObject(block97,457,588);
        Block block98 = new Block();
        addObject(block98,386,590);
        Block block99 = new Block();
        addObject(block99,335,592);
        Block block100 = new Block();
        addObject(block100,246,592);
        Block block101 = new Block();
        addObject(block101,95,593);
        Block block102 = new Block();
        addObject(block102,37,592);
        Block block103 = new Block();
        addObject(block103,72,593);
        Block block104 = new Block();
        addObject(block104,131,593);
        Block block105 = new Block();
        addObject(block105,119,589);
        Block block106 = new Block();
        addObject(block106,167,582);
        Block block107 = new Block();
        addObject(block107,214,586);
        Block block108 = new Block();
        addObject(block108,227,586);
        Block block109 = new Block();
        addObject(block109,250,587);
        Block block110 = new Block();
        addObject(block110,292,588);
        Block block111 = new Block();
        addObject(block111,317,588);
        Block block112 = new Block();
        addObject(block112,284,591);
        Block block113 = new Block();
        addObject(block113,361,582);
        Block block114 = new Block();
        addObject(block114,398,585);
        Block block115 = new Block();
        addObject(block115,452,588);
        block115.setLocation(471,592);
        Block block116 = new Block();
        addObject(block116,514,588);
        Block block117 = new Block();
        addObject(block117,534,588);
        Block block118 = new Block();
        addObject(block118,426,584);
    }
}
