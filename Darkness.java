import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Darkness extends Actor
{
    GreenfootImage image;
    private int tp;
    
    public Darkness(int size, int transparency)
    {
        tp = transparency;
        image = new GreenfootImage(size, size);
        image.setColor(Color.BLACK);
        image.fill();
        image.setTransparency(transparency);
        setImage(image);
    }
    
    public void setTP(int tp)
    {
        this.tp = tp;
        if (tp > 255)
            tp = 255;
        image.setTransparency(tp);
        setImage(image);
    }
    
    public int getTP()
    {
        return tp;
    }
    
    public void act()
    {
        
    }
}
