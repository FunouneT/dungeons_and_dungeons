import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Room extends World
{
   public Room_Preparer preparer;
   public Player player;
   protected int pX, pY;
   
   protected int enemy_num;
   protected Entity[] enemies;
   public int room_num;
   
   public int size;
   protected Darkness[][] lightMap;
   protected int[][] roomArray;
   protected int lightRad;
   
   boolean do_light = true;
   
   public Lever lever;
   
   protected int lastX, lastY;
    
    public Room(int width, int height, int size, Player player, Room_Preparer preparer)
    {
        super(width, height, size);
        //this.player = player;
        this.preparer = preparer;
        
        setPaintOrder(
        HUD.class,
        Darkness.class,
        Player.class,
        Projectile.class,
        Particle.class,
        Entity.class,
        Lever.class,
        Item.class,
        Tile_floor.class,
        Tile_wall.class,
        Tile_door.class
        );
    }
    
    protected final Entity get_enemy()
    {
        if (this.getClass() == Room_Labyrinth.class)
        {
            //System.out.println("this room is maze");
            return new Minotaur();
        }
        Enemy[] enemy = {
            new Skelet(),
            new Lizard()
        };
        return enemy[Greenfoot.getRandomNumber(enemy.length)];
    }
    
    public final void set_enemies()
    {
        enemies = new Entity[enemy_num];
        for (int i = 0; i < enemy_num; i++)
        {
            enemies[i] = get_enemy();
        }
    }
    
   public final void prepare()
    {
        roomArray = Constants.transpose(roomArray);
        //lightMap = Constants.transpose(lightMap);
        
        addObject(preparer.hud, roomArray.length * size, 0);
        
        additions();
        
        set_enemies();
        
        for (int x = 0; x < lightMap.length; x++) {
            for (int y = 0; y < lightMap[x].length; y++) {
                lightMap[x][y] = new Darkness(size, 200);
                Cell cell = new Cell(x, y);
                addObject(lightMap[x][y], cell.wx(size), cell.wy(size));
            }
        }  
        Tile_door[] door_parts = new Tile_door[4];
        
        for (int x = 0; x < roomArray.length; x++) {
            for (int y = 0; y < roomArray[x].length; y++) {
                Cell cell = new Cell(x, y);
                if (roomArray[x][y] == 0)
                    addObject(new Tile_floor(size), cell.wx(size), cell.wy(size));
                else if (roomArray[x][y] >= 1 && roomArray[x][y] <= 8)
                    addObject(new Tile_wall(roomArray[x][y], size), cell.wx(size), cell.wy(size));
                else if (roomArray[x][y] >= 11 && roomArray[x][y] <= 14)
                {
                    door_parts[roomArray[x][y] - 11] = new Tile_door(roomArray[x][y], size);
                    addObject(door_parts[roomArray[x][y] - 11], cell.wx(size), cell.wy(size));
                }
                else if (roomArray[x][y] == 15)
                    addObject(new Tile_spikes(size), cell.wx(size), cell.wy(size));
            }
        }
        
        door_parts[0].set_other_parts(door_parts[1], door_parts[2], door_parts[3]);
        door_parts[1].set_other_parts(door_parts[0], door_parts[2], door_parts[3]);
        door_parts[2].set_other_parts(door_parts[0], door_parts[1], door_parts[3]);
        door_parts[3].set_other_parts(door_parts[0], door_parts[1], door_parts[2]);
        
        add_player(pX, pY);
        
        for (int i = 0; i < enemies.length; i++)
        {
            Cell cell = new Cell(Greenfoot.getRandomNumber(roomArray.length), Greenfoot.getRandomNumber(roomArray[0].length));
            while (roomArray[cell.x][cell.y] != 0)
                cell = new Cell(Greenfoot.getRandomNumber(roomArray.length), Greenfoot.getRandomNumber(roomArray[0].length));
            addObject(enemies[i], cell.wx(size), cell.wy(size));
        }
        
        preparer.list.add(this);
    }
    
    protected abstract void additions();
    
    public void add_player(int x, int y)
    {
        if (player.getWorld() != null)
            player.getWorld().removeObject(player);
        addObject(player, x, y);
    }
    
    //public Cell get_door_cell()
    //{
    //    for (int x = 0; x < roomArray.length; x++)
    //        for (int y = 0; y < roomArray[x].length; y++)
    //            if (roomArray[x][y] == 1)
    //                return new Cell(x, y);
    //    return new Cell(0, 0);
    //}

    public boolean have_wall(int x, int y)
    {
        Cell cell = Cell.fromW(x, y, size);
        if (x <= 0 || x >= getWidth() || y <= 0 || y >= getHeight() - size / 2)
            return true;
        if (roomArray[cell.x][cell.y] >= 1 && roomArray[cell.x][cell.y] <= 8)
            return true;
        if (roomArray[cell.x][cell.y] == 12 || roomArray[cell.x][cell.y] == 13)
            return true;
        return false;
    }
    
    public boolean have_floor(int x, int y)
    {
        Cell cell = Cell.fromW(x, y + size/2, size);
        if (cell.x > roomArray.length || cell.y + 1 > roomArray[0].length || cell.x < 0 || cell.y < 0)
            return false;
        for (int i = 0; i < Constants.avail_to_step.length; i++)
            if (roomArray[cell.x][cell.y] == Constants.avail_to_step[i])
                return true;
        return false;
    }
    
    public void next_room()
    {
        lastX = player.getX();
        lastY = player.getY();
        Room new_room = preparer.get_room(room_num+1, preparer);
        for (int i = 0; i < 4; i++) {
            for (int x = 0; x < lightMap.length; x++) {
                for (int y = 0; y < lightMap[x].length; y++) {
                    lightMap[x][y].setTP(lightMap[x][y].getTP() + 50);
                }
            }
            Greenfoot.delay(10);
        }
        
        Greenfoot.setWorld(new_room);
    }
    
    public void prev_room()
    {
        Room prev_room = preparer.get_prev_room(room_num-1);
        if (prev_room != null)
        {
        for (int i = 0; i < 4; i++) {
            for (int x = 0; x < lightMap.length; x++) {
                for (int y = 0; y < lightMap[x].length; y++) {
                    lightMap[x][y].setTP(lightMap[x][y].getTP() + 50);
                }
            }
            Greenfoot.delay(10);
        }
        Greenfoot.setWorld(prev_room);
        prev_room.add_player(prev_room.lastX, prev_room.lastY + size);
        }
    }
    
    public final void act()
    {
        if (player != null)
        {
            if (preparer.curse != null)
            {
                preparer.curse.update();
                //showText("death timer: " + preparer.curse.getSeconds(), 200, 200);
            }
            if (do_light)
            {
                for (int x = 0; x < lightMap.length; x++) {
                    for (int y = 0; y < lightMap[x].length; y++) {
                        Cell cell = new Cell(x, y);
                        if ((Math.pow(cell.wx(size) - player.getX(), 2) + Math.pow(cell.wy(size) - player.getY(), 2)) < Math.pow(lightRad, 2))
                            lightMap[x][y].setTP(0);
                        else if ((Math.pow(cell.wx(size) - player.getX(), 2) + Math.pow(cell.wy(size) - player.getY(), 2)) < Math.pow(lightRad * 3, 2))
                            lightMap[x][y].setTP(50);
                        else if ((Math.pow(cell.wx(size) - player.getX(), 2) + Math.pow(cell.wy(size) - player.getY(), 2)) < Math.pow(lightRad * 4, 2))
                            lightMap[x][y].setTP(100);
                        else
                            lightMap[x][y].setTP(200);
                    }
                }
            }
            
            if (pX - size / 2 < player.getX() && pX + size / 2 > player.getX())
                if (pY < player.getY() && pY + size/2 > player.getY())
                {
                    prev_room();
                }
        }
    }
}
