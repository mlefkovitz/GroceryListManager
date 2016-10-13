package edu.gatech.seclass.glm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.glm.model.GroceryList;
import edu.gatech.seclass.glm.model.ListItem;

/**
 * Created by shazamW81 on 10/11/2016.
 */
public class ListItemDao extends SQLiteOpenHelper {

    public ListItemDao(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
        Log.d("Database created", "Database for ListItem created");
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DBContract.ListItem.CREATE_TABLE);
        Log.d("Datatable created", "Datatable for LisItems created");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBContract.ListItem.TABLE_NAME);
        onCreate(sqLiteDatabase);
        Log.d("DataDroped re-created", "Datadroped for LisItems and re-created");
    }


    // Getting single ListItem

    public ListItem getLsitItem(int id) {
        String selectQuery = "SELECT * FROM " + DBContract.ListItem.TABLE_NAME;

        // Join DBContract.Item.TABLE_NAME ON DBContract.ListItem.TABLE_NAME+"("+.ListItem.+_ID+")"= DBContract.Item.TABLE_NAME+"(".Item.+_ID")"
        // + Join DBContract.GroceryList.COLUMN_NAME ON DBContract.Item.TABLE_NAME+"(".Item.+_ID")" = DBContract.GroceryList.COLUMN_NAME+"("+GroceryList._ID+")";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null)
            cursor.moveToFirst();

        ListItem listitem = new ListItem(Long.parseLong(cursor.getString(0))+","
                +Long.parseLong(cursor.getString(1))+","+Long.parseLong(cursor.getString(2))+","
                +Integer.parseInt(cursor.getString(3))+","+Integer.parseInt(cursor.getString(4)));

        // return contact
        return listitem;
    }



    // Getting all List items

    public List<ListItem> getAllListItems() {
        List<ListItem> listItem = new ArrayList<ListItem>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + DBContract.ListItem.TABLE_NAME;

        // Join DBContract.Item.TABLE_NAME ON DBContract.ListItem.TABLE_NAME+"("+.ListItem.+_ID+")"= DBContract.Item.TABLE_NAME+"(".Item.+_ID")"
        // + Join DBContract.GroceryList.COLUMN_NAME ON DBContract.Item.TABLE_NAME+"(".Item.+_ID")" = DBContract.GroceryList.COLUMN_NAME+"("+GroceryList._ID+")";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ListItem listitem = new ListItem();
                listitem.setListItem_id(Integer.parseInt(cursor.getString(0)));
                listitem.setItem_id(Integer.parseInt(cursor.getString(1)));
                listitem.setGrocery_list_id(Integer.parseInt(cursor.getString(2)));
                listitem.setQuantity(Integer.parseInt(cursor.getString(3)));
                listitem.setChecked(Integer.parseInt(cursor.getString(4)));
                // Adding contact to list
                listItem.add(listitem);
            } while (cursor.moveToNext());
        }

        // return contact list
        return listItem;
    }

}
