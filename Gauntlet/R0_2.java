import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class R0_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R0_2 extends Tutorial
{

    /**
     * Constructor for objects of class R0_2.
     * 
     */
    public R0_2()
    {
        super();
        freeAddObject(new ImageDisplay("Tutorial", 128, 128, 3, 6, true, 5), 650, 500);
        prepare();
    }

    public void update()
    {
        super.update();
        if (!getObjects(Player.class).isEmpty())
        {
            Player player = getObjects(Player.class).get(0);
            if (player.getTrueX() < 2)
            {
                R0_1 room = new R0_1();
                switchRoom(room, player, Options.WIDTH - 2, player.getTrueY());
            }
            if (player.getTrueX() > Options.WIDTH - 2)
            {
                R0_3 room = new R0_3();
                switchRoom(room, player, 2, player.getTrueY());
            }
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void prepare()
    {
        Block block = new Block();
        addObject(block,18,301);
        Block block2 = new Block();
        addObject(block2,19,346);
        Block block3 = new Block();
        addObject(block3,21,375);
        Block block4 = new Block();
        addObject(block4,20,408);
        Block block5 = new Block();
        addObject(block5,20,429);
        Block block6 = new Block();
        addObject(block6,20,462);
        Block block7 = new Block();
        addObject(block7,21,499);
        Block block8 = new Block();
        addObject(block8,24,533);
        Block block9 = new Block();
        addObject(block9,21,562);
        Block block10 = new Block();
        addObject(block10,21,583);
        Block block11 = new Block();
        addObject(block11,48,374);
        Block block12 = new Block();
        addObject(block12,47,408);
        Block block13 = new Block();
        addObject(block13,54,435);
        Block block14 = new Block();
        addObject(block14,42,469);
        Block block15 = new Block();
        addObject(block15,42,496);
        Block block16 = new Block();
        addObject(block16,48,531);
        Block block17 = new Block();
        addObject(block17,38,559);
        Block block18 = new Block();
        addObject(block18,52,588);
        Block block19 = new Block();
        addObject(block19,85,588);
        Block block20 = new Block();
        addObject(block20,86,552);
        Block block21 = new Block();
        addObject(block21,82,525);
        Block block22 = new Block();
        addObject(block22,87,493);
        Block block23 = new Block();
        addObject(block23,84,470);
        Block block24 = new Block();
        addObject(block24,81,432);
        Block block25 = new Block();
        addObject(block25,117,507);
        Block block26 = new Block();
        addObject(block26,117,528);
        Block block27 = new Block();
        addObject(block27,113,566);
        Block block28 = new Block();
        addObject(block28,120,583);
        Block block29 = new Block();
        addObject(block29,150,588);
        Block block30 = new Block();
        addObject(block30,150,564);
        Block block31 = new Block();
        addObject(block31,183,595);
        Block block32 = new Block();
        addObject(block32,215,595);
        Block block33 = new Block();
        addObject(block33,255,590);
        Block block34 = new Block();
        addObject(block34,275,587);
        Block block35 = new Block();
        addObject(block35,306,588);
        Block block36 = new Block();
        addObject(block36,345,589);
        Block block37 = new Block();
        addObject(block37,388,590);
        Block block38 = new Block();
        addObject(block38,369,591);
        Block block39 = new Block();
        addObject(block39,451,591);
        Block block40 = new Block();
        addObject(block40,441,593);
        Block block41 = new Block();
        addObject(block41,511,589);
        Block block42 = new Block();
        addObject(block42,18,18);
        Block block43 = new Block();
        addObject(block43,55,18);
        Block block44 = new Block();
        addObject(block44,97,16);
        Block block45 = new Block();
        addObject(block45,90,23);
        Block block46 = new Block();
        addObject(block46,137,18);
        Block block47 = new Block();
        addObject(block47,174,18);
        Block block48 = new Block();
        addObject(block48,231,18);
        Block block49 = new Block();
        addObject(block49,246,18);
        Block block50 = new Block();
        addObject(block50,281,18);
        Block block51 = new Block();
        addObject(block51,210,16);
        Block block52 = new Block();
        addObject(block52,209,16);
        Block block53 = new Block();
        addObject(block53,294,14);
        Block block54 = new Block();
        addObject(block54,352,14);
        Block block55 = new Block();
        addObject(block55,370,14);
        Block block56 = new Block();
        addObject(block56,326,17);
        Block block57 = new Block();
        addObject(block57,342,17);
        Block block58 = new Block();
        addObject(block58,390,17);
        Block block59 = new Block();
        addObject(block59,459,20);
        Block block60 = new Block();
        addObject(block60,488,21);
        Block block61 = new Block();
        addObject(block61,496,21);
        Block block62 = new Block();
        addObject(block62,432,23);
        Block block63 = new Block();
        addObject(block63,459,23);
        Block block64 = new Block();
        addObject(block64,527,20);
        Block block65 = new Block();
        addObject(block65,615,20);
        Block block66 = new Block();
        addObject(block66,633,18);
        Block block67 = new Block();
        addObject(block67,561,18);
        Block block68 = new Block();
        addObject(block68,584,18);
        Block block69 = new Block();
        addObject(block69,610,17);
        Block block70 = new Block();
        addObject(block70,653,17);
        Block block71 = new Block();
        addObject(block71,729,15);
        Block block72 = new Block();
        addObject(block72,752,13);
        Block block73 = new Block();
        addObject(block73,681,13);
        Block block74 = new Block();
        addObject(block74,788,13);
        Block block75 = new Block();
        addObject(block75,533,590);
        Block block76 = new Block();
        addObject(block76,562,587);
        Block block77 = new Block();
        addObject(block77,573,587);
        Block block78 = new Block();
        addObject(block78,588,587);
        Block block79 = new Block();
        addObject(block79,602,587);
        Block block80 = new Block();
        addObject(block80,606,587);
        Block block81 = new Block();
        addObject(block81,637,587);
        Block block82 = new Block();
        addObject(block82,644,587);
        Block block83 = new Block();
        addObject(block83,663,584);
        Block block84 = new Block();
        addObject(block84,675,584);
        Block block85 = new Block();
        addObject(block85,705,584);
        Block block86 = new Block();
        addObject(block86,714,584);
        Block block87 = new Block();
        addObject(block87,742,586);
        Block block88 = new Block();
        addObject(block88,765,586);
        Block block89 = new Block();
        addObject(block89,797,586);
        Block block179 = new Block();
        addObject(block179,765,560);
        Block block180 = new Block();
        addObject(block180,765,560);
        Block block181 = new Block();
        addObject(block181,761,523);
        Block block182 = new Block();
        addObject(block182,761,515);
        Block block183 = new Block();
        addObject(block183,759,443);
        Block block184 = new Block();
        addObject(block184,759,434);
        Block block185 = new Block();
        addObject(block185,759,377);
        Block block186 = new Block();
        addObject(block186,759,329);
        Block block187 = new Block();
        addObject(block187,760,296);
        Block block188 = new Block();
        addObject(block188,760,284);
        Block block189 = new Block();
        addObject(block189,759,260);
        Block block190 = new Block();
        addObject(block190,759,227);
        Block block191 = new Block();
        addObject(block191,759,209);
        Block block192 = new Block();
        addObject(block192,751,186);
        Block block193 = new Block();
        addObject(block193,756,393);
        Block block194 = new Block();
        addObject(block194,758,458);
        Block block195 = new Block();
        addObject(block195,755,482);
        Block block196 = new Block();
        addObject(block196,758,500);
        Block block197 = new Block();
        addObject(block197,781,553);
        Block block198 = new Block();
        addObject(block198,781,533);
        Block block199 = new Block();
        addObject(block199,782,515);
        Block block200 = new Block();
        addObject(block200,782,510);
        Block block201 = new Block();
        addObject(block201,783,488);
        Block block202 = new Block();
        addObject(block202,784,467);
        Block block203 = new Block();
        addObject(block203,787,437);
        Block block204 = new Block();
        addObject(block204,787,422);
        Block block205 = new Block();
        addObject(block205,787,410);
        Block block206 = new Block();
        addObject(block206,787,400);
        Block block207 = new Block();
        addObject(block207,787,389);
        Block block208 = new Block();
        addObject(block208,788,360);
        Block block209 = new Block();
        addObject(block209,787,341);
        Block block210 = new Block();
        addObject(block210,783,302);
        Block block211 = new Block();
        addObject(block211,782,274);
        Block block212 = new Block();
        addObject(block212,780,241);
        Block block213 = new Block();
        addObject(block213,777,206);
        Block block214 = new Block();
        addObject(block214,775,181);
        Block block251 = new Block();
        addObject(block251,749,136);
        Block block252 = new Block();
        addObject(block252,779,137);
    }
}
