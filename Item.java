import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Item extends SmoothMover
{
    GreenfootImage frames[];
    Room room;
    
    double scaleWidth;
    double scaleHeight;
    
    Entity owner;
    
    double angle;
    double ofsX = 0, ofsY = 0;
    double dist_owner = Constants.DIST_FROM_OWNER;
    double curr_dist_owner;
    double diff_value;
    
    int interact_cd;
    int interact_cntr = 0;
    
    double bound_cntr = 0;
    
    int lastX, lastY;
    
    protected void addedToWorld(World world)
    {
        room = getWorldOfType(Room.class);
        for (int i = 0; i < frames.length; i++)
        {
            frames[i].scale((int)(room.size * scaleWidth), (int)(room.size * scaleHeight));
        }
        curr_dist_owner = dist_owner * room.size / Constants.ORIG_SIZE;
    }
    
    public abstract void interact();
    public abstract void animate();
    public abstract void addition();
    
    public final void setOwner(Entity owner_i)
    {
        owner = owner_i;
    }
    
    public final void act()
    {
        if (owner == null)
        {
            interact_cntr = 0;
            bound_cntr += 0.1;
            setLocation(getExactX(), getExactY() + Math.sin(bound_cntr) * Constants.ITEM_BOUND * room.size / Constants.ORIG_SIZE);
            if (bound_cntr >= Math.PI * 2)
                bound_cntr = 0;
        }
        else 
        {
            
            interact_cntr++;
        
                double raw_angle;
                int dx;
                int dy;
                if (owner.getClass() == Player.class)
                {
                    if (Greenfoot.getMouseInfo() != null)
                    {
                        lastX = Greenfoot.getMouseInfo().getX();
                        lastY = Greenfoot.getMouseInfo().getY();
                    }
                    
                    dx = lastX - getX();
                    dy = lastY - getY();
                }
                else
                {
                    dx = room.player.getX() - getX();
                    dy = room.player.getY() - getY();
                }
                double dist = Math.sqrt(dx * dx + dy * dy);
                raw_angle = Math.atan2(dy, dx) * 180.0 / Math.PI;
                
                double diff = raw_angle - angle;
                if (diff > 180) diff -= 360;
                if (diff < -180) diff += 360;
                
                angle += diff * dist / (800 / diff_value);
                
                angle = angle % 360;
                if (angle < 0) angle += 360;
                
                ofsX = Math.cos(Math.toRadians(angle)) * curr_dist_owner;
                ofsY = Math.sin(Math.toRadians(angle)) * curr_dist_owner;
                setRotation((int) angle);
            setLocation(owner.getExactX() + ofsX, owner.getExactY() + ofsY);
        }
        animate();
        addition();
    }
}
