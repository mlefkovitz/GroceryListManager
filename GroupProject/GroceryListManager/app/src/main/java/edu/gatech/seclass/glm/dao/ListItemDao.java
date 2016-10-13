package edu.gatech.seclass.glm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.glm.model.ListItem;

/**
 * Created by shazamW81 on 10/11/2016.
 */
public class ListItemDao extends SQLiteOpenHelper {

    public ListItemDao(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DBContract.ListItem.CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBContract.ListItem.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    // Getting all List items
    public List<ListItem> getListItems(long grocery_list_id) {
        List<ListItem> listItem = new ArrayList<ListItem>();
        String selectQuery = "SELECT * FROM " + DBContract.ListItem.TABLE_NAME + " li ";
        selectQuery += " WHERE li." + DBContract.ListItem.COLUMN_GROCERY_LIST_ID + " = " + grocery_list_id;

        // Join DBContract.Item.TABLE_NAME ON DBContract.ListItem.TABLE_NAME+"("+.ListItem.+_ID+")"= DBContract.Item.TABLE_NAME+"(".Item.+_ID")"
        // + Join DBContract.GroceryList.COLUMN_NAME ON DBContract.Item.TABLE_NAME+"(".Item.+_ID")" = DBContract.GroceryList.COLUMN_NAME+"("+GroceryList._ID+")";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ListItem listitem = new ListItem();
                listitem.setId(Integer.parseInt(cursor.getString(0)));
                listitem.setItem_id(Integer.parseInt(cursor.getString(1)));
                listitem.setGrocery_list_id(Integer.parseInt(cursor.getString(2)));
                listitem.setQuantity(Integer.parseInt(cursor.getString(3)));
                listitem.setChecked(Boolean.parseBoolean(cursor.getString(4)));
                listItem.add(listitem);
            } while (cursor.moveToNext());
        }

        // return contact list
        return listItem;
    }

    public void addListItem(ListItem listItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.ListItem.COLUMN_GROCERY_LIST_ID, listItem.getGrocery_list_id());
        values.put(DBContract.ListItem.COLUMN_ITEM_ID, listItem.getItem_id());
        values.put(DBContract.ListItem.COLUMN_QUANTITY, listItem.getQuantity());
        // Inserting Row
        db.insert(DBContract.ListItem.TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }
}
