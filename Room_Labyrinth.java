import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.util.*;
public class Room_Labyrinth extends Room
{   
    public Room_Labyrinth(Player player, Room_Preparer preparer)
    {
        super(Constants.R_LAB_WIDTH * Constants.R_LAB_SIZE + Constants.HUD_WIDTH, Constants.R_LAB_HEIGHT * Constants.R_LAB_SIZE, 1, player, preparer);
        this.player = player;
        roomArray = Constants.copyArray(Constants.R_LAB_MAP);
        enemy_num = Constants.R_LAB_ENEMY_NUM;
        lightMap = new Darkness[Constants.R_LAB_WIDTH][Constants.R_LAB_HEIGHT];
        size = Constants.R_LAB_SIZE;
        lightRad = Constants.R_LAB_SIZE * Constants.LIGTH_R_MULT * 1000;
        do_light = true;
        pX = Constants.R_LAB_SIZE + Constants.R_LAB_SIZE / 2;
        pY = (Constants.R_LAB_HEIGHT - 1) * Constants.R_LAB_SIZE;
    }
    
    protected void additions()
    {
        //System.out.println("additions called");
        lever = new Lever(Constants.R_LAB_SIZE);
        
        Maze maze = new Maze(Constants.R_LAB_WIDTH - 2, Constants.R_LAB_HEIGHT - 2, 0, Constants.R_LAB_HEIGHT - 3);
        //maze.map = Constants.transpose(maze.map);
        for (int x = 0; x < maze.map.length; x++) 
            for (int y = 0; y < maze.map[0].length; y++)
                if (!maze.map[x][y])
                    roomArray[x + 1][y + 2] = 15;
                    
        Cell cell = new Cell(maze.eX + 1, maze.eY + 2);
        addObject(lever, cell.wx(size), cell.wy(size));
    }
}
