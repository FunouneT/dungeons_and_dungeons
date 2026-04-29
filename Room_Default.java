import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Room_Default extends Room
{
    public Room_Default(Player player, Room_Preparer preparer)
    {
        super(Constants.R_DEFAULT_WIDTH * Constants.R_DEFAULT_SIZE + Constants.HUD_WIDTH, Constants.R_DEFAULT_HEIGHT * Constants.R_DEFAULT_SIZE, 1, player, preparer);
        this.player = player;
        roomArray = Constants.R_DEFAULT_MAP;
        enemy_num = Constants.R_DEFAULT_ENEMY_NUM;
        lightMap = new Darkness[Constants.R_DEFAULT_WIDTH][Constants.R_DEFAULT_HEIGHT];
        size = Constants.R_DEFAULT_SIZE;
        lightRad = Constants.R_DEFAULT_SIZE * Constants.LIGTH_R_MULT;
        pX = Constants.R_DEFAULT_WIDTH * Constants.R_DEFAULT_SIZE / 2 - Constants.R_DEFAULT_SIZE / 2;
        pY = (Constants.R_DEFAULT_HEIGHT - 1) * Constants.R_DEFAULT_SIZE;
    }
    
    protected void additions()
    {}
}
