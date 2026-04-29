import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Room_Start extends Room
{
    public Room_Start(Player player, Room_Preparer preparer)
    {
        super(Constants.R_START_WIDTH * Constants.R_START_SIZE + Constants.HUD_WIDTH, Constants.R_START_HEIGHT * Constants.R_START_SIZE, 1, player, preparer);
        this.player = player;
        roomArray = Constants.R_START_MAP;
        enemy_num = Constants.R_START_ENEMY_NUM;
        lightMap = new Darkness[Constants.R_START_WIDTH][Constants.R_START_HEIGHT];
        size = Constants.R_START_SIZE;
        lightRad = Constants.R_START_SIZE * Constants.LIGTH_R_MULT * 1000;
        addObject(new Sword(null), 300, 300);
        addObject(new Axe(null), 400, 300);
        addObject(new Potion_Heal_S(null), 400, 400);
        addObject(new Potion_Curse(null), 400, 500);
        pX = Constants.R_START_WIDTH * Constants.R_START_SIZE / 2 - Constants.R_START_SIZE / 2;
        pY = (Constants.R_START_HEIGHT - 1) * Constants.R_START_SIZE;
    }
    
    protected void additions()
    {}
}
