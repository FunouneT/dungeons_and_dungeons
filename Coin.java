import greenfoot.*;
public class Coin extends Item
{
    int anim_cntr = 0;
    int anim_cd = 15;
    int frame_cntr = 0;
    public Coin(Entity owner_i)
    {
        owner = owner_i;
        scaleWidth = 0.5;
        scaleHeight = 0.5;
        interact_cd = 0;
        diff_value = Constants.COIN_DIFF_VALUE;
        frames = new GreenfootImage[Constants.FRAMES_NUM];
        for (int i = 0; i < Constants.FRAMES_NUM; i++)
            frames[i] = new GreenfootImage("items/coin_anim_f" + i + ".png");
    }
    
    public void animate()
    {
        anim_cntr++;
        if (anim_cntr > anim_cd)
        {
            frame_cntr++;
            if (frame_cntr >= Constants.FRAMES_NUM)
                frame_cntr = 0;
            setImage(frames[frame_cntr]);
            anim_cntr = 0;
        }
    }
    
    public void addition()
    {}
    
    public void interact()
    {
        if (owner.getClass() == Player.class)
            ((Player)owner).balance += 1;
        for (int i = 0; i < Constants.PARTICLE_NUM; i++)
            room.addObject(new Particle(room.size / 3), getX(), getY());
        owner.item = null;
        room.removeObject(this);
    }
}
