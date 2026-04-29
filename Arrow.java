import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Arrow extends Projectile
{
    public Arrow(int angle_i, Entity owner_i)
    {
        owner = owner_i;
        speed = Constants.ARROW_VEL;
        scaleWidth = 0.6;
        scaleHeight = 0.25;
        angle = angle_i;
        setRotation(angle);
        image = new GreenfootImage("items/weapon_arrow.png");
        
        damage = Constants.ARROW_DAMAGE;
    }
    
    @Override
    public void act()
    {
        int nextX = getX() + (int) Math.round(Math.cos(angle) * speed);
        int nextY = getY() + (int) Math.round(Math.sin(angle) * speed);
        if (!((Room)getWorld()).have_wall(nextX, nextY))
        {
            move(speed);
            Entity entity = (Entity) getOneIntersectingObject(Entity.class);
            if (entity != owner)
            {
                if (entity != null)
                {
                    if (entity.do_damage(damage))
                        owner.kills++;
                    getWorld().removeObject(this);
                    return;
                }
            }
            else
                damage_cntr++;
            if (isAtEdge())
            {
                getWorld().removeObject(this);
                return;
            }
        }
    }
}
