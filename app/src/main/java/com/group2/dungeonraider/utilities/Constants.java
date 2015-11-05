package com.group2.dungeonraider.utilities;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Rohit on 10/27/2015.
 */
public class Constants {

    private static final String LOG = Constants.class.getSimpleName();

    // public static FPropsLoader drProps = new FPropsLoader("DRGame");

    public static int VOLUME_MODE;
    public static String THEME_MODE;
    public static int CHARACTER_SELECTED;

    public static String ITEM_POTION="POTION";
    public static String ITEM_KEY="KEY";
    public static String ITEM_BOMB="BOMB";
    public static String ITEM_MAP="MAP";
    public static int ITEM_POTION_VALUE=100;
    public static int ITEM_BOMB_VALUE=400;
    public static int ITEM_MAP_VALUE=500;
    public static int ITEM_KEY_VALUE=1200;
    public static int INITIAL_GOLD=1000;


    public static String MUTATOR_SHIRT="SHIRT";
    public static String MUTATOR_PANT="PANT";
    public static String MUTATOR_CAP="CAP";
    public static String MUTATOR_SKIN="SKIN";

    public static String COLOR_RED="RED";
    public static String COLOR_BLUE="BLUE";
    public static String COLOR_GREEN="GREEN";
    public static String COLOR_YELLOW="YELLOW";
    public static String COLOR_PINK="PINK";
    public static String COLOR_BROWN="BROWN";


    public static String PLAYER_A="bbpwa";
    public static String PLAYER_B="bbpwb";


    public static int CAP_VALUE=200;
    public static int SHIRT_VALUE=400;
    public static int PANT_VALUE=500;
    public static int SKIN_VALUE=1000;




    public static Context appContext;
    public static int SLIDE_TILE_BY_DP = 10;
    public static int GAME_LEVEL = 1;
    public static long GAME_START_TIME = System.currentTimeMillis();
    public static long LAST_TIME = 0;
    public static long DELAY_LAST_TIME = 0;
    public static boolean IS_SLOW_DOWN_TIMER = false;
    public static int TICK_COUNTER_FOR_DELAY = 0;
    public static int MAX_TICK_COUNTER_FOR_DELAY = 5;
    public static int TIME_DELAY = 0;
    public static int MAX_TIME_DELAY = 1000;
    public static long LAST_CURR_TIME = 0;
    public static MediaPlayer MP = new MediaPlayer();

    public static int GAME_NO_OF_BOMBS;
    public static int GAME_NO_OF_POTIONS;
    public static int GAME_NO_OF_KEYS;
    public static int GAME_NO_OF_MAP;

    static MediaPlayer getMediaPlayer(Context context){

        MediaPlayer MP = new MediaPlayer();

        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.KITKAT) {
            return MP;
        }

        try {
            Class<?> cMediaTimeProvider = Class.forName( "android.media.MediaTimeProvider" );
            Class<?> cSubtitleController = Class.forName( "android.media.SubtitleController" );
            Class<?> iSubtitleControllerAnchor = Class.forName( "android.media.SubtitleController$Anchor" );
            Class<?> iSubtitleControllerListener = Class.forName( "android.media.SubtitleController$Listener" );

            Constructor constructor = cSubtitleController.getConstructor(new Class[]{Context.class, cMediaTimeProvider, iSubtitleControllerListener});

            Object subtitleInstance = constructor.newInstance(context, null, null);

            Field f = cSubtitleController.getDeclaredField("mHandler");

            f.setAccessible(true);
            try {
                f.set(subtitleInstance, new Handler());
            }
            catch (IllegalAccessException e) {return MP;}
            finally {
                f.setAccessible(false);
            }

            Method setsubtitleanchor = MP.getClass().getMethod("setSubtitleAnchor", cSubtitleController, iSubtitleControllerAnchor);

            setsubtitleanchor.invoke(MP, subtitleInstance, null);
            //Log.e("", "subtitle is setted :p");
        } catch (Exception e) {}

        return MP;
    }
//    /*
//    DB details
//     */
//   /* public static String DB_NAME = drProps.getValue("db.name");
//    public static String DB_SERVER = drProps.getValue("db.server");
//    public static String DB_PORT = drProps.getValue("db.port");
//    public static String DB_PASSWORD = drProps.getValue("db.password");
//
//    /*
//    item type
//     */
//    public static String IT_KEY = drProps.getValue("it.key");
//    public static String IY_BOMB = drProps.getValue("it.bfomb");
//    public static String IT_POTION = drProps.getValue("it.potion");
//    public static String IT_MAP = drProps.getValue("it.map");
//
//    /*
//    direction
//     */
//    public static String DIR_UP = drProps.getValue("dir.up");
//    public static String DIR_DOWN = drProps.getValue("dir.down");
//    public static String DIR_LEFT = drProps.getValue("dir.left");
//    public static String DIR_RIGHT = drProps.getValue("dir.right");
//
//    /*
//    levels
//     */
//    public static String LVL_TUTORIAL = drProps.getValue("lvl.tutorial");
//    public static String LVL_EASY = drProps.getValue("lvl.easy");
//    public static String LVL_MEDIUM = drProps.getValue("lvl.medium");
//    public static String LVL_HARD = drProps.getValue("lvl.hard");
//
//    /*
//    mutator type
//     */
//    public static String MT_HAIR = drProps.getValue("mt.hair");
//    public static String MT_SKIN= drProps.getValue("mt.skin");
//    public static String MT_SHIRT = drProps.getValue("mt.shirt");
//    public static String MT_PANTS = drProps.getValue("mt.pants");
//
//    /*
//    move results
//     */
//    public static String MR_SUCCESS = drProps.getValue("mr.success");
//    public static String MR_FAILURE = drProps.getValue("mr.failure");
//    public static String MR_KEY_RECEIVED = drProps.getValue("mr.key.received");
//    public static String MR_SWITCH_ROOMS = drProps.getValue("mr.switch.rooms");
//    public static String MR_BOMB_RECEIVED = drProps.getValue("mr.cbomb.received");
//
//    /*
//    block type
//     */
//    public static String BT_EMPTY = drProps.getValue("bt.empty");
//    public static String BT_WALL = drProps.getValue("bt.wall");
//    public static String BT_SLIDING = drProps.getValue("bt.sliding");
//    public static String BT_DOOR = drProps.getValue("bt.door");
//    public static String BT_KEY = drProps.getValue("bt.key");
//    public static String BT_BREAKABLEWALL = drProps.getValue("bt.breakable.wall");
//    public static String BT_CHEST = drProps.getValue("bt.chest");
//    public static String BT_WEIGHT_SWITCH = drProps.getValue("bt.weight.switch");
//    public static String BT_FIRE = drProps.getValue("bt.fire");
//    public static String BT_SPIKE = drProps.getValue("bt.spike");
//    public static String BT_ENTRANCE_START = drProps.getValue("bt.entrance.start");
//    public static String BT_EXIT_SOLVE = drProps.getValue("bt.exit.solve");
//    public static String BT_FINISH = drProps.getValue("bt.finish");
//
//    /*
//    block state
//     */
//    public static String BS_MOVING = drProps.getValue("bs.moving");
//    public static String BS_STILL = drProps.getValue("bs.still");
//    public static String BS_OPEN_TEMPORARILY = drProps.getValue("bs.open.temporarily");
//    public static String BS_OPEN_ALWAYS = drProps.getValue("bs.open.always");
//    public static String BS_CLOSED = drProps.getValue("bs.closed");
//    public static String BS_ON = drProps.getValue("bs.on");
//    public static String BS_OFF = drProps.getValue("bs.off");

    public enum Direction {
        UP(1), DOWN(2), LEFT(3), RIGHT(4);
        private int value;

        private Direction(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    };

    public static Direction dir;
    public enum ItemType {
        KEY(1), BOMB(2), POTION(3), MAP(4);
        private int value;

        private ItemType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    };

    public enum LEVEL {
        TUTORIAL(1), EASY(2), MEDIUM(3), HARD(4);
        private int value;

        private LEVEL(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    };


    public enum MutatorType {
        HAIR(1), SHIRT(2), SKIN(3), PANTS(4);
        private int value;

        private MutatorType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    };


    public enum MoveResult {
        SUCCESS(1), FAILURE(2), KEYRECEIVED(3), BOMBRECEIVED(4),
        SWITCHROOMS(5);
        private int value;

        private MoveResult(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    };

    public enum BlockType {
        EMPTY(1), WALL(2), SLIDING(3), DOOR(4),
        KEY(5), BOMB(6), BREAKABLEWALL(7), CHEST(8),
        WEIGHTSWITCH(9), FIRE(10), SPIKE(11), ENTRANCESTART(12),
        EXITSOLVE(13), FINISH(14), DOOROPEN(15);
        private int value;

        private BlockType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    };

    public enum BlockState {
        MOVING(1), STILL(2), OPENTEPORARILY(3), OPENALWAYS(4),
        CLOSED(5), ON(6), OFF(7);
        private int value;

        private BlockState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    };

}
