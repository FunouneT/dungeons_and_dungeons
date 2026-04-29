import greenfoot.*;
public abstract class Potion extends Item
{
    
    public void animate()
    {}
    
    public void addition()
    {}
    
    public abstract void effect();
    
    public void interact()
    {
        effect();
        for (int i = 0; i < Constants.PARTICLE_NUM; i++)
            room.addObject(new Particle(room.size / 3), getX(), getY());
        owner.item = null;
        room.removeObject(this);
    }
}
