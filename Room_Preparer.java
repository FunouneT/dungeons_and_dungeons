import greenfoot.*;
import java.util.*;

public class Room_Preparer  
{
    Player player;
    public HUD hud;
    List<Room> list;
    public Curse_Effect curse;

    public Room get_room(int room_num, Room_Preparer preparer)
    {
        if (player == null)
            player = new Player();
        if (hud == null)
            hud = new HUD(player);
        if (list == null)
            list = new ArrayList<>();
        
        if (room_num < list.size())
        {
            Room exist_room = list.get(room_num);
            exist_room.add_player(exist_room.pX, exist_room.pY);
            return exist_room;
        }
        
        Room[] rooms = {
            new Room_Default(player, preparer),
            new Room_Large(player, preparer),
            new Room_Huge(player, preparer),
            //new Room_Labyrinth(player, preparer)
        };
        
        Room room;
        
        if (room_num == 0)
            room = new Room_Start(player, preparer);
        else
            room = rooms[Greenfoot.getRandomNumber(rooms.length)];
            //room = new Room_Labyrinth(player, preparer);
        room.prepare();
        room.room_num = room_num++;
        
        return room;
    }
    
    public Room get_prev_room(int room_num)
    {
        if (room_num >= 0)
            return list.get(room_num);
        return null;
    }
}
