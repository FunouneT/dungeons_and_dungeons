import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Enemy extends Entity
{
    Constants.Drop_Entry[] drop;
    public final void move_to_player()
    {
        double dx = room.player.getX() - getX();
        double dy = room.player.getY() - getY();
        
        double distance = Math.sqrt(dx * dx + dy * dy);
        
        if (distance > 1)
        {
            double vx = (dx / distance) * curr_speed;
            double vy = (dy / distance) * curr_speed;
            
            setLocation(getExactX() + (double)vx, getExactY() + (double)vy);
        }
    }
    
    protected final void check_dir()
    {
        if (room.player.getX() - getX() > 0)
            dir = 1;
        else 
            dir = -1;
    }
    
    private Item get_drop()
    {
        int drop_value = Greenfoot.getRandomNumber(100) + 1;
        if (drop_value <= Constants.DROP_CHANCE)
        {
            for (int i = 0; i < drop.length; i++)
                if (drop_value <= drop[i].chance())
                    return drop[i].creator().create();     
        }
        return null;
    }
    
    protected final void check_death()
    {
        if (HP <= 0)
        {
            for (int i = 0; i < Constants.PARTICLE_NUM; i++)
                room.addObject(new Particle(room.size), getX(), getY());
            if (item != null)
                room.removeObject(item);
            
            Item drop_item = get_drop();
            if (drop_item != null)
                room.addObject(drop_item, getX(), getY());
            room.removeObject(this);
        }
    }
    
    public abstract void act();
}
