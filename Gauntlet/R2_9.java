import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R2_9 extends Level2
{
    public R2_9()
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
                R2_10 room = new R2_10();
                switchRoom(room, player, player.getTrueX(), Options.HEIGHT - 2 - 65);
            }
        }
    }

    public void prepare()
    {
        Block block239 = new Block();
        addObject(block239,779,20);
        Block block240 = new Block();
        addObject(block240,752,14);
        Block block241 = new Block();
        addObject(block241,779,590);
        Block block242 = new Block();
        addObject(block242,726,595);
        Block block243 = new Block();
        addObject(block243,749,587);
        Block block244 = new Block();
        addObject(block244,695,583);
        Block block245 = new Block();
        addObject(block245,663,583);
        Block block246 = new Block();
        addObject(block246,623,585);
        Block block247 = new Block();
        addObject(block247,588,585);
        Block block248 = new Block();
        addObject(block248,565,581);
        Block block249 = new Block();
        addObject(block249,398,588);
        Block block250 = new Block();
        addObject(block250,374,587);
        Block block251 = new Block();
        addObject(block251,339,590);
        Block block252 = new Block();
        addObject(block252,296,596);
        Block block253 = new Block();
        addObject(block253,266,590);
        Block block254 = new Block();
        addObject(block254,246,588);
        Block block255 = new Block();
        addObject(block255,215,586);
        Block block256 = new Block();
        addObject(block256,156,592);
        Block block257 = new Block();
        addObject(block257,179,595);
        Block block258 = new Block();
        addObject(block258,114,584);
        Block block259 = new Block();
        addObject(block259,69,590);
        Block block260 = new Block();
        addObject(block260,29,588);
        Block block261 = new Block();
        addObject(block261,38,589);
        Block block262 = new Block();
        addObject(block262,24,572);
        Block block263 = new Block();
        addObject(block263,15,522);
        Block block264 = new Block();
        addObject(block264,12,477);
        Block block265 = new Block();
        addObject(block265,11,506);
        Block block266 = new Block();
        addObject(block266,12,427);
        Block block267 = new Block();
        addObject(block267,15,392);
        Block block268 = new Block();
        addObject(block268,17,346);
        Block block269 = new Block();
        addObject(block269,21,368);
        Block block270 = new Block();
        addObject(block270,18,317);
        Block block271 = new Block();
        addObject(block271,16,244);
        Block block272 = new Block();
        addObject(block272,10,274);
        Block block273 = new Block();
        addObject(block273,11,211);
        Block block274 = new Block();
        addObject(block274,17,168);
        Block block275 = new Block();
        addObject(block275,20,138);
        Block block276 = new Block();
        addObject(block276,23,108);
        Block block277 = new Block();
        addObject(block277,18,84);
        Block block278 = new Block();
        addObject(block278,24,47);
        Block block279 = new Block();
        addObject(block279,16,13);
        Block block280 = new Block();
        addObject(block280,608,559);
        Block block281 = new Block();
        addObject(block281,660,558);
        Block block282 = new Block();
        addObject(block282,787,554);
        Block block283 = new Block();
        addObject(block283,784,532);
        Block block284 = new Block();
        addObject(block284,790,493);
        Block block285 = new Block();
        addObject(block285,788,471);
        Block block286 = new Block();
        addObject(block286,787,438);
        Block block287 = new Block();
        addObject(block287,791,398);
        Block block288 = new Block();
        addObject(block288,787,364);
        Block block289 = new Block();
        addObject(block289,784,334);
        Block block290 = new Block();
        addObject(block290,782,300);
        Block block291 = new Block();
        addObject(block291,782,267);
        Block block292 = new Block();
        addObject(block292,795,235);
        Block block293 = new Block();
        addObject(block293,791,208);
        Block block294 = new Block();
        addObject(block294,785,177);
        Block block295 = new Block();
        addObject(block295,789,145);
        Block block296 = new Block();
        addObject(block296,786,113);
        Block block297 = new Block();
        addObject(block297,789,85);
        Block block298 = new Block();
        addObject(block298,787,45);
        Block block299 = new Block();
        addObject(block299,757,460);
        Block block300 = new Block();
        addObject(block300,721,456);
        Block block301 = new Block();
        addObject(block301,701,461);
        Block block302 = new Block();
        addObject(block302,525,356);
        Block block303 = new Block();
        addObject(block303,557,366);
        Block block304 = new Block();
        addObject(block304,582,371);
        Block block305 = new Block();
        addObject(block305,238,338);
        Block block306 = new Block();
        addObject(block306,268,333);
        Block block307 = new Block();
        addObject(block307,303,332);
        Block block308 = new Block();
        addObject(block308,236,206);
        Block block309 = new Block();
        addObject(block309,274,209);
        Block block310 = new Block();
        addObject(block310,302,207);
        Block block311 = new Block();
        addObject(block311,531,173);
        Block block312 = new Block();
        addObject(block312,568,168);
        Block block313 = new Block();
        addObject(block313,589,168);
        Block block314 = new Block();
        addObject(block314,213,100);
        Block block315 = new Block();
        addObject(block315,176,118);
        Block block316 = new Block();
        addObject(block316,148,113);
        Block block317 = new Block();
        addObject(block317,61,19);
        Block block318 = new Block();
        addObject(block318,81,17);
        Block block319 = new Block();
        addObject(block319,111,13);
        Block block320 = new Block();
        addObject(block320,136,15);
        Block block321 = new Block();
        addObject(block321,148,14);
        Block block322 = new Block();
        addObject(block322,191,17);
        Block block323 = new Block();
        addObject(block323,227,19);
        Block block324 = new Block();
        addObject(block324,214,16);
        Block block325 = new Block();
        addObject(block325,261,20);
        Block block326 = new Block();
        addObject(block326,302,18);
        Block block327 = new Block();
        addObject(block327,337,19);
        Block block328 = new Block();
        addObject(block328,363,17);
        Block block329 = new Block();
        addObject(block329,408,17);
        Block block330 = new Block();
        addObject(block330,433,12);
        Block block331 = new Block();
        addObject(block331,467,16);
        Block block332 = new Block();
        addObject(block332,516,20);
        Block block333 = new Block();
        addObject(block333,502,21);
        Block block334 = new Block();
        addObject(block334,562,17);
        Block block335 = new Block();
        addObject(block335,114,469);
        Block block336 = new Block();
        addObject(block336,140,471);
        Block block337 = new Block();
        addObject(block337,187,453);
        Block block338 = new Block();
        addObject(block338,276,525);
        Block block339 = new Block();
        addObject(block339,307,531);
        Block block340 = new Block();
        addObject(block340,338,525);
        Block block341 = new Block();
        addObject(block341,756,119);
        Block block342 = new Block();
        addObject(block342,732,121);
        Block block343 = new Block();
        addObject(block343,748,55);
        Block block344 = new Block();
        addObject(block344,751,91);
        Block block345 = new Block();
        addObject(block345,695,285);
        Block block346 = new Block();
        addObject(block346,715,280);
        Block block347 = new Block();
        addObject(block347,760,279);
        Block block348 = new Block();
        addObject(block348,429,288);
        Block block349 = new Block();
        addObject(block349,88,294);
        Block block350 = new Block();
        addObject(block350,52,180);
        removeObject(block280);
        removeObject(block281);
        Block block351 = new Block();
        addObject(block351,589,520);
        Cardinal2 cardinal2 = new Cardinal2();
        addObject(cardinal2,150,245);
        Cardinal2 cardinal22 = new Cardinal2();
        addObject(cardinal22,84,374);
        Cardinal2 cardinal23 = new Cardinal2();
        addObject(cardinal23,714,175);
    }
}
