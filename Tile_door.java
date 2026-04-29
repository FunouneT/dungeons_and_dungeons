import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tile_door extends Actor
{
    GreenfootImage image;
    
    private int type;
    private int size;
    
    private Room room;
    private Player player;
    
    Tile_door p2, p3, p4;
    
    public Tile_door(int type, int size)
    {
        this.type = type;
        this.size = size;
        
        switch(type)
        {
        case 11:
            image = new GreenfootImage("door/doors_leaf_closed_p1.png");
            break;
        case 12:
            image = new GreenfootImage("door/doors_leaf_closed_p2.png");
            break;
        case 13:
            image = new GreenfootImage("door/doors_leaf_closed_p3.png");
            break;
        case 14:
            image = new GreenfootImage("door/doors_leaf_closed_p4.png");
            break;
        }
        image.scale(size, size);
        setImage(image);
    }
    
    protected void addedToWorld(World world)
    {
        room = getWorldOfType(Room.class);
        player = room.player;
    }
    
    public void set_other_parts(Tile_door p2, Tile_door p3, Tile_door p4)
    {
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
    
    public void open()
    {
        switch(type)
        {
        case 11:
            image = new GreenfootImage("door/doors_leaf_open_p1.png");
            break;
        case 12:
            image = new GreenfootImage("door/doors_leaf_open_p2.png");
            break;
        case 13:
            image = new GreenfootImage("door/doors_leaf_open_p3.png");
            break;
        case 14:
            image = new GreenfootImage("door/doors_leaf_open_p4.png");
            break;
        }
        image.scale(size, size);
        setImage(image);
    }
    
    public void act()
    {
        if (player != null && player.getY() < getY()) {
            open();
            if (p2 != null)
            {
                p2.open();
                p3.open();
                p4.open();
            }
            room.next_room();
        }
    }
}
