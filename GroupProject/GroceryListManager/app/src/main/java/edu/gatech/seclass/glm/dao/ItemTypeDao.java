package edu.gatech.seclass.glm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.glm.model.ItemType;

/**
 * Created by thome127 on 10/9/16.
 */
public class ItemTypeDao extends SQLiteOpenHelper {

    public ItemTypeDao(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DBContract.ItemType.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBContract.ItemType.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    // Adding new itemType
    public void addItemType(ItemType itemType) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.ItemType.COLUMN_NAME, itemType.getName()); // itemType Name
        // Inserting Row
        db.insert(DBContract.ItemType.TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    public List<ItemType> getItemTypes() {
        return getItemTypes(null);
    }

    // Getting All itemTypes
    public List<ItemType> getItemTypes(String name) {
        List<ItemType> itemTypeList = null;
        String selectQuery = "SELECT * FROM " + DBContract.ItemType.TABLE_NAME + " gl";

        if(name!=null) {
            selectQuery += " WHERE gl." + DBContract.ItemType.COLUMN_NAME + " like ?";
        }

        itemTypeList = new ArrayList<ItemType>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = {"%" + name + "%"};
        Cursor cursor = db.rawQuery(selectQuery, selectionArgs);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ItemType itemType = new ItemType();
                itemType.setId(Integer.parseInt(cursor.getString(0)));
                itemType.setName(cursor.getString(1));
                // Adding contact to list
                itemTypeList.add(itemType);
            } while (cursor.moveToNext());
        }

        // return contact list
        return itemTypeList;
    }
}
