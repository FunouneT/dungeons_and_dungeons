import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Melee_Weapon extends Item
{
    boolean interacting;
    double velocity;
    int damage;
    int damage_vel;
    double prevX, prevY;
    
    @Override
    public void animate()
    {
        if (!(angle >= 270 || angle < 90))
        {
            setImage(frames[1]);
            if (interacting)
                setRotation((int)angle - 90);
        }
        else
        {
            setImage(frames[0]);
            if (interacting)
                setRotation((int)angle + 90);
        }
        
        if (interacting)
            curr_dist_owner = dist_owner * 3 * room.size / Constants.ORIG_SIZE;
        else
        {
            curr_dist_owner = dist_owner * room.size / Constants.ORIG_SIZE;
            setRotation((int)angle);
        }
        
        interacting = false;
    }
    
    @Override
    public void addition()
    {
        double currX = getExactX();
        double currY = getExactY();
        velocity = Math.hypot(currX - prevX, currY - prevY);
        velocity = velocity;
        prevX = currX;
        prevY = currY;
    }
    
    @Override
    public void interact()
    {
        interacting = true;
        if (velocity > damage_vel)
        {
            for (Projectile proj : getIntersectingObjects(Projectile.class))
                room.removeObject(proj);
            for (Entity entity : getIntersectingObjects(Entity.class))
                if (entity != owner)
                    if (entity.do_damage(damage))
                        owner.kills++;
        }
    }
}
