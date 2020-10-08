import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Enemy
{
    public enum State
    {
        IDLE,
        RUN,
        JUMP,
        FALL,
        LAND,
        HIT_F,
        HIT_U,
        HIT_D,
        CIRCLE,
        HEAL,
        GUN_F,
        GUN_U, 
        GUN_D,
        }

        public enum AIState
        {
            CHASE,
            DODGE,
            ATTACK,
            GUN,
            }

            public State state = State.IDLE;
            public AIState aiState = AIState.ATTACK;

            public long startFight;
            public long nextTeleport;
            public long nextAttack;

            public boolean flip;

            public Boss()
            {
                super();

                display = new MidgroundPlayer(this);
                display.add("idle", "Two", 256, 256, 2, 7);
                display.add("run", "Two", 256, 256, 8, 13);
                display.add("jump", "Two", 256, 256, 14, 15);
                display.add("fall", "Two", 256, 256, 16, 17);
                display.add("land", "Two", 256, 256, 18, 19);
                display.add("hit_f", "Two", 256, 256, 20, 27);
                display.add("hit_u", "Two", 256, 256, 28, 35);
                display.add("hit_d", "Two", 256, 256, 36, 43);
                display.add("circle", "Two", 256, 256, 44, 52);
                display.add("heal", "Two", 256, 256, 53, 56);
                display.add("gun_f", "Two", 256, 256, 59, 66);
                display.add("gun_u", "Two", 256, 256, 67, 74);
                display.add("gun_d", "Two", 256, 256, 75, 82);
                display.setOffset(0, 65);
                addPlayer(display);
                display.play("idle", true, 4);

                level = new SolidPlayer(this, "ENEMY", "LEVEL");
                level.add("default", "Collision", 40, 70, 0, 0);
                level.setOffset(0, 90);
                addPlayer(level);
                level.play("default", false, 0);

                box = new AreaPlayer(this, "ENEMY_BOX", "PLAYER_HIT");
                box.add("default", "Collision", 20, 60, 1, 1);
                box.setOffset(0, 90);
                addPlayer(box);
                box.play("default", false, 0);

                hit = new AreaPlayer(this, "ENEMY_HIT", "PLAYER_BOX");
                hit.add("hit_f", "Collision", 70, 30, 2, 2);
                hit.add("hit_u", "Collision", 30, 70, 2, 2);
                hit.add("hit_d", "Collision", 30, 70, 2, 2);
                hit.add("circle", "Collision", 140, 140, 2, 2);
                hit.setOffset(0, 0);
                addPlayer(hit);

                setHealth(Options.BOSS_MAX_HEALTH);
                setInvulTime(Options.PLAYER_INVUL_TIME);

                startFight = System.currentTimeMillis() + Options.BOSS_WAIT;
            }

            public void update()
            {
                super.update();
                addForce(0, Options.GRAVITY);   //applies gravity to velocity

                if (System.currentTimeMillis() > startFight)
                    updateAI();

                if (state != State.HIT_F && state != State.HIT_U && state != State.HIT_D && state != State.CIRCLE && state != State.HEAL)if (state != State.HIT_F && state != State.HIT_U && state != State.HIT_D && state != State.CIRCLE && state != State.HEAL && state != State.GUN_F && state != State.GUN_U && state != State.GUN_U&& state != State.GUN_D)
                    {
                        if (getVX() < 0)
                            flip = true;
                        else if (getVX() > 0)
                            flip = false;
                    }

                updateState();
                updateAnim();
                limit();
                applyVel();

                if (getInvul())
                {
                    if (Global.updateTime % Options.INVUL_BLINK_RATE == 0)
                    {
                        if (display.getStyle() != Style.WHITE)
                            display.setStyle(Style.WHITE);
                        else
                            display.setStyle(Style.DEFAULT);
                    }
                }
                else
                    display.setStyle(Style.DEFAULT);

                if (getHealth() < Options.BOSS_MAX_HEALTH * 0.33)
                {
                    if (Greenfoot.getRandomNumber(1) == 0)
                        ((GameWorld) Global.world).freeAddObject(new Swirl2(getVX() / 5, getVY() / 5), display.getX() + Greenfoot.getRandomNumber(11) - 5, display.getY() + 10 + Greenfoot.getRandomNumber(11) - 5);
                }
                else if (getHealth() < Options.BOSS_MAX_HEALTH * 0.66)
                {
                    if (Greenfoot.getRandomNumber(3) == 0)
                        ((GameWorld) Global.world).freeAddObject(new Swirl(getVX() / 5, getVY() / 5), display.getX() + Greenfoot.getRandomNumber(11) - 5, display.getY() + 10 + Greenfoot.getRandomNumber(11) - 5);
                }
            }

            public void refreshTeleport()
            {
                if (getHealth() < Options.BOSS_MAX_HEALTH * 0.33)
                    nextTeleport = System.currentTimeMillis() + Options.TELEPORT_COOLDOWN / 8;
                else if (getHealth() < Options.BOSS_MAX_HEALTH * 0.66)
                    nextTeleport = System.currentTimeMillis() + Options.TELEPORT_COOLDOWN / 4;                    
                else
                    nextTeleport = System.currentTimeMillis() + Options.TELEPORT_COOLDOWN;
            }

            public void refreshAttack()
            {
                if (getHealth() < Options.BOSS_MAX_HEALTH * 0.33)
                    nextAttack = System.currentTimeMillis() + Options.ATTACK_COOLDOWN / 8;
                else if (getHealth() < Options.BOSS_MAX_HEALTH * 0.66)
                    nextAttack = System.currentTimeMillis() + Options.ATTACK_COOLDOWN / 4;                    
                else
                    nextAttack = System.currentTimeMillis() + Options.ATTACK_COOLDOWN;
            }

            public void updateAI()
            {
                switch(aiState)
                {
                    case CHASE:
                    chase();
                    break;
                    case DODGE:
                    dodge();
                    break;
                    case ATTACK:
                    attack();
                    break;
                    case GUN:
                    gun();
                    break;
                }
            }

            public void trail()
            {
                GreenfootImage img = display.getImage();
                for (int x = 0; x < img.getWidth(); x++)
                    for (int y = 0; y < img.getHeight(); y++)
                        if (img.getColorAt(x, y).getAlpha() != 0 && Greenfoot.getRandomNumber(10) == 0)
                            ((GameWorld) Global.world).freeAddObject(new TeleportParticle(), getX() + x - img.getWidth() / 2, getY() + y - img.getHeight() / 2 + 55);
                Greenfoot.playSound("Randomize31.wav");
            }

            public void chase()
            {
                if (state != State.HIT_F && state != State.HIT_U && state != State.HIT_D && state != State.CIRCLE && state != State.HEAL && state != State.GUN_F && state != State.GUN_U && state != State.GUN_U&& state != State.GUN_D)
                {
                    if (!Global.world.getObjects(Player.class).isEmpty())
                    {
                        Player player = (Global.world.getObjects(Player.class)).get(0);        
                        double dist = Math.sqrt(Math.pow(player.getX() - getX(), 2) + Math.pow(player.getY() - getY(), 2));

                        if (dist > 70)
                        {
                            if (player.getX() < getX())
                            {
                                if (level.getClippingDown(1).isEmpty())
                                    addForce(-Options.AIR_ACCEL, 0);
                                else
                                    addForce(-Options.GROUND_ACCEL, 0);
                            }
                            else if (player.getX() > getX())
                            {
                                if (level.getClippingDown(1).isEmpty())
                                    addForce(Options.AIR_ACCEL, 0);
                                else
                                    addForce(Options.GROUND_ACCEL, 0);
                            }

                            if (player.getY() < getY())
                            {
                                if (!level.getClippingDown(1).isEmpty())
                                {
                                    setVY(-Options.JUMP_VEL * Greenfoot.getRandomNumber(8));
                                    state = State.JUMP;
                                }
                                addForce(0, -Options.AIR_HOVER);
                            }
                        }
                        else if (dist < 50)
                        {
                            if (player.getX() < getX())
                            {
                                if (level.getClippingDown(1).isEmpty())
                                    addForce(Options.AIR_ACCEL, 0);
                                else
                                    addForce(Options.GROUND_ACCEL, 0);
                            }
                            else if (player.getX() > getX())
                            {
                                if (level.getClippingDown(1).isEmpty())
                                    addForce(-Options.AIR_ACCEL, 0);
                                else
                                    addForce(-Options.GROUND_ACCEL, 0);
                            }
                        }

                        if (getX() > Options.WIDTH - 100)
                        {
                            if (System.currentTimeMillis() > nextTeleport)
                            {
                                trail();
                                tele(100, getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash(), display.getX(), display.getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash2(), getX(), getY());
                                refreshTeleport();
                            }
                            else if (!level.getClippingDown(1).isEmpty())
                            {
                                setV(-Options.JUMP_VEL, -Options.JUMP_VEL);
                                state = State.JUMP;
                            }
                        }
                        else if (getX() < 100)
                        {
                            if (System.currentTimeMillis() > nextTeleport)
                            {
                                trail();
                                tele(Options.WIDTH - 100, getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash(), display.getX(), display.getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash2(), getX(), getY());
                                refreshTeleport();
                            }
                            else if (!level.getClippingDown(1).isEmpty())
                            {
                                setV(Options.JUMP_VEL, -Options.JUMP_VEL);
                                state = State.JUMP;
                            }
                        }

                        if (Greenfoot.getRandomNumber(480) == 0 && !level.getClippingDown(1).isEmpty())
                            setVY(-Options.JUMP_VEL);

                        if (System.currentTimeMillis() > nextAttack)
                        {
                            if (Greenfoot.getRandomNumber(600) == 0)
                            {
                                trail();
                                tele(player.getX(), player.getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash(), display.getX(), display.getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash2(), getX(), getY());
                            }
                            else if (Greenfoot.getRandomNumber(600) == 0 && player.getX() < Options.WIDTH / 2)
                            {
                                trail();
                                tele(player.getX() + 70, player.getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash(), display.getX(), display.getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash2(), getX(), getY());
                            }
                            else if (Greenfoot.getRandomNumber(600) == 0 && player.getX() > Options.WIDTH / 2)
                            {
                                trail();
                                tele(player.getX() - 70, player.getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash(), display.getX(), display.getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash2(), getX(), getY());
                            }
                            else if (Greenfoot.getRandomNumber(600) == 0 && player.getY() > Options.HEIGHT / 2)
                            {
                                trail();
                                tele(player.getX(), player.getY() - 70);
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash(), display.getX(), display.getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash2(), getX(), getY());
                            }
                            else if (Greenfoot.getRandomNumber(600) == 0 && player.getY() < Options.HEIGHT / 2)
                            {
                                trail();
                                tele(player.getX(), player.getY() + 100);
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash(), display.getX(), display.getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash2(), getX(), getY());
                            }
                            else if (Greenfoot.getRandomNumber(600) == 0)
                            {
                                trail();
                                tele(player.getX(), Options.HEIGHT  - 150);
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash(), display.getX(), display.getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash2(), getX(), getY());
                            }   
                        }

                        if (System.currentTimeMillis() > nextAttack && dist <= 70)
                        {
                            if (dist <= 70)
                                aiState = AIState.ATTACK;
                        }
                        else if (getHealth() <= Options.BOSS_MAX_HEALTH * 0.66 && System.currentTimeMillis() > nextAttack && dist > 200 && Greenfoot.getRandomNumber(60) == 0)
                        {
                            aiState = AIState.GUN;
                        }
                        else if (Greenfoot.getRandomNumber(120) == 0)
                            aiState = AIState.DODGE;
                    }
                }
            }

            public void dodge()
            {
                if (state != State.HIT_F && state != State.HIT_U && state != State.HIT_D && state != State.CIRCLE && state != State.HEAL && state != State.GUN_F && state != State.GUN_U && state != State.GUN_U&& state != State.GUN_D)
                {
                    if (!Global.world.getObjects(Player.class).isEmpty())
                    {
                        Player player = (Global.world.getObjects(Player.class)).get(0);        
                        double dist = Math.sqrt(Math.pow(player.getX() - getX(), 2) + Math.pow(player.getY() - getY(), 2));

                        if (dist < 400)
                        {
                            if (player.getX() < getX())
                            {
                                if (level.getClippingDown(1).isEmpty())
                                    addForce(Options.AIR_ACCEL, 0);
                                else
                                    addForce(Options.GROUND_ACCEL, 0);
                            }
                            else if (player.getX() > getX())
                            {
                                if (level.getClippingDown(1).isEmpty())
                                    addForce(-Options.AIR_ACCEL, 0);
                                else
                                    addForce(-Options.GROUND_ACCEL, 0);
                            }
                        }

                        if (getX() > Options.WIDTH - 100)
                        {
                            if (System.currentTimeMillis() > nextTeleport)
                            {
                                trail();
                                tele(100, getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash(), display.getX(), display.getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash(), getX(), getY());
                                refreshTeleport();
                            }
                            else if (!level.getClippingDown(1).isEmpty())
                            {
                                setV(-Options.JUMP_VEL, -Options.JUMP_VEL);
                                state = State.JUMP;
                            }
                        }
                        else if (getX() < 100)
                        {
                            if (System.currentTimeMillis() > nextTeleport)
                            {
                                trail();
                                tele(Options.WIDTH - 100, getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash(), display.getX(), display.getY());
                                ((GameWorld) Global.world).freeAddObject(new TeleFlash(), getX(), getY());
                                refreshTeleport();
                            }
                            else if (!level.getClippingDown(1).isEmpty())
                            {
                                setV(Options.JUMP_VEL, -Options.JUMP_VEL);
                                state = State.JUMP;
                            }
                        }

                        if (Greenfoot.getRandomNumber(480) == 0 && !level.getClippingDown(1).isEmpty())
                            setVY(-Options.JUMP_VEL);

                        if (player.getY() > getY())
                        {
                            addForce(0, -Options.AIR_HOVER);
                        }

                        if (System.currentTimeMillis() > nextAttack && dist <= 150)
                        {
                            aiState = AIState.ATTACK;
                        }
                        else if (getHealth() <= Options.BOSS_MAX_HEALTH * 0.66 && System.currentTimeMillis() > nextAttack && dist > 200 && Greenfoot.getRandomNumber(1) == 0)
                        {
                            aiState = AIState.GUN;
                        }
                        else if (dist > 350 && getHealth() <= Options.BOSS_MAX_HEALTH * 0.7 && Greenfoot.getRandomNumber(300) == 0)
                        {
                            state = State.HEAL;
                        }
                        else if (Greenfoot.getRandomNumber(120) == 0)
                            aiState = AIState.CHASE;
                    }
                }
            }

            public void attack()
            {
                if (state != State.HIT_F && state != State.HIT_U && state != State.HIT_D && state != State.CIRCLE && state != State.HEAL && state != State.GUN_F && state != State.GUN_U && state != State.GUN_U&& state != State.GUN_D)
                {
                    if (level.getClippingDown(1).isEmpty())
                    {
                        if (state != State.HIT_F && state != State.HIT_U && state != State.HIT_D && state != State.CIRCLE && state != State.HEAL && state != State.GUN_F && state != State.GUN_U && state != State.GUN_U&& state != State.GUN_D)
                        {
                            hit.play("hit_d", false, 0);
                            hit.setOffset(-5, 170);
                            if (!hit.getClipping().isEmpty())
                            {
                                if (Greenfoot.getRandomNumber(Options.CIRCLE_CHANCE) == 0)
                                {
                                    refreshAttack();
                                    state = State.CIRCLE;
                                }
                                else
                                {
                                    refreshAttack();
                                    flip = true;
                                    state = State.HIT_D;
                                }
                            }
                        }

                        if (state != State.HIT_F && state != State.HIT_U && state != State.HIT_D && state != State.CIRCLE && state != State.HEAL && state != State.GUN_F && state != State.GUN_U && state != State.GUN_U&& state != State.GUN_D)
                        {
                            hit.setOffset(5, 170);
                            if (!hit.getClipping().isEmpty())
                            {
                                if (Greenfoot.getRandomNumber(Options.CIRCLE_CHANCE) == 0)
                                {
                                    refreshAttack();
                                    state = State.CIRCLE;
                                }
                                else
                                {
                                    refreshAttack();
                                    flip = false;
                                    state = State.HIT_D;
                                }
                            }
                        }
                    }
                }

                if (state != State.HIT_F && state != State.HIT_U && state != State.HIT_D && state != State.CIRCLE && state != State.HEAL && state != State.GUN_F && state != State.GUN_U && state != State.GUN_U&& state != State.GUN_D)
                {
                    hit.play("hit_f", false, 0);
                    hit.setOffset(-50, 90);
                    if (!hit.getClipping().isEmpty())
                    {
                        if (Greenfoot.getRandomNumber(Options.CIRCLE_CHANCE) == 0)
                        {
                            refreshAttack();
                            state = State.CIRCLE;
                        }
                        {
                            refreshAttack();
                            flip = true;
                            state = State.HIT_F;
                        }
                    }
                }
                if (state != State.HIT_F && state != State.HIT_U && state != State.HIT_D && state != State.CIRCLE && state != State.HEAL && state != State.GUN_F && state != State.GUN_U && state != State.GUN_U&& state != State.GUN_D)
                {
                    hit.setOffset(50, 90);
                    if (!hit.getClipping().isEmpty())
                    {
                        if (Greenfoot.getRandomNumber(Options.CIRCLE_CHANCE) == 0)
                        {
                            refreshAttack();
                            state = State.CIRCLE;
                        }
                        {
                            refreshAttack();
                            flip = false;
                            state = State.HIT_F;
                        }
                    }
                }

                if (state != State.HIT_F && state != State.HIT_U && state != State.HIT_D && state != State.CIRCLE && state != State.HEAL && state != State.GUN_F && state != State.GUN_U && state != State.GUN_U&& state != State.GUN_D)
                {
                    hit.play("hit_u", false, 0);
                    hit.setOffset(-5, 30);
                    if (!hit.getClipping().isEmpty())
                    {
                        if (Greenfoot.getRandomNumber(Options.CIRCLE_CHANCE) == 0)
                        {
                            refreshAttack();
                            state = State.CIRCLE;
                        }
                        else
                        {
                            refreshAttack();
                            flip = true;
                            state = State.HIT_U;
                        }
                    }
                }

                if (state != State.HIT_F && state != State.HIT_U && state != State.HIT_D && state != State.CIRCLE && state != State.HEAL && state != State.GUN_F && state != State.GUN_U && state != State.GUN_U&& state != State.GUN_D)
                {
                    hit.setOffset(5, 30);
                    if (!hit.getClipping().isEmpty())
                    {
                        if (Greenfoot.getRandomNumber(Options.CIRCLE_CHANCE) == 0)
                        {
                            refreshAttack();
                            state = State.CIRCLE;
                        }
                        else
                        {
                            refreshAttack();
                            flip = false;
                            state = State.HIT_U;
                        }
                    }
                }

                hit.stop();
                hit.setOffset(0, 0);

                int rn = Greenfoot.getRandomNumber(3);
                switch(rn)
                {
                    case 0:
                    aiState = AIState.CHASE;
                    break;
                    case 1:
                    aiState = AIState.DODGE;
                    break;
                    case 2:
                    aiState = AIState.ATTACK;
                    break;
                }
            }

            public void gun()
            {
                if (state != State.HIT_F && state != State.HIT_U && state != State.HIT_D && state != State.CIRCLE && state != State.HEAL && state != State.GUN_F && state != State.GUN_U && state != State.GUN_U&& state != State.GUN_D)
                {
                    if (!(Global.world).getObjects(Player.class).isEmpty())
                    {
                        Player player = (Global.world).getObjects(Player.class).get(0);
                        if (player.getX() < display.getX())
                        {
                            if (Math.abs(player.getY() - display.getY()) < 100)
                            {
                                refreshAttack();
                                flip = true;
                                state = State.GUN_F;
                            }
                            else if (player.getY() < display.getY())
                            {
                                refreshAttack();
                                flip = true;
                                state = State.GUN_U;
                            }
                            else
                            {
                                refreshAttack();
                                flip = true;
                                state = State.GUN_D;
                            }
                        }
                        else
                        {
                            if (Math.abs(player.getY() - display.getY()) < 100)
                            {
                                refreshAttack();
                                flip = false;
                                state = State.GUN_F;
                            }
                            else if (player.getY() < display.getY())
                            {
                                refreshAttack();
                                flip = false;
                                state = State.GUN_U;
                            }
                            else
                            {
                                refreshAttack();
                                flip = false;
                                state = State.GUN_D;
                            }
                        }
                    }
                }

                int rn = Greenfoot.getRandomNumber(3);
                switch(rn)
                {
                    case 0:
                    aiState = AIState.CHASE;
                    break;
                    case 1:
                    aiState = AIState.DODGE;
                    break;
                    case 2:
                    aiState = AIState.GUN;                    
                    break;
                }
            }

            public void updateState()
            {
                switch(state)
                {
                    case IDLE:
                    idle();
                    break;
                    case RUN:
                    run();
                    break;
                    case JUMP:
                    jump();
                    break;
                    case FALL:
                    fall();
                    break;
                    case LAND:
                    land();
                    break;
                    case HIT_F:
                    hit_f();
                    break;
                    case HIT_U:
                    hit_u();
                    break;
                    case HIT_D:
                    hit_d();
                    break;
                    case CIRCLE:
                    circle();
                    break;
                    case HEAL:
                    heal();
                    break;
                    case GUN_F:
                    gun_f();
                    break;
                    case GUN_U:
                    gun_u();
                    break;
                    case GUN_D:
                    gun_d();
                    break;
                }
            }

            public void idle()
            {
                if (level.getClippingDown(1).isEmpty())
                    state = State.FALL;
                else if (Math.abs(getVX()) > Options.IDLE_TO_RUN_SPEED)
                    state = State.RUN;
            }

            public void run()
            {
                if (level.getClippingDown(1).isEmpty())
                    state = State.FALL;
                else if (!level.getClippingLeft(1).isEmpty() || !level.getClippingRight(1).isEmpty())
                    state = State.IDLE;
                else if (Math.abs(getVX()) < Options.IDLE_TO_RUN_SPEED)
                    state = State.IDLE;
            }

            public void jump()
            {
                if (!level.getClippingDown(1).isEmpty())
                    state = State.LAND;
                else if (display.checkName("jump") && display.isEnd())
                    state = State.FALL;
            }

            public void fall()
            {
                if (!level.getClippingDown(1).isEmpty())
                    state = State.LAND;
            }

            public void land()
            {
                if (display.checkName("land") && display.isEnd())
                {
                    if (level.getClippingDown(1).isEmpty())
                        state = State.FALL;
                    else if (Math.abs(getVX()) > Options.IDLE_TO_RUN_SPEED)
                        state = State.RUN;
                    else
                        state = State.IDLE;
                }
            }

            public void hit_f()
            {
                if (!display.checkFrame(5, 1) && !display.checkFrame(6, 1))
                    setV(0, 0);

                if (!hit.getClipping().isEmpty())
                {
                    for (CollisionPlayer collision : hit.getClipping())
                    {
                        Player player = (Player) collision.getParent();
                        player.hurt(getX(), getY(), 2);
                        if (!player.getInvul())
                        {
                            for (int i = 0; i < 10; i++)
                                ((GameWorld) Global.world).freeAddObject(new HitParticle(), hit.getX(), hit.getY());
                            ((Room) Global.world).freeze(Options.FREEZE_FRAME);
                            if (flip)
                                player.setV(-15, -15);
                            else
                                player.setV(15, -15);
                        }
                    }
                }
                if (display.checkName("hit_f") && display.isEnd())
                    state = State.IDLE;
            }

            public void hit_u()
            {
                if (!display.checkFrame(5, 1) && !display.checkFrame(6, 1))
                    setV(0, 0);

                if (!hit.getClipping().isEmpty())
                {
                    for (CollisionPlayer collision : hit.getClipping())
                    {
                        Player player = (Player) collision.getParent();
                        player.hurt(getX(), getY(), 2);
                        if (!player.getInvul())
                        {
                            for (int i = 0; i < 10; i++)
                                ((GameWorld) Global.world).freeAddObject(new HitParticle(), hit.getX(), hit.getY());
                            ((Room) Global.world).freeze(Options.FREEZE_FRAME);
                            if (flip)
                                player.setV(-5, -25);
                            else
                                player.setV(5, -25);
                        }
                    }
                }
                if (display.checkName("hit_u") && display.isEnd())
                    state = State.IDLE;
            }

            public void hit_d()
            {
                if (!display.checkFrame(5, 1) && !display.checkFrame(6, 1))
                    setV(0, 0);

                if (!hit.getClipping().isEmpty())
                {
                    for (CollisionPlayer collision : hit.getClipping())
                    {
                        Player player = (Player) collision.getParent();
                        player.hurt(getX(), getY(), 2);
                        if (!player.getInvul())
                        {
                            for (int i = 0; i < 10; i++)
                                ((GameWorld) Global.world).freeAddObject(new HitParticle(), hit.getX(), hit.getY());
                            ((Room) Global.world).freeze(Options.FREEZE_FRAME);
                            if (flip)
                                player.setV(-15, 15);
                            else
                                player.setV(15, 15);
                        }
                    }
                }
                if (display.checkName("hit_d") && display.isEnd())
                    state = State.FALL;
            }

            public void circle()
            {
                setV(0, 0);
                if (!hit.getClipping().isEmpty())
                {
                    for (CollisionPlayer collision : hit.getClipping())
                    {
                        Player player = (Player) collision.getParent();
                        player.hurt(getX(), getY(), 3);
                        if (!player.getInvul())
                        {
                            for (int i = 0; i < 10; i++)
                                ((GameWorld) Global.world).freeAddObject(new HitParticle(), hit.getX(), hit.getY());
                            ((Room) Global.world).freeze(Options.FREEZE_FRAME);

                            if (player.getX() < getX())
                                player.setVX(-15);
                            else
                                player.setVX(15);

                            if (player.getY() < getY())
                                player.setVY(-15);
                            else
                                player.setVY(15);
                        }
                    }
                }
                if (display.checkName("circle") && display.isEnd())
                    state = State.FALL;
            }

            public void heal()
            {
                if (display.checkName("heal") && display.isEnd())
                {
                    hurt(getX(), getY(), -3);
                    Greenfoot.playSound("Powerup33.wav");
                    state = State.FALL;
                }
            }

            public void gun_f()
            {
                setV(0, 0);
                if (display.checkFrame(5, 1))
                {
                    Greenfoot.playSound("Laser_Shoot56.wav");
                    if (flip)
                        ((GameWorld) Global.world).freeAddObject(new Bullet(-Options.BULLET_VEL, 0), display.getX(), display.getY() + 10);
                    else
                        ((GameWorld) Global.world).freeAddObject(new Bullet(Options.BULLET_VEL, 0), display.getX(), display.getY() + 10);
                }
                else if (display.checkName("gun_f") && display.isEnd())
                    state = State.FALL;
            }

            public void gun_u()
            {
                setV(0, 0);
                if (display.checkFrame(5, 1))
                {
                    Greenfoot.playSound("Laser_Shoot56.wav");
                    if (flip)
                        ((GameWorld) Global.world).freeAddObject(new Bullet(-Options.BULLET_VEL, -Options.BULLET_VEL), display.getX(), display.getY());
                    else
                        ((GameWorld) Global.world).freeAddObject(new Bullet(Options.BULLET_VEL, -Options.BULLET_VEL), display.getX(), display.getY());
                }
                if (display.checkName("gun_u") && display.isEnd())
                    state = State.FALL;
            }

            public void gun_d()
            {
                setV(0, 0);
                if (display.checkFrame(5, 1))
                {
                    Greenfoot.playSound("Laser_Shoot56.wav");
                    if (flip)
                        ((GameWorld) Global.world).freeAddObject(new Bullet(-Options.BULLET_VEL, Options.BULLET_VEL), display.getX(), display.getY() + 20);
                    else
                        ((GameWorld) Global.world).freeAddObject(new Bullet(Options.BULLET_VEL, Options.BULLET_VEL), display.getX(), display.getY() + 20);
                }
                if (display.checkName("gun_d") && display.isEnd())
                    state = State.FALL;
            }

            public void updateAnim()
            {
                display.setFlip(flip, false);

                hit.stop();

                switch (state)
                {
                    case IDLE:
                    display.play("idle", true, 1);
                    break;
                    case RUN:
                    display.play("run", true, 8);
                    break;
                    case JUMP:
                    display.play("jump", false, 5);
                    break;
                    case FALL:
                    display.play("fall", true, 5);
                    break;
                    case LAND:
                    display.play("land", false, 15);
                    break;
                    case HIT_F:
                    display.play("hit_f", false, 15);
                    if (flip)
                        hit.setOffset(-50, 90);
                    else
                        hit.setOffset(50, 90);
                    if (display.checkFrame(5, 1) || display.checkFrame(6, 1))
                    {
                        if (flip)
                            setV(-Options.ATTACK_SHIFT, 0);
                        else
                            setV(Options.ATTACK_SHIFT, 0);

                        if (display.checkFrame(5, 1))
                            Greenfoot.playSound("Hit_Hurt80.wav");
                        hit.play("hit_f", false, 0);
                    }
                    break;
                    case HIT_U:
                    display.play("hit_u", false, 15);
                    if (flip)
                        hit.setOffset(-5, 30);
                    else
                        hit.setOffset(5, 30);
                    if (display.checkFrame(5, 1) || display.checkFrame(6, 1))
                    {
                        setV(0, -Options.ATTACK_SHIFT);

                        if (display.checkFrame(5, 1))
                            Greenfoot.playSound("Hit_Hurt80.wav");
                        hit.play("hit_u", false, 0);
                    }
                    break;
                    case HIT_D:
                    display.play("hit_d", false, 15);
                    if (flip)
                        hit.setOffset(-5, 170);
                    else
                        hit.setOffset(5, 170);
                    if (display.checkFrame(5, 1) || display.checkFrame(6, 1))
                    {
                        setV(0, Options.ATTACK_SHIFT / 3);

                        if (display.checkFrame(5, 1))
                            Greenfoot.playSound("Hit_Hurt80.wav");
                        hit.play("hit_d", false, 0);
                    }
                    break;
                    case CIRCLE:
                    display.play("circle", false, 7);
                    hit.setOffset(0, 70);
                    if (display.checkFrame(4, 1) || display.checkFrame(5, 1))
                    {
                        if (display.checkFrame(4, 1))
                            Greenfoot.playSound("Hit_Hurt80.wav");
                        hit.play("circle", false, 0);
                    }
                    break;
                    case HEAL:
                    if (getHealth() < Options.BOSS_MAX_HEALTH * 0.33)
                        display.play("heal", false, 4);
                    else
                        display.play("heal", false, 3);
                    break;
                    case GUN_F:
                    if (getHealth() < Options.BOSS_MAX_HEALTH * 0.33)
                        display.play("gun_f", false, 20);
                    else
                        display.play("gun_f", false, 15);
                    break;
                    case GUN_U:
                    if (getHealth() < Options.BOSS_MAX_HEALTH * 0.33)
                        display.play("gun_u", false, 20);
                    else
                        display.play("gun_u", false, 15);
                    break;
                    case GUN_D:
                    if (getHealth() < Options.BOSS_MAX_HEALTH * 0.33)
                        display.play("gun_d", false, 20);
                    else
                        display.play("gun_d", false, 15);
                    break;
                }
            }

            public void limit()
            {
                if (level.getClippingDown(1).isEmpty())
                {
                    if (Math.abs(getVX()) > Options.AIR_FRICTION)
                        addForce(-Math.signum(getVX()) * Options.AIR_FRICTION, 0);
                    else
                        setVX(0);  
                }
                else
                {
                    if (Math.abs(getVX()) > Options.GROUND_FRICTION)
                        addForce(-Math.signum(getVX()) * Options.GROUND_FRICTION, 0);
                    else
                        setVX(0);
                }

                setVX((Math.abs(getVX()) > Options.MAX_VEL_X) ? Math.signum(getVX()) * Options.MAX_VEL_X : getVX());
                setVY((Math.abs(getVY()) > Options.MAX_VEL_Y) ? Math.signum(getVY()) * Options.MAX_VEL_Y : getVY());
            }

            public void stun()
            {
                if (state != State.HIT_F && state != State.HIT_U && state != State.HIT_D && state != State.CIRCLE)
                    state = state.FALL;
            }

            public void die(int xPos, int yPos)
            {
                BossDeathParticle deathParticle = new BossDeathParticle();
                if (xPos > getX())
                    deathParticle.setVX(-10);
                else
                    deathParticle.setVX(10);
                deathParticle.setVY(-15);
                ((GameWorld) Global.world).freeAddObject(deathParticle, getX(), getY());
                ((GameWorld) Global.world).freeAddObject(new Explosion2(), display.getX(), display.getY());
                super.die(xPos, yPos);
                Global.score += 10000;
            }
        }
