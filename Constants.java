public final class Constants  
{
    private Constants() {}
    
    public interface Item_Creator {
        Item create();
    }
    public record Drop_Entry(Item_Creator creator, int chance) {}
    
    //public static final record drop_pair(Class<? extends Item> item, int chance) {}
    
    //GENERAL
    public static final int ORIG_SIZE = 100;
    
    public static final int[] avail_to_step = 
    {
        0,
        11,
        14,
        15
    };
    
    //ROOMS
    public static final int R_DEFAULT_SIZE = 100;
        public static final int R_DEFAULT_WIDTH = 8;
        public static final int R_DEFAULT_HEIGHT = 8;
        public static final int R_DEFAULT_ENEMY_NUM = 1;
        public static final int[][] R_DEFAULT_MAP = {
            {6, 8, 8, 12,13,8, 8, 7 },
            {1, 3, 3, 11,14,3, 3, 2 },
            {1, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 2 }
        };
        
    public static final int R_START_SIZE = 100;
        public static final int R_START_WIDTH = 8;
        public static final int R_START_HEIGHT = 8;
        public static final int R_START_ENEMY_NUM = 0;
        public static final int[][] R_START_MAP = {
            {6, 8, 8, 12,13,8, 8, 7 },
            {1, 3, 3, 11,14,3, 3, 2 },
            {1, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 2 }
        };
        
    public static final int R_LARGE_SIZE = 80;
        public static final int R_LARGE_WIDTH = 12;
        public static final int R_LARGE_HEIGHT = 10;
        public static final int R_LARGE_ENEMY_NUM = 4;
        public static final int[][] R_LARGE_MAP = {
            {6, 8, 8, 8, 8, 12,13,8, 8, 8, 8, 7 },
            {1, 3, 3, 3, 3, 11,14,3, 3, 3, 3, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }
        };
        
    public static final int R_HUGE_SIZE = 50;
        public static final int R_HUGE_WIDTH = 20;
        public static final int R_HUGE_HEIGHT = 16;
        public static final int R_HUGE_ENEMY_NUM = 10;
        public static final int[][] R_HUGE_MAP = {
            {6, 8, 8, 8, 8, 12,13,8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7 },
            {1, 3, 3, 3, 3, 11,14,3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
        };
        
    public static final int R_LAB_SIZE = 32;
        public static final int R_LAB_WIDTH = 28;
        public static final int R_LAB_HEIGHT = 24;
        public static final int R_LAB_ENEMY_NUM = 3;
        public static final int[][] R_LAB_MAP = {
            {6, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,12,13, 8, 7 },
            {1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,11,14, 3, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }
        };
    
    //ANIMATION
    public static final int FRAMES_NUM = 4;
    public static final int PARTICLE_NUM = 20;
    
    //ENTITIES
    public static final int LIZARD_HP = 2;
        public static final int LIZARD_VEL = 1;
        public static final int LIZARD_ATTACK_CD = 60;
        public static final int LIZARD_HITTED_CD = 20;
        public static final int LIZARD_DAMAGE = 1;
        public static final Drop_Entry[] LIZARD_DROP = 
        {
            new Drop_Entry(() -> new Potion_Heal_S(null), 20),
            new Drop_Entry(() -> new Coin(null), 100)
        };
        
    public static final int SKELET_HP = 1;
        public static final int SKELET_VEL = 1;
        public static final int SKELET_STOP_DIST = 200;
        public static final int SKELET_HITTED_CD = 20;
        public static final int SKELET_ADD_FIRE_CD = 100;
        public static final Drop_Entry[] SKELET_DROP = 
        {
            new Drop_Entry(() -> new Potion_Heal_S(null), 20),
            new Drop_Entry(() -> new Coin(null), 100)
        };
        
    public static final int PLAYER_HP = 6;
        public static final int PLAYER_VEL = 6;
        public static final int PLAYER_HITTED_CD = 20;
        
    public static final int MINOTAUR_SPEED = 2;
        public static final int MINOTAUR_UPD_CD = 100;
        public static final int MINOTAUR_ATTACK_CD = 10;
        public static final int MINOTAUR_DAMAGE = 100;
        
    //ITEMS
    public static final int ITEM_BOUND = 2;
    public static final int DIST_FROM_OWNER = 50;
    
    public static final int BOW_FIRE_CD = 100;
        public static final int BOW_SPREAD = 5;
        public static final double BOW_DIFF_VALUE = 1.5;
        
    public static final int SWORD_CD = 0;
        public static final int SWORD_DAMAGE = 2;
        public static final double SWORD_DIFF_VALUE = 0.5;
        public static final int SWORD_DAMAGE_VEL = 10;
        
    public static final int AXE_DAMAGE = 3;
        public static final double AXE_DIFF_VALUE = 0.1;
        public static final int AXE_DAMAGE_VEL = 3;
        
    public static final double COIN_DIFF_VALUE = 1.5;
    
    //POTIONS
    public static final double POTION_DIFF_VALUE = 1.5;
    public static final int POTION_HEAL = 2;
    
    //PROJECTILES
    public static final int ARROW_VEL = 12;
        public static final int ARROW_DAMAGE = 1;
        
    //HUD
    public static final int HUD_WIDTH = 200;
    public static final int HB_GAP = 2;
    public static final int HB_SCALE = 4;
    public static final int HUD_OFFSET_TOP = 50;
        
    //OTHER
    public static final int LIGTH_R_MULT = 1;
    public static final int LEVER_INTERACT_CD = 50;
    public static final int DROP_CHANCE = 75;
    
    public static final int[][] copyArray(int[][] original)
    {
        int[][] copy = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++)
        {
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }
        return copy;
    }
    
    public static final int[][] transpose(int[][] original){
        int[][] transposed = new int[original[0].length][original.length];
    
        for (int y = 0; y < original.length; y++) {
            for (int x = 0; x < original[0].length; x++) {
                transposed[x][y] = original[y][x];
            }
        }
        return transposed;
    }
    
    public static final boolean[][] transpose(boolean[][] original){
        boolean[][] transposed = new boolean[original[0].length][original.length];
    
        for (int y = 0; y < original.length; y++) {
            for (int x = 0; x < original[0].length; x++) {
                transposed[x][y] = original[y][x];
            }
        }
        return transposed;
    }
}

