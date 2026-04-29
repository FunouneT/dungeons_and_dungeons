public class Cell
{
    public final int x;
    public final int y;

    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int wx(int size)
    {
        return x * size + size / 2;
    }

    public int wy(int size)
    {
        return y * size + size / 2;
    }

    public static Cell fromW(int wx, int wy, int size)
    {
        return new Cell(wx / size, wy / size);
    }
}