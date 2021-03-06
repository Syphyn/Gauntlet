import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R2_8 extends Level2
{
    public R2_8()
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
                R2_9 room = new R2_9();
                switchRoom(room, player, player.getTrueX(), Options.HEIGHT - 2 - 65);
            }
        }
    }

    public void prepare()
    {
        Block block154 = new Block();
        addObject(block154,777,589);
        Block block155 = new Block();
        addObject(block155,750,588);
        Block block156 = new Block();
        addObject(block156,715,592);
        Block block157 = new Block();
        addObject(block157,689,588);
        Block block158 = new Block();
        addObject(block158,637,587);
        Block block159 = new Block();
        addObject(block159,653,589);
        Block block160 = new Block();
        addObject(block160,599,583);
        Block block161 = new Block();
        addObject(block161,555,586);
        Block block162 = new Block();
        addObject(block162,392,587);
        Block block163 = new Block();
        addObject(block163,364,590);
        Block block164 = new Block();
        addObject(block164,331,587);
        Block block165 = new Block();
        addObject(block165,293,587);
        Block block166 = new Block();
        addObject(block166,245,586);
        Block block167 = new Block();
        addObject(block167,267,587);
        Block block168 = new Block();
        addObject(block168,216,584);
        Block block169 = new Block();
        addObject(block169,170,588);
        Block block170 = new Block();
        addObject(block170,141,588);
        Block block171 = new Block();
        addObject(block171,112,586);
        Block block172 = new Block();
        addObject(block172,74,587);
        Block block173 = new Block();
        addObject(block173,42,585);
        Block block174 = new Block();
        addObject(block174,16,585);
        Block block175 = new Block();
        addObject(block175,15,568);
        Block block176 = new Block();
        addObject(block176,20,549);
        Block block177 = new Block();
        addObject(block177,25,526);
        Block block178 = new Block();
        addObject(block178,25,494);
        Block block179 = new Block();
        addObject(block179,20,468);
        Block block180 = new Block();
        addObject(block180,14,421);
        Block block181 = new Block();
        addObject(block181,10,394);
        Block block182 = new Block();
        addObject(block182,13,356);
        Block block183 = new Block();
        addObject(block183,11,333);
        Block block184 = new Block();
        addObject(block184,16,301);
        Block block185 = new Block();
        addObject(block185,17,278);
        Block block186 = new Block();
        addObject(block186,19,241);
        Block block187 = new Block();
        addObject(block187,12,206);
        Block block188 = new Block();
        addObject(block188,17,179);
        Block block189 = new Block();
        addObject(block189,22,154);
        Block block190 = new Block();
        addObject(block190,12,99);
        Block block191 = new Block();
        addObject(block191,11,69);
        Block block192 = new Block();
        addObject(block192,15,48);
        Block block193 = new Block();
        addObject(block193,17,8);
        Block block194 = new Block();
        addObject(block194,45,6);
        Block block195 = new Block();
        addObject(block195,71,3);
        Block block196 = new Block();
        addObject(block196,126,10);
        Block block197 = new Block();
        addObject(block197,126,20);
        Block block198 = new Block();
        addObject(block198,174,23);
        Block block199 = new Block();
        addObject(block199,149,21);
        Block block200 = new Block();
        addObject(block200,248,10);
        Block block201 = new Block();
        addObject(block201,222,15);
        Block block202 = new Block();
        addObject(block202,278,13);
        Block block203 = new Block();
        addObject(block203,332,20);
        Block block204 = new Block();
        addObject(block204,304,19);
        Block block205 = new Block();
        addObject(block205,357,13);
        Block block206 = new Block();
        addObject(block206,411,18);
        Block block207 = new Block();
        addObject(block207,568,19);
        Block block208 = new Block();
        addObject(block208,601,13);
        Block block209 = new Block();
        addObject(block209,626,12);
        Block block210 = new Block();
        addObject(block210,646,12);
        Block block211 = new Block();
        addObject(block211,696,17);
        Block block212 = new Block();
        addObject(block212,721,16);
        Block block213 = new Block();
        addObject(block213,749,14);
        Block block214 = new Block();
        addObject(block214,783,17);
        Block block215 = new Block();
        addObject(block215,789,55);
        Block block216 = new Block();
        addObject(block216,789,87);
        Block block217 = new Block();
        addObject(block217,788,117);
        Block block218 = new Block();
        addObject(block218,788,155);
        Block block219 = new Block();
        addObject(block219,793,189);
        Block block220 = new Block();
        addObject(block220,796,207);
        Block block221 = new Block();
        addObject(block221,792,246);
        Block block222 = new Block();
        addObject(block222,793,262);
        Block block223 = new Block();
        addObject(block223,790,302);
        Block block224 = new Block();
        addObject(block224,786,343);
        Block block225 = new Block();
        addObject(block225,793,374);
        Block block226 = new Block();
        addObject(block226,794,414);
        Block block227 = new Block();
        addObject(block227,787,445);
        Block block228 = new Block();
        addObject(block228,787,478);
        Block block229 = new Block();
        addObject(block229,784,517);
        Block block230 = new Block();
        addObject(block230,783,534);
        Block block231 = new Block();
        addObject(block231,791,559);
        Block block232 = new Block();
        Block block233 = new Block();
        addObject(block233,779,488);
        Block block234 = new Block();
        addObject(block234,242,558);
        Block block235 = new Block();
        addObject(block235,216,561);
        Block block236 = new Block();
        addObject(block236,183,561);
        Block block237 = new Block();
        addObject(block237,145,561);
        Block block238 = new Block();
        addObject(block238,108,560);
        Block block239 = new Block();
        addObject(block239,75,556);
        Block block240 = new Block();
        addObject(block240,43,558);
        Block block241 = new Block();
        addObject(block241,31,534);
        Block block242 = new Block();
        addObject(block242,72,532);
        Block block243 = new Block();
        addObject(block243,101,527);
        Block block244 = new Block();
        addObject(block244,50,517);
        Block block245 = new Block();
        addObject(block245,48,508);
        Block block246 = new Block();
        addObject(block246,78,494);
        Block block247 = new Block();
        addObject(block247,97,497);
        Block block248 = new Block();
        addObject(block248,117,498);
        Block block249 = new Block();
        addObject(block249,149,513);
        Block block250 = new Block();
        addObject(block250,148,504);
        Block block251 = new Block();
        addObject(block251,194,525);
        Block block252 = new Block();
        addObject(block252,178,497);
        Block block253 = new Block();
        addObject(block253,184,532);
        Block block254 = new Block();
        addObject(block254,163,473);
        Block block255 = new Block();
        addObject(block255,123,464);
        Block block256 = new Block();
        addObject(block256,95,460);
        Block block257 = new Block();
        addObject(block257,48,457);
        Block block258 = new Block();
        addObject(block258,45,439);
        Block block259 = new Block();
        addObject(block259,69,440);
        Block block260 = new Block();
        addObject(block260,97,434);
        Block block261 = new Block();
        addObject(block261,141,459);
        Block block262 = new Block();
        addObject(block262,141,434);
        Block block263 = new Block();
        addObject(block263,123,405);
        Block block264 = new Block();
        addObject(block264,82,410);
        Block block265 = new Block();
        addObject(block265,49,396);
        Block block266 = new Block();
        addObject(block266,46,368);
        Block block267 = new Block();
        addObject(block267,43,314);
        Block block268 = new Block();
        addObject(block268,73,375);
        Block block269 = new Block();
        addObject(block269,55,347);
        Block block270 = new Block();
        addObject(block270,80,334);
        Block block271 = new Block();
        addObject(block271,107,363);
        Block block272 = new Block();
        addObject(block272,147,398);
        Block block273 = new Block();
        addObject(block273,181,430);
        Block block274 = new Block();
        addObject(block274,218,498);
        Block block275 = new Block();
        addObject(block275,213,469);
        Block block276 = new Block();
        addObject(block276,245,515);
        Block block277 = new Block();
        addObject(block277,244,505);
        Block block278 = new Block();
        addObject(block278,289,553);
        Block block279 = new Block();
        addObject(block279,284,531);
        Block block280 = new Block();
        addObject(block280,280,557);
        Block block281 = new Block();
        addObject(block281,569,561);
        Block block282 = new Block();
        addObject(block282,593,539);
        Block block283 = new Block();
        addObject(block283,604,568);
        Block block284 = new Block();
        addObject(block284,621,566);
        Block block285 = new Block();
        addObject(block285,624,534);
        Block block286 = new Block();
        addObject(block286,656,546);
        Block block287 = new Block();
        addObject(block287,663,520);
        Block block288 = new Block();
        addObject(block288,663,492);
        Block block289 = new Block();
        addObject(block289,639,494);
        Block block290 = new Block();
        addObject(block290,662,465);
        Block block291 = new Block();
        addObject(block291,696,562);
        Block block292 = new Block();
        addObject(block292,693,534);
        Block block293 = new Block();
        addObject(block293,690,479);
        Block block294 = new Block();
        addObject(block294,694,499);
        Block block295 = new Block();
        addObject(block295,686,437);
        Block block296 = new Block();
        addObject(block296,735,558);
        Block block297 = new Block();
        addObject(block297,732,532);
        Block block298 = new Block();
        addObject(block298,724,486);
        Block block299 = new Block();
        addObject(block299,725,464);
        Block block300 = new Block();
        addObject(block300,725,432);
        Block block301 = new Block();
        addObject(block301,728,382);
        Block block302 = new Block();
        addObject(block302,767,554);
        Block block303 = new Block();
        addObject(block303,758,515);
        Block block304 = new Block();
        addObject(block304,756,486);
        Block block305 = new Block();
        addObject(block305,754,467);
        Block block306 = new Block();
        addObject(block306,756,437);
        Block block307 = new Block();
        addObject(block307,756,397);
        Block block308 = new Block();
        addObject(block308,721,400);
        Block block309 = new Block();
        addObject(block309,749,365);
        Block block310 = new Block();
        addObject(block310,746,330);
        Block block311 = new Block();
        addObject(block311,686,397);
        Block block312 = new Block();
        addObject(block312,661,433);
        Block block313 = new Block();
        addObject(block313,633,460);
        Block block314 = new Block();
        addObject(block314,598,487);
        Block block315 = new Block();
        addObject(block315,568,526);
        Block block316 = new Block();
        addObject(block316,343,567);
        Block block317 = new Block();
        addObject(block317,368,562);
        Block block318 = new Block();
        addObject(block318,365,533);
        Block block319 = new Block();
        addObject(block319,344,532);
        Block block320 = new Block();
        addObject(block320,311,527);
        Block block321 = new Block();
        addObject(block321,334,500);
        Block block322 = new Block();
        addObject(block322,294,504);
        Block block323 = new Block();
        addObject(block323,263,492);
        Block block324 = new Block();
        addObject(block324,262,469);
        Block block325 = new Block();
        addObject(block325,303,470);
        Block block326 = new Block();
        addObject(block326,407,556);
        Block block327 = new Block();
        addObject(block327,250,470);
        Block block328 = new Block();
        addObject(block328,218,434);
        Block block329 = new Block();
        addObject(block329,268,441);
        Block block330 = new Block();
        addObject(block330,241,435);
        Block block331 = new Block();
        addObject(block331,234,401);
        Block block332 = new Block();
        addObject(block332,200,403);
        Block block333 = new Block();
        addObject(block333,149,398);
        Block block334 = new Block();
        addObject(block334,167,396);
        Block block335 = new Block();
        addObject(block335,214,372);
        Block block336 = new Block();
        addObject(block336,163,368);
        Block block337 = new Block();
        addObject(block337,143,366);
        Block block338 = new Block();
        addObject(block338,167,328);
        Block block339 = new Block();
        addObject(block339,137,331);
        Block block340 = new Block();
        addObject(block340,101,339);
        Block block341 = new Block();
        addObject(block341,137,304);
        Block block342 = new Block();
        addObject(block342,110,303);
        Block block343 = new Block();
        addObject(block343,51,305);
        Block block344 = new Block();
        addObject(block344,71,304);
        Block block345 = new Block();
        addObject(block345,108,272);
        Block block346 = new Block();
        addObject(block346,83,273);
        Block block347 = new Block();
        addObject(block347,58,272);
        Block block348 = new Block();
        addObject(block348,72,246);
        Block block349 = new Block();
        addObject(block349,56,244);
        Block block350 = new Block();
        addObject(block350,50,216);
        Block block351 = new Block();
        addObject(block351,241,183);
        Block block352 = new Block();
        addObject(block352,269,187);
        Block block353 = new Block();
        addObject(block353,307,181);
        Block block354 = new Block();
        addObject(block354,352,187);
        Block block355 = new Block();
        addObject(block355,359,178);
        Block block356 = new Block();
        addObject(block356,356,180);
        Block block357 = new Block();
        addObject(block357,348,179);
        Block block358 = new Block();
        addObject(block358,397,183);
        Block block359 = new Block();
        addObject(block359,453,184);
        Block block360 = new Block();
        addObject(block360,435,182);
        Block block361 = new Block();
        addObject(block361,500,188);
        Block block362 = new Block();
        addObject(block362,547,181);
        Block block363 = new Block();
        addObject(block363,534,181);
        Block block364 = new Block();
        addObject(block364,599,176);
        Block block365 = new Block();
        addObject(block365,715,175);
        Block block366 = new Block();
        addObject(block366,755,178);
        Block block367 = new Block();
        addObject(block367,601,308);
        Block block368 = new Block();
        addObject(block368,572,310);
        Block block369 = new Block();
        addObject(block369,90,52);
        Block block370 = new Block();
        addObject(block370,50,57);
        Block block371 = new Block();
        addObject(block371,43,84);
        Block block372 = new Block();
        addObject(block372,727,46);
        Block block373 = new Block();
        addObject(block373,754,53);
        Block block374 = new Block();
        addObject(block374,730,79);
        Block block375 = new Block();
        addObject(block375,760,90);
        Block block376 = new Block();
        addObject(block376,691,53);
        Block block377 = new Block();
        addObject(block377,394,273);
        Block block378 = new Block();
        addObject(block378,372,269);
        removeObject(block378);
        removeObject(block377);
        Block block379 = new Block();
        addObject(block379,330,269);
        Block block380 = new Block();
        addObject(block380,355,300);
        removeObject(block379);
        Block block381 = new Block();
        addObject(block381,340,303);
        Block block382 = new Block();
        addObject(block382,695,215);
        removeObject(block382);
        removeObject(block374);
        Block block383 = new Block();
        addObject(block383,532,159);
        Block block384 = new Block();
        addObject(block384,503,149);
        Block block385 = new Block();
        addObject(block385,473,145);
        Block block386 = new Block();
        addObject(block386,439,147);
        Block block387 = new Block();
        addObject(block387,463,113);
        Block block388 = new Block();
        addObject(block388,493,108);
        Block block389 = new Block();
        addObject(block389,396,137);
        Block block390 = new Block();
        addObject(block390,370,142);
        Block block391 = new Block();
        addObject(block391,392,116);
        removeObject(block391);
        removeObject(block387);
        removeObject(block384);
        removeObject(block388);
        Block block392 = new Block();
        addObject(block392,494,144);
        Slime slime3 = new Slime();
        addObject(slime3,100,157);
        Slime slime4 = new Slime();
        addObject(slime4,239,101);
        Slime slime5 = new Slime();
        addObject(slime5,334,79);
        Slime2 slime22 = new Slime2();
        addObject(slime22,493,74);
        Slime slime6 = new Slime();
        addObject(slime6,584,239);
        Slime slime7 = new Slime();
        addObject(slime7,216,266);
    }
}
