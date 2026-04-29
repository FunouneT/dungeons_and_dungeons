import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tile_floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile_floor extends Actor
{
    GreenfootImage[] floorTiles;
    
    public Tile_floor(int size)
    {
        GreenfootImage image = new GreenfootImage("floor/floor_" + (Greenfoot.getRandomNumber(8) + 1) + ".png");
        image.scale(size,size);
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
