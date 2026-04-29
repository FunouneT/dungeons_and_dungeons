import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Sword extends Melee_Weapon
{
    public Sword(Entity owner_i)
    {
        owner = owner_i;
        damage = Constants.SWORD_DAMAGE;
        scaleWidth = 0.4;
        scaleHeight = 1.05;
        interact_cd = 0;
        damage_vel = Constants.SWORD_DAMAGE_VEL;
        diff_value = Constants.SWORD_DIFF_VALUE;
        frames = new GreenfootImage[2];
        frames[0] = new GreenfootImage("items/weapon_regular_sword.png");
        frames[1] = new GreenfootImage("items/weapon_regular_sword_2.png");
    }
}
