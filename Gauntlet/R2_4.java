import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R2_4 extends Level2
{
    public R2_4()
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
                R2_5 room = new R2_5();
                switchRoom(room, player, player.getTrueX(), Options.HEIGHT - 2 - 65);
            }
        }
    }

    public void prepare()
    {
        Block block143 = new Block();
        addObject(block143,775,590);
        Block block144 = new Block();
        addObject(block144,766,589);
        Block block145 = new Block();
        addObject(block145,728,584);
        Block block146 = new Block();
        addObject(block146,688,587);
        Block block147 = new Block();
        addObject(block147,652,584);
        Block block148 = new Block();
        addObject(block148,493,586);
        Block block149 = new Block();
        addObject(block149,464,588);
        Block block150 = new Block();
        addObject(block150,418,587);
        Block block151 = new Block();
        addObject(block151,393,586);
        Block block152 = new Block();
        addObject(block152,350,589);
        Block block153 = new Block();
        addObject(block153,361,592);
        Block block154 = new Block();
        addObject(block154,302,590);
        Block block155 = new Block();
        addObject(block155,256,592);
        Block block156 = new Block();
        addObject(block156,194,597);
        Block block157 = new Block();
        addObject(block157,229,593);
        Block block158 = new Block();
        addObject(block158,173,589);
        Block block159 = new Block();
        addObject(block159,123,589);
        Block block160 = new Block();
        addObject(block160,139,590);
        Block block161 = new Block();
        addObject(block161,60,592);
        Block block162 = new Block();
        addObject(block162,70,593);
        Block block163 = new Block();
        addObject(block163,28,590);
        Block block164 = new Block();
        addObject(block164,19,563);
        Block block165 = new Block();
        addObject(block165,13,510);
        Block block166 = new Block();
        addObject(block166,12,529);
        Block block167 = new Block();
        addObject(block167,16,470);
        Block block168 = new Block();
        addObject(block168,30,417);
        Block block169 = new Block();
        addObject(block169,24,384);
        Block block170 = new Block();
        addObject(block170,18,354);
        Block block171 = new Block();
        addObject(block171,17,327);
        Block block172 = new Block();
        addObject(block172,20,294);
        Block block173 = new Block();
        addObject(block173,19,259);
        Block block174 = new Block();
        addObject(block174,20,234);
        Block block175 = new Block();
        addObject(block175,24,206);
        Block block176 = new Block();
        addObject(block176,28,176);
        Block block177 = new Block();
        addObject(block177,17,139);
        Block block178 = new Block();
        addObject(block178,16,94);
        Block block179 = new Block();
        addObject(block179,11,73);
        Block block180 = new Block();
        addObject(block180,6,111);
        Block block181 = new Block();
        addObject(block181,14,59);
        Block block182 = new Block();
        addObject(block182,14,19);
        Block block183 = new Block();
        addObject(block183,89,5);
        Block block184 = new Block();
        addObject(block184,46,25);
        Block block185 = new Block();
        addObject(block185,115,17);
        Block block186 = new Block();
        addObject(block186,141,13);
        Block block187 = new Block();
        addObject(block187,176,8);
        Block block188 = new Block();
        addObject(block188,210,16);
        Block block189 = new Block();
        addObject(block189,244,14);
        Block block190 = new Block();
        addObject(block190,279,12);
        Block block191 = new Block();
        addObject(block191,311,14);
        Block block192 = new Block();
        addObject(block192,335,15);
        Block block193 = new Block();
        addObject(block193,370,13);
        Block block194 = new Block();
        addObject(block194,400,10);
        Block block195 = new Block();
        addObject(block195,437,19);
        Block block196 = new Block();
        addObject(block196,485,20);
        Block block197 = new Block();
        addObject(block197,478,20);
        Block block198 = new Block();
        addObject(block198,549,5);
        Block block199 = new Block();
        addObject(block199,536,16);
        Block block200 = new Block();
        addObject(block200,577,11);
        Block block201 = new Block();
        addObject(block201,729,432);
        Block block202 = new Block();
        addObject(block202,756,430);
        Block block203 = new Block();
        addObject(block203,782,423);
        Block block204 = new Block();
        addObject(block204,721,230);
        Block block205 = new Block();
        addObject(block205,745,236);
        Block block206 = new Block();
        addObject(block206,777,240);
        Block block207 = new Block();
        addObject(block207,56,339);
        Block block208 = new Block();
        addObject(block208,85,334);
        Block block209 = new Block();
        addObject(block209,116,331);
        Block block210 = new Block();
        addObject(block210,142,334);
        Block block211 = new Block();
        addObject(block211,175,331);
        Block block212 = new Block();
        addObject(block212,206,328);
        Block block213 = new Block();
        addObject(block213,235,332);
        Block block214 = new Block();
        addObject(block214,281,332);
        Block block215 = new Block();
        addObject(block215,311,330);
        Block block216 = new Block();
        addObject(block216,347,333);
        Block block217 = new Block();
        addObject(block217,382,333);
        Block block218 = new Block();
        addObject(block218,422,334);
        Block block219 = new Block();
        addObject(block219,408,345);
        Block block220 = new Block();
        addObject(block220,462,338);
        Block block221 = new Block();
        addObject(block221,507,333);
        Block block222 = new Block();
        addObject(block222,544,332);
        Block block223 = new Block();
        addObject(block223,567,335);
        Block block224 = new Block();
        addObject(block224,531,330);
        Block block225 = new Block();
        addObject(block225,580,342);
        Block block226 = new Block();
        addObject(block226,55,150);
        Block block227 = new Block();
        addObject(block227,79,152);
        Block block228 = new Block();
        addObject(block228,105,148);
        Block block229 = new Block();
        addObject(block229,152,172);
        removeObject(block229);
        Block block230 = new Block();
        addObject(block230,148,146);
        Block block231 = new Block();
        addObject(block231,182,146);
        Block block232 = new Block();
        addObject(block232,229,146);
        Block block233 = new Block();
        addObject(block233,210,136);
        Block block234 = new Block();
        addObject(block234,262,141);
        Block block235 = new Block();
        addObject(block235,310,145);
        Block block236 = new Block();
        addObject(block236,345,149);
        Block block237 = new Block();
        addObject(block237,367,149);
        Block block238 = new Block();
        addObject(block238,419,147);
        Block block239 = new Block();
        addObject(block239,478,154);
        Block block240 = new Block();
        addObject(block240,494,146);
        Block block241 = new Block();
        addObject(block241,544,138);
        Block block242 = new Block();
        addObject(block242,598,136);
        Block block243 = new Block();
        addObject(block243,528,145);
        Block block244 = new Block();
        addObject(block244,398,132);
        Block block245 = new Block();
        addObject(block245,48,497);
        Block block246 = new Block();
        addObject(block246,81,507);
        Block block247 = new Block();
        addObject(block247,45,249);
        Block block248 = new Block();
        addObject(block248,78,238);
        Block block249 = new Block();
        addObject(block249,789,19);
        Block block250 = new Block();
        addObject(block250,781,40);
        Block block251 = new Block();
        addObject(block251,789,78);
        Block block252 = new Block();
        addObject(block252,783,134);
        Block block253 = new Block();
        addObject(block253,792,176);
        Block block254 = new Block();
        addObject(block254,783,199);
        Block block255 = new Block();
        addObject(block255,784,115);
        Block block = new Block();
        addObject(block,781,564);
        Block block2 = new Block();
        addObject(block2,780,530);
        Block block3 = new Block();
        addObject(block3,783,499);
        Block block4 = new Block();
        addObject(block4,784,462);
        Block block5 = new Block();
        addObject(block5,785,394);
        Block block6 = new Block();
        addObject(block6,786,368);
        Block block7 = new Block();
        addObject(block7,785,339);
        Block block8 = new Block();
        addObject(block8,785,297);
        Block block9 = new Block();
        addObject(block9,785,261);
        Cardinal2 cardinal2 = new Cardinal2();
        addObject(cardinal2,85,79);
        Slime2 slime23 = new Slime2();
        addObject(slime23,77,429);
        Slime2 slime22 = new Slime2();
        addObject(slime22,146,236);
    }
}
