import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Entity extends SmoothMover
{
    public int HP;
    public int max_HP;
    public Item item = null;
    public double speed;
    public double curr_speed;
    
    public int kills;
    
    double scaleWidth;
    double scaleHeight;
    
    protected double prevX, prevY;
    protected int anim_cntr = 0;
    protected int run_anim_cd;
    protected int run_anim_cntr = 0;
    protected GreenfootImage[] run_frames_r = new GreenfootImage[Constants.FRAMES_NUM];
    protected GreenfootImage[] run_frames_l = new GreenfootImage[Constants.FRAMES_NUM];
    protected double dir;
    protected int idle_anim_cntr = 0;
    protected int idle_anim_cd;
    protected GreenfootImage[] idle_frames_r = new GreenfootImage[Constants.FRAMES_NUM];
    protected GreenfootImage[] idle_frames_l = new GreenfootImage[Constants.FRAMES_NUM];
    protected GreenfootImage hit_frame_r, hit_frame_l;
    protected int hit_cd;
    protected int hit_cntr = 0;
    
    protected int offsetY;
    
    protected double realX;
    protected double realY;
    
    protected boolean hitted = false;
    
    protected Room room;
    
    protected final void addedToWorld(World world)
    {
        room = getWorldOfType(Room.class);
        int size = room.size;
        
        curr_speed = speed * (double)size / Constants.ORIG_SIZE;
        
        for (int i = 0; i < Constants.FRAMES_NUM; i++)
        {
            if (run_frames_r != null && run_frames_l != null)
            {
                run_frames_r[i].scale((int)(size * scaleWidth), (int)(size * scaleHeight));
                run_frames_l[i].scale((int)(size * scaleWidth), (int)(size * scaleHeight));
            }
            if (idle_frames_r != null && idle_frames_l != null)
            {
                idle_frames_r[i].scale((int)(size * scaleWidth), (int)(size * scaleHeight));
                idle_frames_l[i].scale((int)(size * scaleWidth), (int)(size * scaleHeight));
            }
            if (hit_frame_r != null && hit_frame_l != null)
            {
                hit_frame_r.scale((int)(size * scaleWidth), (int)(size * scaleHeight));
                hit_frame_l.scale((int)(size * scaleWidth), (int)(size * scaleHeight));
            }
        }
        
        realX = getExactX();
        realY = getExactY();
        
        prevX = realX;
        prevY = realY;
        
        if (item != null)
            room.addObject(item, getX(), getY());
        offsetY = size / 2;
    }
    
    public final boolean do_damage(int damage)
    {
        if (HP > max_HP)
            HP = max_HP;
        if (!hitted)
        {
            HP -= damage;
            hitted = true;
            hit_cntr = hit_cd;
        }
        if (HP <= 0)
            return true;
        return false;
    }
    
    protected final void animating()
    {
        if (hitted)
        {
            if (hit_frame_r != null && hit_frame_l != null)
            {
                if (dir > 0)
                    setImage(hit_frame_r);
                else
                    setImage(hit_frame_l);
            }
        }
        else
        {
            if (prevX != getExactX() || prevY != getExactY())
            {
                if (run_frames_r != null && run_frames_l != null)
                {
                    if (anim_cntr > run_anim_cd)
                    {
                        if (dir > 0)
                            setImage(run_frames_r[run_anim_cntr]);
                        else
                            setImage(run_frames_l[run_anim_cntr]);
                    
                        run_anim_cntr++;
                        if (run_anim_cntr >= Constants.FRAMES_NUM)
                            run_anim_cntr = 0;
                    
                        anim_cntr = 0;
                    }
                    anim_cntr++;
                }
            }
            else
            {
                if (idle_frames_r != null && idle_frames_l != null)
                {
                    if (anim_cntr > idle_anim_cd)
                    {
                        if (dir > 0)
                            setImage(idle_frames_r[idle_anim_cntr]);
                        else
                            setImage(idle_frames_l[idle_anim_cntr]);
                        
                        idle_anim_cntr++;
                        if (idle_anim_cntr >= Constants.FRAMES_NUM)
                            idle_anim_cntr = 0;
                        anim_cntr = 0;
                    }
                    anim_cntr++;
                }
            }
        }
        prevX = getExactX();
        prevY = getExactY();
    }
}
