public class Curse_Effect
{
    private SimpleTimer timer;
    Entity target;
    int time = 10000;
    int addTime = 5000;
    int target_kills_prev;
    
    public Curse_Effect(Entity target)
    {
        timer = new SimpleTimer();
        this.target = target;
        target_kills_prev = target.kills;
    }
    
    public int getSeconds()
    {
        return (time - timer.millisElapsed()) / 1000;
    }
    
    public void addTime()
    {
        time += 5000;
    }
    
    public void update()
    {
        if (target_kills_prev < target.kills)
            addTime();
        if (timer.millisElapsed() > time)
            target.do_damage(2000);
        target_kills_prev = target.kills;
    }
}
