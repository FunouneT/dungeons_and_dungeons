import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Projectile extends SmoothMover
{
    GreenfootImage image;
    
    Entity owner;
    
    double scaleWidth;
    double scaleHeight;
    
    double speed;
    int angle;
    
    public int damage;
    int damage_cd;
    int damage_cntr = 0;
    
    protected void addedToWorld(World world)
    {
        Room room = getWorldOfType(Room.class);
        image.scale((int)(room.size * scaleWidth), (int)(room.size * scaleHeight));
        setImage(image);
    }
    
    public void act()
    { 
    }
}
