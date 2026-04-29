import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    Room_Preparer preparer;
    
    public MyWorld()
    {    
        super(1000, 800, 1);
        preparer = new Room_Preparer();
    }
    
    public void started()
    {
        Greenfoot.setWorld(preparer.get_room(0, preparer));
    }
}
