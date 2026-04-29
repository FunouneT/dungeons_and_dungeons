import greenfoot.*;
public class Potion_Heal_S extends Potion
{
    public Potion_Heal_S(Entity owner_i)
    {
        owner = owner_i;
        scaleWidth = 0.5;
        scaleHeight = 0.5;
        interact_cd = 0;
        diff_value = Constants.POTION_DIFF_VALUE;
        frames = new GreenfootImage[1];
        frames[0] = new GreenfootImage("potions/flask_red.png");
        setImage(frames[0]);
    }
    
    public void effect()
    {
        if (owner != null)
            owner.HP += Constants.POTION_HEAL;
    }
}
