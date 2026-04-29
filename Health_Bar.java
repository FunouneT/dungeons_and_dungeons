import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Health_Bar extends Actor
{
    GreenfootImage[] hearts;
    GreenfootImage image;
    int gap = Constants.HB_GAP;
    
    public Health_Bar(int scale)
    {
        hearts = new GreenfootImage[3];
        hearts[0] = new GreenfootImage("hud/ui_heart_empty.png");
        hearts[1] = new GreenfootImage("hud/ui_heart_half.png");
        hearts[2] = new GreenfootImage("hud/ui_heart_full.png");
        gap = gap * scale;
        for (int i = 0; i < hearts.length; i++)
            hearts[i].scale((int)(hearts[2].getWidth() * scale), (int)(hearts[2].getHeight() * scale));
    }
    
    public void updateImage(int HP, int max_HP)
    {
        image = new GreenfootImage((hearts[0].getWidth() + gap) * max_HP / 2, hearts[0].getHeight());
        int index;
        for (int i = 0; i < max_HP / 2; i++)
        {
            index = HP - ((max_HP / 2) - (i + 1)) * 2;
            if (index < 0)
                index = 0;
            if (index > 2)
                index = 2;
            image.drawImage(hearts[index], (hearts[0].getWidth() + gap) * ((max_HP / 2) - (i + 1)), 0);
        }
        setImage(image);
    }
    
    public int getWidth()
    {
        return image.getWidth();
    }
    
    public int getHeight()
    {
        return image.getHeight();
    }
}
