import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HUD extends Actor
{
    Player player;
    //GreenfootImage bg;
    Health_Bar hb;
    Actor hand_icon;
    Actor de_timer;
    GreenfootImage hand_image;
    Room room;
    Color tpColor = new Color(0,0,0,0);
    Font customFont;
    
    public boolean show_equip;
    
    public HUD(Player player_i)
    {
        player = player_i;
        hb = new Health_Bar(Constants.HB_SCALE);
        hand_icon = new Actor() {};
        de_timer = new Actor() {};
        hand_image = new GreenfootImage("hud/hud_hand_grab.png");
        hand_image.scale(150, 150);
        show_equip = false;
        customFont = new Font("Castellar", true, false, 80);
        //bg = new GreenfootImage("hud/hud_bg.png");
    }
    
    @Override
    protected void addedToWorld(World world)
    {
        room = getWorldOfType(Room.class);
        hb.updateImage(player.HP, player.max_HP);
        world.addObject(hb, getX() + Constants.HUD_WIDTH / 2 + Constants.HB_GAP * Constants.HB_SCALE / 2, Constants.HUD_OFFSET_TOP);
        world.addObject(hand_icon, getX() + Constants.HUD_WIDTH / 2, getY() + Constants.HUD_OFFSET_TOP * 10);
        world.addObject(de_timer, getX() + Constants.HUD_WIDTH / 2, getY() + Constants.HUD_OFFSET_TOP * 5);
        //bg.scale(Constants.HUD_WIDTH, room.roomArray.length * room.size);
        //setImage(bg);
    }
    
    public void act()
    {
        if (show_equip)
            hand_icon.setImage(hand_image);
        else
            hand_icon.setImage((GreenfootImage)null);
            
        hb.updateImage(player.HP, player.max_HP);
        
        GreenfootImage de_image;
        if (room.preparer.curse != null)
        {
            de_image = new GreenfootImage(200, 90);
            de_image.setFont(customFont);
            de_image.setColor(new Color(218,78,56,255));
            de_image.drawString("" + room.preparer.curse.getSeconds(), 20, 90);
        }
        else
            de_image = ((GreenfootImage)null);
        de_timer.setImage(de_image);
    }
}
