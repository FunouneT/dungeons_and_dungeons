import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Skelet extends Enemy
{
    public Skelet()
    {
        for (int i = 0; i < Constants.FRAMES_NUM; i++)
        {
            run_frames_r[i] = new GreenfootImage("skelet/skelet_run_anim_f" + i + ".png");
            run_frames_l[i] = new GreenfootImage(run_frames_r[i]);
            run_frames_l[i].mirrorHorizontally();
            idle_frames_r[i] = new GreenfootImage("skelet/skelet_idle_anim_f" + i + ".png");
            idle_frames_l[i] = new GreenfootImage(idle_frames_r[i]);
            idle_frames_l[i].mirrorHorizontally();
            hit_frame_r = new GreenfootImage("skelet/skelet_hit_anim_f0.png");
            hit_frame_l = new GreenfootImage(hit_frame_r);
            hit_frame_l.mirrorHorizontally();
        }
        scaleWidth = 1.0;
        scaleHeight = 1.0;
        run_anim_cd = 10;
        idle_anim_cd = 15;
        hit_cd = Constants.SKELET_HITTED_CD;
        
        
        item = new Bow(this);
        item.interact_cd += Constants.SKELET_ADD_FIRE_CD;
        drop = Constants.SKELET_DROP;
        max_HP = Constants.SKELET_HP;
        HP = max_HP;
        speed = Constants.SKELET_VEL;
    }
    
    public void act()
    {
        if (hit_cntr <= 0)
            hitted = false;
        
        if (!hitted)
        {
            if (room.player != null)
            {
                double distance = Math.sqrt(Math.pow(room.player.getX() - getX(), 2) + Math.pow(room.player.getY() - getY(), 2));
                if (distance > Constants.SKELET_STOP_DIST)
                    move_to_player();
            }
            item.interact();
        }
        else
            hit_cntr--;
            
        check_dir();
        animating();
        check_death();
    }
}
