import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lizard extends Enemy
{
    int attack_cd = Constants.LIZARD_ATTACK_CD;
    int attack_cntr = 0;
    
    public Lizard()
    {
        for (int i = 0; i < Constants.FRAMES_NUM; i++)
        {
            run_frames_r[i] = new GreenfootImage("lizard/lizard_f_run_anim_f" + i + ".png");
            run_frames_l[i] = new GreenfootImage(run_frames_r[i]);
            run_frames_l[i].mirrorHorizontally();
            idle_frames_r[i] = new GreenfootImage("lizard/lizard_f_idle_anim_f" + i + ".png");
            idle_frames_l[i] = new GreenfootImage(idle_frames_r[i]);
            idle_frames_l[i].mirrorHorizontally();
            hit_frame_r = new GreenfootImage("lizard/lizard_f_hit_anim_f0.png");
            hit_frame_l = new GreenfootImage(hit_frame_r);
            hit_frame_l.mirrorHorizontally();
        }
        scaleWidth = 0.8;
        scaleHeight = 1.4;
        run_anim_cd = 10;
        idle_anim_cd = 15;
        hit_cd = Constants.LIZARD_HITTED_CD;
        
        drop = Constants.LIZARD_DROP;
        max_HP = Constants.LIZARD_HP;
        HP = max_HP;
        speed = Constants.LIZARD_VEL;
    }
    
    public void act()
    {
        if (hit_cntr <= 0)
            hitted = false;
        
        if (!hitted)
        {
            if (room.player != null)
            {
                move_to_player();
                if (isTouching(Player.class))
                {
                    if (attack_cntr > attack_cd)
                    {
                        room.player.do_damage(Constants.LIZARD_DAMAGE);
                        attack_cntr = 0;
                    }
                }
                attack_cntr++;
            }
        }
        else
            hit_cntr--;
    
        check_dir();
        animating();
        check_death();
    }
}
