package edu.gatech.seclass.glm.dao;

import android.provider.BaseColumns;

/**
 * Created by thome127 on 10/9/16.
 */
public class DBContract {
    public static final int DATABASE_VERSION = 1;
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
}
