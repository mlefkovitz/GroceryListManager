package edu.gatech.seclass.glm.dao;

import android.provider.BaseColumns;

/**
 * Created by thome127 on 10/9/16.
 */
public class DBContract {
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "glm_db";
    private DBContract() {
    }

    public static class GroceryList implements BaseColumns {
        public static final String TABLE_NAME = "grocery_list";
        public static final String COLUMN_NAME = "name";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT " + ")";
    }

    public static class Item implements BaseColumns {
        public static final String TABLE_NAME = "item";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_ITEM_TYPE_ID = "item_type_id";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME + " ("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT"
                + ", " + COLUMN_NAME + " TEXT"
                + ", " + COLUMN_DESCRIPTION + " TEXT"
                + ", "  + COLUMN_ITEM_TYPE_ID + " INTEGER"
                + ", FOREIGN KEY ("+COLUMN_ITEM_TYPE_ID+") REFERENCES "+ItemType.TABLE_NAME+"("+ItemType._ID+")"
                + ")";
    }

    public static class ItemType implements BaseColumns {
        public static final String TABLE_NAME = "item_type";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT " + ")";
    }

    public static class ListItem implements BaseColumns {
        public static final String TABLE_NAME = "list_item";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_ITEM_ID = "item_id";
        public static final String COLUMN_GROCERY_LIST_ID = "grocery_list_id";
        public static final String COLUMN_CHECKED = "item_type_id";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_QUANTITY + " INTEGER, " +
                COLUMN_CHECKED + " INTEGER DEFAULT 0, " +
                COLUMN_ITEM_ID + " INTEGER, " +
                COLUMN_GROCERY_LIST_ID + " INTEGER, "  +
                " FOREIGN KEY ("+COLUMN_ITEM_ID+") REFERENCES "+Item.TABLE_NAME+"("+Item._ID+")," +
                " FOREIGN KEY ("+COLUMN_GROCERY_LIST_ID+") REFERENCES "+GroceryList.TABLE_NAME+"("+GroceryList._ID+"))";
    }
}