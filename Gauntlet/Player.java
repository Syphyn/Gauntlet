import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.reflect.*;

/**
 * The player controlled character.
 * 
 * @author Duy Pham
 * @version 1-8-2017
 */
public class Player extends DamageActor
{
    public enum State
    {
        IDLE,
        RUN,
        GRAB,
        STICK,
        CLIMB,
        JUMP,
        FALL,
        LAND,
        HIT_F,
        HIT_U,
        HIT_D,
        }

        public static State[] CLIMB = {State.GRAB, State.STICK, State.CLIMB};
        public static State[] HIT = {State.HIT_F, State.HIT_U};
        public static State[] AIR = {State.JUMP, State.FALL};

        private State state = State.IDLE;
        private State request = State.IDLE;

        public MidgroundPlayer display;
        public SolidPlayer level;
        public AreaPlayer jump;

        public AreaPlayer box;
        public AreaPlayer hit;

        public boolean flip;
        public boolean airJumpAvail;

        public long endWallJump;

        /**
         * Player contructor
         */
        public Player()
        {
            super();

            display = new MidgroundPlayer(this);
            display.add("idle", "One", 256, 256, 2, 7);
            display.add("run", "One", 256, 256, 8, 13);
            display.add("grab", "One", 256, 256, 14, 16);
            display.add("climb", "One", 256, 256, 17, 20);
            display.add("jump", "One", 256, 256, 21, 22);
            display.add("fall", "One", 256, 256, 23, 24);
            display.add("land", "One", 256, 256, 25, 26);
            display.add("hit_f", "One", 256, 256, 27, 31);
            display.add("hit_u", "One", 256, 256, 32, 36);
            display.add("hit_d", "One", 256, 256, 37, 41);
            display.setOffset(0, 65);
            addPlayer(display);
            display.play("idle", true, 4);

            level = new SolidPlayer(this, "PLAYER", "LEVEL");
            level.add("default", "Collision", 40, 70, 0, 0);
            level.setOffset(0, 90);
            addPlayer(level);
            level.play("default", false, 0);

            jump = new AreaPlayer(this, "JUMP", "LEVEL");
            jump.add("default", "Collision", 40, 70, 0, 0);
            jump.setOffset(0, 120);
            addPlayer(jump);
            jump.play("default", false, 0);

            box = new AreaPlayer(this, "PLAYER_BOX", "ENEMY_HIT");
            box.add("default", "Collision", 20, 60, 1, 1);
            box.setOffset(0, 90);
            addPlayer(box);
            box.play("default", false, 0);

            hit = new AreaPlayer(this, "PLAYER_HIT", "ENEMY_BOX");
            hit.add("hit_f", "Collision", 100, 80, 2, 2);
            hit.add("hit_u", "Collision", 80, 100, 2, 2);
            hit.add("hit_d", "Collision", 80, 100, 2, 2);
            hit.setOffset(0, 0);
            addPlayer(hit);

            setHealth(Options.PLAYER_MAX_HEALTH);
            setInvulTime(Options.PLAYER_INVUL_TIME);
        }

        public Player copy()
        {
            Player clone = new Player();
            clone.setHealth(getHealth());
            clone.setV(getVX(), getVY());
            clone.setState(getState());
            clone.flip = flip;
            return clone;
        }

        /**
         * updates at fps of Options.FRAMERATE
         */
        public void update() 
        {
            super.update();
            addForce(0, Options.GRAVITY);   //applies gravity to velocity
            updateState();
            updateAnim();
            limit();
            applyVel();
        }

        public void updateState()
        {
            switch (state)
            {
                case IDLE:
                idle();
                break;
                case RUN:
                run();
                break;
                case GRAB:
                grab();
                break;
                case STICK:
                stick();
                break;
                case CLIMB:
                climb();
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
            }
        }

        public void groundMove()
        {
            if (InputHandler.isKeyDown("a") && InputHandler.isKeyUp("d"))
                addForce(-Options.GROUND_ACCEL, 0);
            if (InputHandler.isKeyDown("d") && InputHandler.isKeyUp("a"))
                addForce(Options.GROUND_ACCEL, 0);
        }

        public void airMove()
        {
            if (InputHandler.isKeyDown("a") && InputHandler.isKeyUp("d"))
                addForce(-Options.AIR_ACCEL, 0);
            if (InputHandler.isKeyDown("d") && InputHandler.isKeyUp("a"))
                addForce(Options.AIR_ACCEL, 0);
        }

        public void velFlip()
        {
            if (getVX() < 0)
                flip = true;
            else if (getVX() > 0)
                flip = false;
        }

        public void groundJump()
        {
            if (InputHandler.isKeyJustPressed("space"))
            {
                setVY(-Options.JUMP_VEL);
                if (InputHandler.isKeyDown("a") && InputHandler.isKeyUp("d"))
                    setVX(-Options.JUMP_VEL);
                if (InputHandler.isKeyDown("d") && InputHandler.isKeyUp("a"))
                    setVX(Options.JUMP_VEL);
            }
        }

        public void airJump()
        {
            if (InputHandler.isKeyJustPressed("space"))
            {
                if (System.currentTimeMillis() <= endWallJump)
                {
                    if (!level.getClippingLeft(Options.WALL_JUMP_CHECK_SHIFT).isEmpty())
                        setV(Options.JUMP_VEL * 2, -Options.JUMP_VEL);
                    else if (!level.getClippingRight(Options.WALL_JUMP_CHECK_SHIFT).isEmpty())
                        setV(-Options.JUMP_VEL * 2, -Options.JUMP_VEL);                
                }
                else if (airJumpAvail)
                {
                    setVY(-Options.JUMP_VEL);
                    airJumpAvail = false;
                }
            }
        }

        public void airHover()
        {
            if (InputHandler.isKeyPressed("space"))
                addForce(0, -Options.AIR_HOVER);
        }

        public void wallGrab()
        {
            if (InputHandler.isKeyDown("a") && InputHandler.isKeyUp("d") && InputHandler.isKeyDown("w") && !level.getClippingLeft(1).isEmpty())
                setState(State.GRAB);
            if (InputHandler.isKeyDown("d") && InputHandler.isKeyUp("a")&& InputHandler.isKeyDown("w") && !level.getClippingRight(1).isEmpty())
                setState(State.GRAB);
        }

        public void grabStop()
        {
            if (!level.getClippingUp((int) Options.CLIMB_VEL).isEmpty())
                setState(State.FALL);
        }

        public void climbStart()
        {
            if (flip && InputHandler.isKeyDown("a") && InputHandler.isKeyUp("d") && InputHandler.isKeyDown("w"))
            {
                setState(State.CLIMB);
                display.setPaused(false);
            }
            if (!flip && InputHandler.isKeyDown("d") && InputHandler.isKeyUp("a") && InputHandler.isKeyDown("w"))
            {
                setState(State.CLIMB);
                display.setPaused(false);
            }
        }

        public void climbStop()
        {
            if (!level.getClippingUp((int) Options.CLIMB_VEL).isEmpty())
            {
                display.setPaused(true);
                setVY(0);
            }   
            else
                display.setPaused(false);
        }

        public void stickStart()
        {
            if (flip && (!InputHandler.isKeyDown("a") || !InputHandler.isKeyDown("w")))
                setState(State.STICK);
            if (!flip && (!InputHandler.isKeyDown("d") || !InputHandler.isKeyDown("w")))   
                setState(State.STICK);
        }

        public void wallRelease()
        {
            if (flip)
            {
                if (level.getClippingLeft(1).isEmpty())
                {
                    setVY(-Options.JUMP_VEL);
                    setState(State.JUMP);
                }
                else if ((InputHandler.isKeyDown("d") && InputHandler.isKeyUp("a")) || InputHandler.isKeyDown("s"))
                {
                    setState(State.FALL);
                    display.setPaused(false);
                }
            }
            else
            {
                if (level.getClippingRight(1).isEmpty())
                {
                    setVY(-Options.JUMP_VEL);
                    setState(State.JUMP);
                }
                else if ((InputHandler.isKeyDown("a") && InputHandler.isKeyUp("d")) || InputHandler.isKeyDown("s"))
                {
                    setState(State.FALL);
                    display.setPaused(false);
                }
            }
        }

        public void wallJump()
        {
            endWallJump = System.currentTimeMillis() + Options.WALL_JUMP_WINDOW;
            if (InputHandler.isKeyJustPressed("space"))
            {
                if (flip)
                    setVX(Options.JUMP_VEL * 2);
                else
                    setVX(-Options.JUMP_VEL * 2);
                setVY(-Options.JUMP_VEL);
                setState(State.JUMP);
            }
        }

        public void attack()
        {
            if (InputHandler.isKeyJustPressed("left"))
            {
                setV(-Options.ATTACK_SHIFT, 0);
                flip = true;
                setState(State.HIT_F);
                Greenfoot.playSound("49693__ejfortin__energy-gloves.wav");
            }
            else if (InputHandler.isKeyJustPressed("right"))
            {
                setV(Options.ATTACK_SHIFT, 0);
                flip = false;
                setState(State.HIT_F);
                Greenfoot.playSound("49693__ejfortin__energy-gloves.wav");
            }
            else if (InputHandler.isKeyJustPressed("up"))
            {
                setV(0, -Options.ATTACK_SHIFT);
                setState(State.HIT_U);
                Greenfoot.playSound("49693__ejfortin__energy-gloves.wav");
            }
            else if (InputHandler.isKeyJustPressed("down"))
            {
                setV(0, Options.ATTACK_SHIFT / 3);
                setState(State.HIT_D);
                Greenfoot.playSound("49693__ejfortin__energy-gloves.wav");
            }
        }

        public void idle()
        {
            airJumpAvail = true;
            groundMove();
            if (checkState(State.IDLE))
                wallGrab();
            if (checkState(State.IDLE))
                groundJump();
            if (checkState(State.IDLE))
                attack();
            if (checkState(State.IDLE))
                velFlip();

            if (checkState(State.IDLE))
            {
                if (level.getClippingDown(1).isEmpty())
                    setState(State.FALL);
                else if (Math.abs(getVX()) > Options.IDLE_TO_RUN_SPEED && (InputHandler.isKeyDown("a") || InputHandler.isKeyDown("d")))
                    setState(State.RUN);
            }
        }

        public void run()
        {
            airJumpAvail = true;
            groundMove();
            if (checkState(State.RUN))
                wallGrab();
            if (checkState(State.RUN))
                groundJump();
            if (checkState(State.RUN))
                attack();
            if (checkState(State.RUN))
                velFlip();
            if (checkState(State.RUN))
                if (InputHandler.isKeyJustPressed("space"))
                    setState(State.JUMP);
                else if (level.getClippingDown(1).isEmpty())
                    setState(State.FALL);
                else if (!level.getClippingLeft(1).isEmpty() || !level.getClippingRight(1).isEmpty())
                    setState(State.IDLE);
                else if (Math.abs(getVX()) < Options.RUN_TO_IDLE_SPEED && !(InputHandler.isKeyDown("a") || InputHandler.isKeyDown("d")))
                    setState(State.IDLE);
            // if (checkState(State.RUN))
            // if (display.checkFrame(1, 1) || display.checkFrame(4, 1))
            // {
            // }
        }

        public void grab()
        {
            airJumpAvail = true;
            wallRelease();
            if (checkState(State.GRAB))
                wallJump();
            if (checkState(State.GRAB))
                attack();

            if (checkState(State.GRAB))
            {
                if (display.checkName("grab") && display.checkFrame(1, 1))
                    setVY(-Options.CLIMB_VEL);
                if (display.checkName("grab") && display.isEnd())
                    setState(State.CLIMB);
            }
        }

        public void stick()
        {
            airJumpAvail = true;
            display.setPaused(true);
            climbStart();
            if (checkState(State.STICK))
                wallJump();
            if (checkState(State.STICK))
                wallRelease();
            if (checkState(State.STICK))
                attack();

            if (checkState(State.STICK))
            {
                setVY(Options.WALL_STICK_VEL);
                if (!level.getClippingDown(1).isEmpty())
                    setState(State.LAND);
            }
        }

        public void climb()
        {
            airJumpAvail = true;
            stickStart();
            if (checkState(State.CLIMB))
                climbStop();
            if (checkState(State.CLIMB))
                wallRelease();
            if (checkState(State.CLIMB))
                wallJump();
            if (checkState(State.CLIMB))
                attack();

            if (checkState(State.CLIMB))
                if (display.checkName("climb") && (display.checkFrame(1, 1) || display.checkFrame(3, 1)))
                    setVY(-Options.CLIMB_VEL);
        }

        public void jump()
        {
            airMove();
            if (checkState(State.JUMP))
                airHover();
            if (checkState(State.JUMP))
                wallGrab();
            if (checkState(State.JUMP))
                velFlip();
            if (checkState(State.JUMP))
                attack();
            if (checkState(State.JUMP))
                airJump();

            if (checkState(State.JUMP))
            {
                if (!level.getClippingDown(1).isEmpty())
                    setState(State.LAND);
                else if (display.checkName("jump") && display.isEnd())
                    setState(State.FALL);
            }
        }

        public void fall()
        {
            airMove();
            if (checkState(State.FALL))
                airHover();
            if (checkState(State.FALL))
                wallGrab();
            if (checkState(State.FALL))
                velFlip();
            if (checkState(State.FALL))
                attack();
            if (checkState(State.FALL))
                airJump();

            if (checkState(State.FALL))
                if (!level.getClippingDown(1).isEmpty())
                    setState(State.LAND);
        }

        public void land()
        {
            airJumpAvail = true;
            groundMove();
            if (checkState(State.LAND))
                groundJump();
            if (checkState(State.LAND))
                attack();
            if (checkState(State.LAND))
                wallGrab();
            if (checkState(State.LAND))
                velFlip();

            if (checkState(State.LAND))
                if (display.checkName("land") && display.isEnd())
                {
                    if (level.getClippingDown(1).isEmpty())
                        setState(State.FALL);
                    else if (Math.abs(getVX()) > Options.IDLE_TO_RUN_SPEED)
                        setState(State.RUN);
                    else
                        setState(State.IDLE);
                }
        }

        public void hit_f()
        {
            airMove();
            if (checkState(State.HIT_F))
                airHover();

            if (checkState(State.HIT_F))
            {
                if (!hit.getClipping().isEmpty())
                {
                    for (CollisionPlayer collision : hit.getClipping())
                    {
                        Enemy enemy = (Enemy) collision.getParent();
                        enemy.hurt(getX(), getY() + 65, 1);
                        if (!enemy.getInvul())
                        {
                            for (int i = 0; i < 10; i++)
                                ((GameWorld) Global.world).freeAddObject(new HitParticle(), hit.getX(), hit.getY());
                            ((Room) Global.world).freeze(Options.FREEZE_FRAME);
                            if (flip)
                                enemy.setV(-15, -15);
                            else
                                enemy.setV(15, -15);
                            Greenfoot.playSound("Pickup_Coin11.wav");
                        }
                    }
                }
                if (display.checkName("hit_f") && display.isEnd())
                    setState(State.IDLE);
            }
        }

        public void hit_u()
        {
            airMove();
            if (checkState(State.HIT_U))
                airHover();

            if (checkState(State.HIT_U))
            {
                if (!hit.getClipping().isEmpty())
                {
                    for (CollisionPlayer collision : hit.getClipping())
                    {
                        Enemy enemy = (Enemy) collision.getParent();
                        enemy.hurt(getX(), getY() + 65, 1);
                        if (!enemy.getInvul())
                        {
                            for (int i = 0; i < 10; i++)
                                ((GameWorld) Global.world).freeAddObject(new HitParticle(), hit.getX(), hit.getY());
                            ((Room) Global.world).freeze(Options.FREEZE_FRAME);
                            if (flip)
                                enemy.setV(-5, -25);
                            else
                                enemy.setV(5, -25);
                            Greenfoot.playSound("Pickup_Coin11.wav");
                        }
                    }
                }
                if (display.checkName("hit_u") && display.isEnd())
                    setState(State.IDLE);
            }
        }

        public void hit_d()
        {
            airMove();
            if (checkState(State.HIT_D))
                airHover();

            if (checkState(State.HIT_D))
            {
                if (!hit.getClipping().isEmpty())
                {
                    for (CollisionPlayer collision : hit.getClipping())
                    {
                        Enemy enemy = (Enemy) collision.getParent();
                        enemy.hurt(getX(), getY() + 65, 1);
                        if (!enemy.getInvul())
                        {
                            for (int i = 0; i < 10; i++)
                                ((GameWorld) Global.world).freeAddObject(new HitParticle(), hit.getX(), hit.getY());
                            ((Room) Global.world).freeze(Options.FREEZE_FRAME);
                            if (flip)
                                enemy.setV(-15, 15);
                            else
                                enemy.setV(15, 15);
                            Greenfoot.playSound("Pickup_Coin11.wav");
                        }
                    }
                }
                if (display.checkName("hit_d") && display.isEnd())
                    setState(State.FALL);
            }
        }

        public void updateAnim()
        {   
            display.setFlip(flip, false);
            if (!checkState(State.CLIMB) && !checkState(State.STICK))
                display.setPaused(false);
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

            hit.stop();

            switch (state)
            {
                case IDLE:
                display.play("idle", true, 1);
                break;
                case RUN:
                display.setPaused(false);
                display.play("run", true, 8);
                break;
                case GRAB:
                display.setPaused(false);
                display.play("grab", false, 30);
                break;
                case CLIMB:
                display.play("climb", true, 10);
                break;
                case JUMP:
                display.setPaused(false);
                display.play("jump", false, 5);
                break;
                case FALL:
                display.setPaused(false);
                display.play("fall", true, 5);
                break;
                case LAND:
                display.setPaused(false);
                display.play("land", false, 15);
                break;
                case HIT_F:
                display.setPaused(false);
                display.play("hit_f", false, 20);
                if (flip)
                    hit.setOffset(-60, 90);
                else
                    hit.setOffset(60, 90);
                if (display.checkFrame(2, 1) || display.checkFrame(3, 1))
                    hit.play("hit_f", false, 0);
                break;
                case HIT_U:
                display.setPaused(false);
                display.play("hit_u", false, 20);
                if (flip)
                    hit.setOffset(-5, 40);
                else
                    hit.setOffset(5, 40);
                if (display.checkFrame(2, 1) || display.checkFrame(3, 1))
                    hit.play("hit_u", false, 0);
                break;
                case HIT_D:
                display.setPaused(false);
                display.play("hit_d", false, 20);
                if (flip)
                    hit.setOffset(-5, 180);
                else
                    hit.setOffset(5, 180);
                if (display.checkFrame(2, 1) || display.checkFrame(3, 1))
                    hit.play("hit_d", false, 0);
                break;
            }
        }

        public void limit()
        {
            if (checkState(AIR))
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
            Greenfoot.playSound("Hit_Hurt143.wav");
            state = State.FALL;
        }

        public void die(int xPos, int yPos)
        {
            PlayerDeathParticle deathParticle = new PlayerDeathParticle();
            if (xPos > getX())
                deathParticle.setVX(-10);
            else
                deathParticle.setVX(10);
            deathParticle.setVY(-10);
            ((GameWorld) Global.world).freeAddObject(deathParticle, getX(), getY());
            ((GameWorld) Global.world).freeAddObject(new Explosion2(), display.getX(), display.getY());

            super.die(xPos, yPos);
        }

        public State getState()
        {
            return state;
        }

        public void setState(State state)
        {
            this.state = state;
            if (Options.DISPLAY_PLAYER_STATE)
                System.out.println(getState());
        }

        public boolean checkState(State state)
        {
            return getState() == state;
        }

        public boolean checkState(State[] states)
        {
            for (State state : states)
                if (checkState(state))
                    return true;
            return false;
        }
    }
