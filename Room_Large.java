import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Room_Large extends Room
{
    public Room_Large(Player player, Room_Preparer preparer)
    {
        super(Constants.R_LARGE_WIDTH * Constants.R_LARGE_SIZE + Constants.HUD_WIDTH, Constants.R_LARGE_HEIGHT * Constants.R_LARGE_SIZE, 1, player, preparer);
        this.player = player;
        roomArray = Constants.R_LARGE_MAP;
        enemy_num = Constants.R_LARGE_ENEMY_NUM;
        lightMap = new Darkness[Constants.R_LARGE_WIDTH][Constants.R_LARGE_HEIGHT];
        size = Constants.R_LARGE_SIZE;
        lightRad = Constants.R_LARGE_SIZE * Constants.LIGTH_R_MULT;
        pX = Constants.R_LARGE_WIDTH * Constants.R_LARGE_SIZE / 2 - Constants.R_LARGE_SIZE / 2;
        pY = (Constants.R_LARGE_HEIGHT - 1) * Constants.R_LARGE_SIZE;
    }
    
    protected void additions()
    {}
}
