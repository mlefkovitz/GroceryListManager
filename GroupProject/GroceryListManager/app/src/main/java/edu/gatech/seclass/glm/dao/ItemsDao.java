package edu.gatech.seclass.glm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.glm.model.Item;

public class ItemsDao extends SQLiteOpenHelper {

    private static final String TAG = ItemsDao.class.getSimpleName();

    public ItemsDao(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DBContract.Item.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBContract.Item.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    // Adding new items
    public void addItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.Item.COLUMN_NAME, item.getName()); // item Name
        // Inserting Row
        db.insert(DBContract.Item.TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    public List<Item> getItems() {
        return getItems(null);
    }

    // Getting All items
    public List<Item> getItems(String name) {
        List<Item> itemList = null;
        String selectQuery = "SELECT * FROM " + DBContract.Item.TABLE_NAME + " i";

        if(name!=null) {
            selectQuery += " WHERE i." + DBContract.Item.COLUMN_NAME + " like ?";
        }

        itemList = new ArrayList<Item>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = {"%" + name + "%"};
        Cursor cursor = db.rawQuery(selectQuery, selectionArgs);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setId(Integer.parseInt(cursor.getString(0)));
                item.setName(cursor.getString(1));
                // Adding contact to list
                itemList.add(item);
            } while (cursor.moveToNext());
        }

        // return contact list
        return itemList;
    }
}
