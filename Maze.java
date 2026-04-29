import java.util.*;
import java.awt.Point;

public class Maze 
{
    private final int width, height;
    public boolean[][] map;
    private final Random rand = new Random();
    public int eX, eY;

    public Maze(int width, int height, int startX, int startY) 
    {
        this.width = width;
        this.height = height;
        this.map = new boolean[width][height];
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                map[i][j] = false;
        generate(startX, startY);
    }

    private void generate(int startX, int startY) 
    {           
        int x = startX;
        int y = startY;

        map[x][y] = true;

        List<Point> to_check = new ArrayList<>();
        addNeighbors(x, y, to_check);

        while (!to_check.isEmpty())
        {
            int index = rand.nextInt(to_check.size());
            Point p = to_check.remove(index);

            int px = p.x;
            int py = p.y;
            List<Point> neighbors = new ArrayList<>();

            if (py - 2 >= 0 && map[px][py - 2]) neighbors.add(new Point(px, py - 2));
            if (py + 2 < height && map[px][py + 2]) neighbors.add(new Point(px, py + 2));
            if (px - 2 >= 0 && map[px - 2][py]) neighbors.add(new Point(px - 2, py));
            if (px + 2 < width && map[px + 2][py]) neighbors.add(new Point(px + 2, py));

            if (!neighbors.isEmpty())
            {
                Point n = neighbors.get(rand.nextInt(neighbors.size()));
                map[(px + n.x) / 2][(py + n.y) / 2] = true;
                map[px][py] = true;
                eX = px;
                eY = py;
                addNeighbors(px, py, to_check);
            }
        }
    }

    private void addNeighbors(int x, int y, List<Point> list)
    {
        if (y - 2 >= 0 && !map[x][y - 2]) list.add(new Point(x, y - 2));
        if (y + 2 < height && !map[x][y + 2]) list.add(new Point(x, y + 2));
        if (x - 2 >= 0 && !map[x - 2][y]) list.add(new Point(x - 2, y));
        if (x + 2 < width && !map[x + 2][y]) list.add(new Point(x + 2, y));
    }
}