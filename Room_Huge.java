import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Room_Huge extends Room
{
    public Room_Huge(Player player, Room_Preparer preparer)
    {
        super(Constants.R_HUGE_WIDTH * Constants.R_HUGE_SIZE + Constants.HUD_WIDTH, Constants.R_HUGE_HEIGHT * Constants.R_HUGE_SIZE, 1, player, preparer);
        this.player = player;
        roomArray = Constants.R_HUGE_MAP;
        enemy_num = Constants.R_HUGE_ENEMY_NUM;
        lightMap = new Darkness[Constants.R_HUGE_WIDTH][Constants.R_HUGE_HEIGHT];
        size = Constants.R_HUGE_SIZE;
        lightRad = Constants.R_HUGE_SIZE * Constants.LIGTH_R_MULT;
        pX = Constants.R_HUGE_WIDTH * Constants.R_HUGE_SIZE / 2 - Constants.R_HUGE_SIZE / 2;
        pY = (Constants.R_HUGE_HEIGHT - 1) * Constants.R_HUGE_SIZE;
    }
    
    protected void additions()
    {}
}

