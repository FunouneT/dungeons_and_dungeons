import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Axe extends Melee_Weapon
{
    public Axe(Entity owner_i)
    {
        owner = owner_i;
        damage = Constants.AXE_DAMAGE;
        scaleWidth = 0.8;
        scaleHeight = 1.2;
        interact_cd = 0;
        damage_vel = Constants.AXE_DAMAGE_VEL;
        diff_value = Constants.AXE_DIFF_VALUE;
        frames = new GreenfootImage[2];
        frames[0] = new GreenfootImage("items/weapon_double_axe.png");
        frames[1] = new GreenfootImage("items/weapon_double_axe_2.png");
    }
}
