import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Particle extends SmoothMover
{
    private int tp = 255;
   
    public Particle(int size) 
    {
        GreenfootImage image = new GreenfootImage(size / 2, size / 2);
        image.setColor(Color.GRAY);
        image.fill();
        image.setTransparency(tp);
        setImage(image);
    }
   
    private void fade() 
    {
        tp -= 5;
        
        if (tp <= 0) 
            getWorld().removeObject(this);
        else 
            getImage().setTransparency(tp);
    }
   
    public void act()
    {
        move(7);
        turn(Greenfoot.getRandomNumber(200) - 100);
        fade();
    }
}
