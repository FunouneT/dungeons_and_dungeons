import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tile_spikes extends Actor
{
    GreenfootImage[] spikeTiles = new GreenfootImage[Constants.FRAMES_NUM];
    GreenfootImage currImage;
    
    boolean active;
    int size;
    
    int anim_cd = 5;
    int anim_cntr = 0;
    
    private Room room;
    private Player player;
    
    public Tile_spikes(int size)
    {
        active = true;
        this.size = size;
        for (int i = 0; i < Constants.FRAMES_NUM; i++)
        {
            spikeTiles[i] = new GreenfootImage("lab/floor_spikes_anim_f" + i + ".png");
            spikeTiles[i].scale(size, size);
            
        }
        setImage(spikeTiles[Constants.FRAMES_NUM - 1]);
    }
    
    protected void addedToWorld(World world)
    {
        room = getWorldOfType(Room.class);
        player = room.player;
    }
    
    public void act()
    {
        if (room.lever != null)
            active = !room.lever.active;
        if (active)
        {
            anim_cntr++;
            if (anim_cntr / anim_cd >= 4)
                anim_cntr = anim_cd * 3;
            currImage = spikeTiles[anim_cntr / anim_cd];
        }
        else
        {
            anim_cntr--;
            if (anim_cntr / anim_cd < 0)
                anim_cntr = 0;
            currImage = spikeTiles[anim_cntr / anim_cd];
        }
        
        setImage(currImage);
        
        if (currImage == spikeTiles[Constants.FRAMES_NUM - 1])
        {
            if (player != null)
            {
                if (player.getX() >= getX() - size / 2 && player.getX() <= getX() + size / 2)
                {
                    if (player.getY() + size / 2 >= getY() - size / 2 && player.getY() + size / 2 <= getY() + size / 2)
                        player.do_damage(1);
                }
            }
        }
    }
}
