import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R1_9 extends Level1
{
    public R1_9()
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
            if (player.getX() > Options.WIDTH - 2)
            {
                R1_10 room = new R1_10();
                switchRoom(room, player, 2, player.getY());
            }
        }
    }

    public void prepare()
    {   
        Block block154 = new Block();
        addObject(block154,11,462);
        Block block155 = new Block();
        addObject(block155,15,437);
        Block block156 = new Block();
        addObject(block156,16,387);
        Block block157 = new Block();
        addObject(block157,18,366);
        Block block158 = new Block();
        addObject(block158,24,334);
        Block block159 = new Block();
        addObject(block159,25,302);
        Block block160 = new Block();
        addObject(block160,25,270);
        Block block161 = new Block();
        addObject(block161,23,247);
        Block block162 = new Block();
        addObject(block162,20,216);
        Block block163 = new Block();
        addObject(block163,21,185);
        Block block164 = new Block();
        addObject(block164,16,138);
        Block block165 = new Block();
        addObject(block165,16,114);
        Block block166 = new Block();
        addObject(block166,15,71);
        Block block167 = new Block();
        addObject(block167,13,47);
        Block block168 = new Block();
        addObject(block168,16,15);
        Block block169 = new Block();
        addObject(block169,46,17);
        Block block170 = new Block();
        addObject(block170,74,23);
        Block block171 = new Block();
        addObject(block171,115,26);
        Block block172 = new Block();
        addObject(block172,160,19);
        Block block173 = new Block();
        addObject(block173,148,17);
        Block block174 = new Block();
        addObject(block174,199,18);
        Block block175 = new Block();
        addObject(block175,257,16);
        Block block176 = new Block();
        addObject(block176,241,23);
        Block block177 = new Block();
        addObject(block177,300,29);
        Block block178 = new Block();
        addObject(block178,334,14);
        Block block179 = new Block();
        addObject(block179,381,18);
        Block block180 = new Block();
        addObject(block180,418,20);
        Block block181 = new Block();
        addObject(block181,407,24);
        Block block182 = new Block();
        addObject(block182,469,11);
        Block block183 = new Block();
        addObject(block183,504,20);
        Block block184 = new Block();
        addObject(block184,529,20);
        Block block185 = new Block();
        addObject(block185,560,19);
        Block block186 = new Block();
        addObject(block186,594,23);
        Block block187 = new Block();
        addObject(block187,633,21);
        Block block188 = new Block();
        addObject(block188,651,16);
        Block block189 = new Block();
        addObject(block189,698,17);
        Block block190 = new Block();
        addObject(block190,714,16);
        Block block191 = new Block();
        addObject(block191,749,21);
        Block block192 = new Block();
        addObject(block192,785,16);
        Block block193 = new Block();
        addObject(block193,46,597);
        Block block194 = new Block();
        addObject(block194,85,592);
        Block block195 = new Block();
        addObject(block195,108,589);
        Block block196 = new Block();
        addObject(block196,154,586);
        Block block197 = new Block();
        addObject(block197,195,592);
        Block block198 = new Block();
        addObject(block198,175,592);
        Block block199 = new Block();
        addObject(block199,240,589);
        Block block200 = new Block();
        addObject(block200,287,597);
        Block block201 = new Block();
        addObject(block201,314,597);
        Block block202 = new Block();
        addObject(block202,350,580);
        Block block203 = new Block();
        addObject(block203,371,594);
        Block block204 = new Block();
        addObject(block204,403,598);
        Block block205 = new Block();
        addObject(block205,446,583);
        Block block206 = new Block();
        addObject(block206,470,586);
        Block block207 = new Block();
        addObject(block207,510,593);
        Block block208 = new Block();
        addObject(block208,531,590);
        Block block209 = new Block();
        addObject(block209,560,594);
        Block block210 = new Block();
        addObject(block210,589,582);
        Block block211 = new Block();
        addObject(block211,633,587);
        Block block212 = new Block();
        addObject(block212,666,587);
        Block block213 = new Block();
        addObject(block213,707,594);
        Block block214 = new Block();
        addObject(block214,689,595);
        Block block215 = new Block();
        addObject(block215,751,586);
        Block block216 = new Block();
        addObject(block216,783,584);
        Block block217 = new Block();
        addObject(block217,152,562);
        Block block218 = new Block();
        addObject(block218,149,535);
        Block block219 = new Block();
        addObject(block219,146,494);
        Block block220 = new Block();
        addObject(block220,152,463);
        Block block221 = new Block();
        addObject(block221,144,435);
        Block block222 = new Block();
        addObject(block222,149,404);
        Block block223 = new Block();
        addObject(block223,154,361);
        Block block224 = new Block();
        addObject(block224,147,330);
        Block block225 = new Block();
        addObject(block225,152,297);
        Block block226 = new Block();
        addObject(block226,150,279);
        Block block227 = new Block();
        addObject(block227,151,242);
        Block block228 = new Block();
        addObject(block228,145,208);
        Block block229 = new Block();
        addObject(block229,144,165);
        Block block230 = new Block();
        addObject(block230,140,146);
        Block block231 = new Block();
        addObject(block231,179,152);
        Block block232 = new Block();
        addObject(block232,180,174);
        Block block233 = new Block();
        addObject(block233,184,212);
        Block block234 = new Block();
        addObject(block234,178,245);
        Block block235 = new Block();
        addObject(block235,178,268);
        Block block236 = new Block();
        addObject(block236,181,295);
        Block block237 = new Block();
        addObject(block237,181,324);
        Block block238 = new Block();
        addObject(block238,183,351);
        Block block239 = new Block();
        addObject(block239,181,377);
        Block block240 = new Block();
        addObject(block240,184,398);
        Block block241 = new Block();
        addObject(block241,177,430);
        Block block242 = new Block();
        addObject(block242,187,458);
        Block block243 = new Block();
        addObject(block243,175,503);
        Block block244 = new Block();
        addObject(block244,172,536);
        Block block245 = new Block();
        addObject(block245,173,550);
        Block block246 = new Block();
        addObject(block246,786,63);
        Block block247 = new Block();
        addObject(block247,787,86);
        Block block248 = new Block();
        addObject(block248,787,113);
        Block block249 = new Block();
        addObject(block249,799,175);
        Block block250 = new Block();
        addObject(block250,781,137);
        Block block251 = new Block();
        addObject(block251,784,223);
        Block block252 = new Block();
        addObject(block252,781,274);
        Block block253 = new Block();
        addObject(block253,779,243);
        Block block254 = new Block();
        addObject(block254,783,320);
        Block block255 = new Block();
        addObject(block255,787,344);
        Block block256 = new Block();
        addObject(block256,790,308);
        Block block257 = new Block();
        addObject(block257,786,358);
        Block block258 = new Block();
        addObject(block258,791,411);
        Block block259 = new Block();
        addObject(block259,791,428);
        Block block260 = new Block();
        addObject(block260,756,153);
        Block block261 = new Block();
        addObject(block261,704,149);
        Block block262 = new Block();
        addObject(block262,680,146);
        Block block263 = new Block();
        addObject(block263,646,146);
        Block block264 = new Block();
        addObject(block264,620,146);
        Block block265 = new Block();
        addObject(block265,437,216);
        Block block266 = new Block();
        addObject(block266,464,214);
        Block block267 = new Block();
        addObject(block267,405,53);
        Block block268 = new Block();
        addObject(block268,394,93);
        Block block269 = new Block();
        addObject(block269,391,123);
        Block block270 = new Block();
        addObject(block270,401,144);
        Block block271 = new Block();
        addObject(block271,399,177);
        Block block272 = new Block();
        addObject(block272,401,206);
        Block block273 = new Block();
        addObject(block273,395,247);
        Block block274 = new Block();
        addObject(block274,416,285);
        Block block275 = new Block();
        addObject(block275,404,284);
        Block block276 = new Block();
        addObject(block276,401,313);
        removeObject(block274);
        Block block277 = new Block();
        addObject(block277,411,335);
        Block block278 = new Block();
        addObject(block278,406,381);
        Block block279 = new Block();
        addObject(block279,400,426);
        Block block280 = new Block();
        addObject(block280,408,397);
        Block block281 = new Block();
        addObject(block281,404,473);
        Block block282 = new Block();
        addObject(block282,406,511);
        Block block283 = new Block();
        addObject(block283,406,537);
        Block block284 = new Block();
        addObject(block284,410,562);
        removeObject(block284);
        removeObject(block283);
        removeObject(block282);
        Block block285 = new Block();
        addObject(block285,593,330);
        Block block286 = new Block();
        addObject(block286,620,344);
        Block block287 = new Block();
        addObject(block287,693,274);
        Block block288 = new Block();
        addObject(block288,719,278);
        Block block289 = new Block();
        addObject(block289,760,268);
        Block block290 = new Block();
        addObject(block290,562,338);
        Block block291 = new Block();
        addObject(block291,534,343);
        Block block140 = new Block();
        addObject(block140,438,463);
        Block block141 = new Block();
        addObject(block141,474,470);
        Block block142 = new Block();
        addObject(block142,499,472);
        Block block143 = new Block();
        addObject(block143,543,473);
        Block block144 = new Block();
        addObject(block144,577,473);
        Block block145 = new Block();
        addObject(block145,579,481);
        removeObject(block145);
        Block block146 = new Block();
        addObject(block146,565,470);
        Block block147 = new Block();
        addObject(block147,634,468);
        Block block148 = new Block();
        addObject(block148,311,243);
        Block block149 = new Block();
        addObject(block149,337,247);
        Block block150 = new Block();
        addObject(block150,369,248);
        Block block151 = new Block();
        addObject(block151,305,408);
        Block block152 = new Block();
        addObject(block152,329,402);
        Block block153 = new Block();
        addObject(block153,369,403);
        Block block1160 = new Block();
        addObject(block1160,16,588);
        Slime slime = new Slime();
        addObject(slime,338,176);
        Slime slime2 = new Slime();
        addObject(slime2,336,335);
        Slime slime3 = new Slime();
        addObject(slime3,465,144);
        Slime slime4 = new Slime();
        addObject(slime4,719,76);
        Slime slime5 = new Slime();
        addObject(slime5,623,76);
        Slime slime6 = new Slime();
        addObject(slime6,720,203);
        Slime slime7 = new Slime();
        addObject(slime7,533,269);
        Slime slime8 = new Slime();
        addObject(slime8,596,268);
        Slime slime9 = new Slime();
        addObject(slime9,172,83);
    }
}