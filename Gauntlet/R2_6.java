import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R2_6 extends Level2
{
    public R2_6()
    {
        super();
        prepare();
    }

    public void update()
    {
        super.update();
        if (!getObjects(Player.class).isEmpty())
        {
            Player player = getObjects(Player.class).get(0);
            if (player.getY() + 65 < 2)
            {
                R2_7 room = new R2_7();
                switchRoom(room, player, player.getTrueX(), Options.HEIGHT - 2 - 65);
            }
        }
    }

    public void prepare()
    {
        Block block = new Block();
        addObject(block,17,586);
        Block block2 = new Block();
        addObject(block2,13,560);
        Block block3 = new Block();
        addObject(block3,18,528);
        Block block4 = new Block();
        addObject(block4,14,497);
        Block block5 = new Block();
        addObject(block5,5,465);
        Block block6 = new Block();
        addObject(block6,7,427);
        Block block7 = new Block();
        addObject(block7,10,404);
        Block block8 = new Block();
        addObject(block8,6,366);
        Block block9 = new Block();
        addObject(block9,10,327);
        Block block10 = new Block();
        addObject(block10,10,293);
        Block block11 = new Block();
        addObject(block11,10,266);
        Block block12 = new Block();
        addObject(block12,9,234);
        Block block13 = new Block();
        addObject(block13,9,191);
        Block block14 = new Block();
        addObject(block14,11,200);
        Block block15 = new Block();
        addObject(block15,787,18);
        Block block16 = new Block();
        addObject(block16,788,51);
        Block block17 = new Block();
        addObject(block17,787,81);
        Block block18 = new Block();
        addObject(block18,787,102);
        Block block19 = new Block();
        addObject(block19,787,140);
        Block block20 = new Block();
        addObject(block20,790,174);
        Block block21 = new Block();
        addObject(block21,789,210);
        Block block22 = new Block();
        addObject(block22,793,256);
        Block block23 = new Block();
        addObject(block23,794,270);
        Block block24 = new Block();
        addObject(block24,794,296);
        Block block25 = new Block();
        addObject(block25,794,333);
        Block block26 = new Block();
        addObject(block26,781,242);
        Block block27 = new Block();
        addObject(block27,781,369);
        Block block28 = new Block();
        addObject(block28,782,390);
        Block block29 = new Block();
        addObject(block29,783,408);
        Block block30 = new Block();
        addObject(block30,787,440);
        Block block31 = new Block();
        addObject(block31,790,487);
        Block block32 = new Block();
        addObject(block32,793,507);
        Block block33 = new Block();
        addObject(block33,789,477);
        Block block34 = new Block();
        addObject(block34,784,525);
        Block block35 = new Block();
        addObject(block35,784,560);
        Block block36 = new Block();
        addObject(block36,776,593);
        Block block37 = new Block();
        addObject(block37,758,594);
        Block block38 = new Block();
        addObject(block38,713,594);
        Block block39 = new Block();
        addObject(block39,700,594);
        Block block40 = new Block();
        addObject(block40,673,594);
        Block block41 = new Block();
        addObject(block41,632,594);
        Block block42 = new Block();
        addObject(block42,615,594);
        Block block43 = new Block();
        addObject(block43,596,594);
        Block block44 = new Block();
        addObject(block44,655,582);
        Block block45 = new Block();
        addObject(block45,559,588);
        Block block46 = new Block();
        addObject(block46,514,587);
        Block block47 = new Block();
        addObject(block47,478,588);
        Block block48 = new Block();
        addObject(block48,182,561);
        Block block49 = new Block();
        addObject(block49,184,528);
        Block block50 = new Block();
        addObject(block50,176,489);
        Block block51 = new Block();
        addObject(block51,15,141);
        Block block52 = new Block();
        addObject(block52,19,104);
        Block block53 = new Block();
        addObject(block53,21,62);
        Block block54 = new Block();
        addObject(block54,14,84);
        Block block55 = new Block();
        addObject(block55,11,7);
        Block block56 = new Block();
        addObject(block56,43,9);
        Block block57 = new Block();
        addObject(block57,80,6);
        Block block58 = new Block();
        addObject(block58,108,6);
        Block block59 = new Block();
        addObject(block59,148,10);
        Block block60 = new Block();
        addObject(block60,178,10);
        Block block61 = new Block();
        addObject(block61,214,16);
        Block block62 = new Block();
        addObject(block62,249,15);
        Block block63 = new Block();
        addObject(block63,269,18);
        Block block64 = new Block();
        addObject(block64,300,18);
        Block block65 = new Block();
        addObject(block65,345,15);
        Block block66 = new Block();
        addObject(block66,384,15);
        Block block67 = new Block();
        addObject(block67,424,15);
        Block block68 = new Block();
        addObject(block68,374,15);
        Block block69 = new Block();
        addObject(block69,464,12);
        Block block70 = new Block();
        addObject(block70,627,12);
        Block block71 = new Block();
        addObject(block71,589,12);
        Block block72 = new Block();
        addObject(block72,565,15);
        Block block73 = new Block();
        addObject(block73,528,15);
        Block block74 = new Block();
        addObject(block74,493,15);
        Block block75 = new Block();
        addObject(block75,180,582);
        Block block76 = new Block();
        addObject(block76,199,585);
        Block block77 = new Block();
        addObject(block77,238,586);
        Block block78 = new Block();
        addObject(block78,273,588);
        Block block79 = new Block();
        addObject(block79,320,590);
        Block block80 = new Block();
        addObject(block80,305,590);
        Block block81 = new Block();
        addObject(block81,364,589);
        Block block82 = new Block();
        addObject(block82,403,587);
        Block block83 = new Block();
        addObject(block83,438,585);
        Block block84 = new Block();
        addObject(block84,504,588);
        Block block85 = new Block();
        addObject(block85,176,465);
        Block block86 = new Block();
        addObject(block86,176,430);
        Block block87 = new Block();
        addObject(block87,176,411);
        Block block88 = new Block();
        addObject(block88,178,358);
        Block block89 = new Block();
        addObject(block89,172,342);
        Block block90 = new Block();
        addObject(block90,172,303);
        Block block91 = new Block();
        addObject(block91,180,264);
        Block block92 = new Block();
        addObject(block92,180,240);
        Block block93 = new Block();
        addObject(block93,177,210);
        Block block94 = new Block();
        addObject(block94,181,180);
        Block block95 = new Block();
        addObject(block95,204,180);
        Block block96 = new Block();
        addObject(block96,204,205);
        Block block97 = new Block();
        addObject(block97,198,237);
        Block block98 = new Block();
        addObject(block98,204,272);
        Block block99 = new Block();
        addObject(block99,205,300);
        Block block100 = new Block();
        addObject(block100,206,332);
        Block block101 = new Block();
        addObject(block101,209,372);
        Block block102 = new Block();
        addObject(block102,212,405);
        Block block103 = new Block();
        addObject(block103,215,431);
        Block block104 = new Block();
        addObject(block104,215,462);
        Block block105 = new Block();
        addObject(block105,210,504);
        Block block106 = new Block();
        addObject(block106,205,534);
        Block block107 = new Block();
        addObject(block107,205,556);
        Block block108 = new Block();
        addObject(block108,237,557);
        Block block109 = new Block();
        addObject(block109,275,559);
        Block block110 = new Block();
        addObject(block110,305,561);
        Block block111 = new Block();
        addObject(block111,246,534);
        Block block112 = new Block();
        addObject(block112,242,494);
        Block block113 = new Block();
        addObject(block113,275,536);
        Block block114 = new Block();
        addObject(block114,235,468);
        Block block115 = new Block();
        addObject(block115,336,570);
        Block block116 = new Block();
        addObject(block116,752,148);
        Block block117 = new Block();
        addObject(block117,710,150);
        Block block118 = new Block();
        addObject(block118,687,148);
        Block block119 = new Block();
        addObject(block119,380,182);
        Block block120 = new Block();
        addObject(block120,380,141);
        Block block121 = new Block();
        addObject(block121,376,109);
        Block block122 = new Block();
        addObject(block122,370,86);
        Block block123 = new Block();
        addObject(block123,370,39);
        Block block124 = new Block();
        addObject(block124,374,217);
        Block block125 = new Block();
        addObject(block125,374,254);
        Block block126 = new Block();
        addObject(block126,406,251);
        Block block127 = new Block();
        addObject(block127,445,251);
        Block block128 = new Block();
        addObject(block128,376,275);
        Block block129 = new Block();
        addObject(block129,371,309);
        Block block130 = new Block();
        addObject(block130,375,339);
        Block block131 = new Block();
        addObject(block131,375,372);
        Block block132 = new Block();
        addObject(block132,376,405);
        Block block133 = new Block();
        addObject(block133,410,396);
        Block block134 = new Block();
        addObject(block134,445,402);
        Block block135 = new Block();
        addObject(block135,471,402);
        Block block136 = new Block();
        addObject(block136,512,400);
        Block block137 = new Block();
        addObject(block137,508,407);
        Block block138 = new Block();
        addObject(block138,562,405);
        Block block139 = new Block();
        addObject(block139,606,405);
        Block block140 = new Block();
        addObject(block140,629,398);
        Block block141 = new Block();
        addObject(block141,665,400);
        removeObject(block127);
        removeObject(block126);
        Block block142 = new Block();
        addObject(block142,750,279);
        Block block143 = new Block();
        addObject(block143,718,272);
        Block block144 = new Block();
        addObject(block144,686,272);
        Block block145 = new Block();
        addObject(block145,659,272);
        Block block146 = new Block();
        addObject(block146,634,271);
        Block block147 = new Block();
        addObject(block147,598,271);
        Block block148 = new Block();
        addObject(block148,571,271);
        Block block149 = new Block();
        addObject(block149,538,273);
        Block block150 = new Block();
        addObject(block150,505,273);
        Cardinal2 cardinal2 = new Cardinal2();
        addObject(cardinal2,686,499);
        Slime2 slime24 = new Slime2();
        addObject(slime24,712,77);
        Slime2 slime25 = new Slime2();
        addObject(slime25,552,198);
        Slime2 slime26 = new Slime2();
        addObject(slime26,427,338);
    }
}