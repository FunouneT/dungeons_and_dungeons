import greenfoot.*;
import java.util.*;
import java.awt.Point;

public class Minotaur extends Entity
{
    List<Cell> path = new ArrayList<>();
    int path_index;
    
    int upd_cd = Constants.MINOTAUR_UPD_CD + Greenfoot.getRandomNumber(10) - 5;
    int upd_cntr;
    
    int attack_cd = Constants.MINOTAUR_ATTACK_CD;
    int attack_cntr = 0;
    
    public Minotaur()
    {
        for (int i = 0; i < Constants.FRAMES_NUM; i++)
        {
            run_frames_r[i] = new GreenfootImage("ogre/ogre_run_anim_f" + i + ".png");
            run_frames_l[i] = new GreenfootImage(run_frames_r[i]);
            run_frames_l[i].mirrorHorizontally();
            idle_frames_r[i] = new GreenfootImage("ogre/ogre_idle_anim_f" + i + ".png");
            idle_frames_l[i] = new GreenfootImage(idle_frames_r[i]);
            idle_frames_l[i].mirrorHorizontally();
        }
        scaleWidth = 1.6;
        scaleHeight = 2.2;
        run_anim_cd = 10;
        idle_anim_cd = 15;
        hit_cd = 0;
        hitted = false;
        
        upd_cntr = upd_cd;
        
        max_HP = 1000;
        HP = max_HP;
        speed = Constants.MINOTAUR_SPEED + Greenfoot.getRandomNumber(Constants.MINOTAUR_SPEED) - Constants.MINOTAUR_SPEED / 2;
    }
    
    private int findClosestPointInPath()
    {
        int bestIndex = 0;
        double bestDist = Double.MAX_VALUE;

        for (int i = 0; i < path.size(); i++)
        {
            Cell p = path.get(i);

            int px = p.wx(room.size);
            int py = p.wy(room.size);

            double dist = Math.hypot(getX() - px, getY() - py);

            if (dist < bestDist)
            {
                bestDist = dist;
                bestIndex = i;
            }
        }

        return bestIndex;
    }
    
    public boolean update_path()
    {
        Cell t = Cell.fromW(room.player.getX(), room.player.getY(), room.size);
        try {
        if (room.roomArray[t.x][t.y] != 0)
            return false;
        
        Cell s = Cell.fromW(getX(), getY(), room.size);
        
        int w = room.roomArray.length;
        int h = room.roomArray[0].length;

        boolean[][] visited = new boolean[w][h];
        Cell[][] parent = new Cell[w][h];

        Queue<Cell>q = new LinkedList<>();
        q.add(new Cell(s.x, s.y));
        visited[s.x][s.y] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!q.isEmpty())
        {
            Cell p = q.poll();

            if (p.x == t.x && p.y == t.y)
                break;

            for (int i = 0; i < 4; i++)
            {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < w && ny < h)
                {
                    if (!visited[nx][ny] && room.roomArray[nx][ny] == 0)
                    {
                        visited[nx][ny] = true;
                        parent[nx][ny] = p;
                        q.add(new Cell(nx, ny));
                    }
                }
            }
        }
        
        path = new ArrayList<>();

        Cell cur = new Cell(t.x, t.y);
        if (parent[t.y][t.x] == null)
            path.clear();
    
        while (cur != null)
        {
            path.add(cur);
            cur = parent[cur.x][cur.y];
        }

        Collections.reverse(path);
        path_index = findClosestPointInPath();
        
        return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private void move_to_player()
    {
        if (path == null || path_index >= path.size())
            return;

        Cell next = path.get(path_index);

        int targetX = next.wx(room.size);
        int targetY = next.wy(room.size);

        double dx = targetX - realX;
        double dy = targetY - realY;
        
        double distance = Math.sqrt(dx * dx + dy * dy);
        
        if (distance > room.size / 2)
        {
            realX += (dx / distance) * curr_speed;
            realY += (dy / distance) * curr_speed;
        }
        else
            path_index++;
            
        setLocation(realX, realY - offsetY);
    }
    
    protected final void check_death()
    {
        if (HP <= 0)
        {
            for (int i = 0; i < Constants.PARTICLE_NUM * 2; i++)
                room.addObject(new Particle(room.size * 2), getX(), getY());
            if (item != null)
                getWorld().removeObject(item);
            getWorld().removeObject(this);
        }
    }
    
    private boolean intersect_player()
    {
        if (getX() - room.size / 2 < room.player.getX() && getX() + room.size / 2 > room.player.getX())
            if (getY() - offsetY - room.size / 2 < room.player.getY() && getY() - offsetY + room.size / 2 > room.player.getY())
                return true;
        return false;
    }

    public void act()
    {
        upd_cntr++;
        if (upd_cntr > upd_cd)
        {
            if (update_path())
                upd_cntr = 0;
        }

        if (room.player != null)
        {
            move_to_player();
            if (intersect_player())
            {
                if (attack_cntr > attack_cd)
                {
                    room.player.do_damage(Constants.MINOTAUR_DAMAGE);
                    attack_cntr = 0;
                }
            }
            attack_cntr++;
        }
        animating();
        
        if (room.lever.active)
            do_damage(1001);
        
        check_death();
    }
}
