import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tile_wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile_wall extends Actor
{
    //GreenfootImage[] wall_tiles;
    GreenfootImage image;
    int type;
    
    public Tile_wall(int type, int size)
    {
        type = type;
        switch(type)
        {
        case 1:
            image = new GreenfootImage("wall/wall_outer_mid_left.png");
            break;
        case 2:
            image = new GreenfootImage("wall/wall_outer_mid_right.png");
            break;
        case 6:
            image = new GreenfootImage("wall/wall_outer_top_left.png");
            break;
        case 7:
            image = new GreenfootImage("wall/wall_outer_top_right.png");
            break;
        case 8:
            image = new GreenfootImage("wall/wall_top_right.png");
            break;
        case 4:
            image = new GreenfootImage("wall/wall_edge_left.png");
            break;
        case 5:
            image = new GreenfootImage("wall/wall_edge_right.png");
            break;
        case 3:
            image = new GreenfootImage("wall/wall_mid.png");
            break;
        }
        image.scale(size, size);
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
