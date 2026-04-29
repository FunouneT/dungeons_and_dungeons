import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bow extends Item
{
    public Bow(Entity owner_i)
    {
        owner = owner_i;
        scaleWidth = 0.7;
        scaleHeight = 1.2;
        interact_cd = Constants.BOW_FIRE_CD;
        diff_value = Constants.BOW_DIFF_VALUE;
        frames = new GreenfootImage[2];
        frames[0] = new GreenfootImage("items/weapon_bow.png");
        frames[1] = new GreenfootImage("items/weapon_bow_2.png");
    }
    
    @Override
    public void animate()
    {
        if (interact_cntr > interact_cd)
            setImage(frames[1]);
        else
            setImage(frames[0]);
    }
    
    @Override
    public void addition()
    {
        
    }
    
    @Override
    public void interact()
    {
        if (interact_cntr > interact_cd)
        {
            Room room = getWorldOfType(Room.class);
            room.addObject(new Arrow((int)angle + Greenfoot.getRandomNumber(Constants.BOW_SPREAD * 2 + 1) - Constants.BOW_SPREAD, owner), getX(), getY());
            interact_cntr = 0;
        }
    }
}
