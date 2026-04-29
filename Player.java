import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Entity
{  
    int balance = 0;
    public Player()
    {
        kills = 0;
        for (int i = 0; i < Constants.FRAMES_NUM; i++)
        {
            run_frames_r[i] = new GreenfootImage("player/knight_f_run_anim_f" + i + ".png");
            run_frames_l[i] = new GreenfootImage(run_frames_r[i]);
            run_frames_l[i].mirrorHorizontally();
            idle_frames_r[i] = new GreenfootImage("player/knight_f_idle_anim_f" + i + ".png");
            idle_frames_l[i] = new GreenfootImage(idle_frames_r[i]);
            idle_frames_l[i].mirrorHorizontally();
            hit_frame_r = new GreenfootImage("player/knight_f_hit_anim_f0.png");
            hit_frame_l = new GreenfootImage(hit_frame_r);
            hit_frame_l.mirrorHorizontally();
        }
        scaleWidth = 0.8;
        scaleHeight = 1.4;
        run_anim_cd = 3;
        idle_anim_cd = 15;
        hit_cd = Constants.PLAYER_HITTED_CD;
        
        //item = new Sword(this);
        item = new Bow(this);
        max_HP = Constants.PLAYER_HP;
        HP = max_HP;
        speed = Constants.PLAYER_VEL;
    }
    
    private void moving()
    {
        double dirX = 0;
        double dirY = 0;
        
        if (Greenfoot.isKeyDown("w")) dirY -= 1;
        if (Greenfoot.isKeyDown("s")) dirY += 1;
        if (Greenfoot.isKeyDown("d"))
        {
            dirX += 1;
            dir = 1;
        }
        if (Greenfoot.isKeyDown("a"))
        {
            dirX -= 1;
            dir = -1;
        }
        
        double len = Math.sqrt(dirX * dirX + dirY * dirY);
        if (len > 0)
        {
            dirX = dirX / len * curr_speed;
            dirY = dirY / len * curr_speed;
            if (room.have_floor((int)(getExactX() + dirX), (int)(getExactY() + dirY)))
                setLocation(getExactX() + dirX, getExactY() + dirY);
        }
    }
    
    public void act()
    {
        if (hit_cntr <= 0)
            hitted = false;
        
        if (!hitted)
        {
            if (item == null)
            {
                Item pos_item = (Item) getOneIntersectingObject(Item.class);
                if (pos_item != null && pos_item.owner == null)
                {
                    room.preparer.hud.show_equip = true;
                    if (Greenfoot.isKeyDown("e"))
                    {
                        if (pos_item != null)
                        {
                            item = pos_item;
                            item.setOwner(this);
                        }
                        room.preparer.hud.show_equip = false;
                    }
                }
                else
                    room.preparer.hud.show_equip = false;
            }
            if (item != null && Greenfoot.isKeyDown("q"))
            {
                item.setOwner(null);
                item = null;
            }
            Lever pos_lever = (Lever) getOneIntersectingObject(Lever.class);
            if ((item != null || pos_lever != null) && Greenfoot.isKeyDown("Space"))
            {
                if (pos_lever != null)
                    pos_lever.interact();
                else
                    item.interact();
            }
            moving();
        }
        else
            hit_cntr--;
        
        animating();
    }
}
