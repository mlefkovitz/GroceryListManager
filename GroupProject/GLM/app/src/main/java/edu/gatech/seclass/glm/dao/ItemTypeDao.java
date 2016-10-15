package edu.gatech.seclass.glm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.gatech.seclass.glm.model.ItemType;

/**
 * Created by thome127 on 10/9/16.
 */
public class ItemTypeDao extends SQLiteOpenHelper {
    public static final String[] DEFAULT_ITEM_TYPES = {"Dairy", "Cereals", "Meat"};

    public ItemTypeDao(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
        for (String type : DEFAULT_ITEM_TYPES) {
            ItemType itemType = new ItemType();
            itemType.setName(type);
            addItemType(itemType);
        }
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

    public void addItemType(ItemType itemType) {
        SQLiteDatabase db = this.getWritableDatabase();
        if (getItemType(itemType.getName()) == null) {
            ContentValues values = new ContentValues();
            values.put(DBContract.ItemType.COLUMN_NAME, itemType.getName());
            db.insert(DBContract.ItemType.TABLE_NAME, null, values);
        }
        db.close();
    }

    public List<ItemType> getItemTypes() {
        return getItemTypes("");
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
                itemTypeList.add(itemType);
            } while (cursor.moveToNext());
        }

        // return contact list
        return itemTypeList;
    }

    public ItemType getItemType(String name) {
        ItemType result = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "Select * from " + DBContract.ItemType.TABLE_NAME +
                " WHERE " + DBContract.ItemType.COLUMN_NAME + " = ?";
        String[] selectionArgs = {name};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.moveToFirst()) {
            result = new ItemType();
            result.setId(cursor.getLong(0));
            result.setName(cursor.getString(1));
        }
        return result;
    }

    public ItemType getItemType(long id) {
        ItemType result = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "Select * from " + DBContract.ItemType.TABLE_NAME +
                " WHERE " + DBContract.ItemType._ID + " = ?";
        String[] selectionArgs = {"" + id};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.moveToFirst()) {
            result = new ItemType();
            result.setId(cursor.getLong(0));
            result.setName(cursor.getString(1));
        }
        return result;
    }

    public ItemType getRandomType() {
        Random randomGenerator = new Random();
        List<ItemType> itemTypeList = getItemTypes();
        int index = randomGenerator.nextInt(itemTypeList.size());
        return itemTypeList.get(index);
    }
}
