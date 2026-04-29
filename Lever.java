import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lever extends Actor
{
    private GreenfootImage left;
    private GreenfootImage right;
    public boolean active;
    private int size;
    
    private int interact_cd;
    private int interact_cntr = 0;
    
    public Lever(int size)
    {
        this.size = size;
        active = false;
        interact_cd = Constants.LEVER_INTERACT_CD;
        
        left = new GreenfootImage("lab/lever_left.png");
        left.scale(size, size);
        right = new GreenfootImage("lab/lever_right.png");
        right.scale(size, size);
        setImage(left);
    }
    
    public void interact()
    {
        if (interact_cntr > interact_cd)
        {
            if (active)
            {
                active = false;
                setImage(left);
            }
            else
            {
                active = true;
                setImage(right);
            }
            interact_cntr = 0;
        }
    }
    
    public void act()
    {
        interact_cntr++;
    }
}
