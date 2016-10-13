package edu.gatech.seclass.glm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.glm.model.Item;

public class ItemDao extends SQLiteOpenHelper {
    public static final String[] DEFAULT_ITEM = {"Apples", "Bananas", "Beef", "Chicken", "Candy", "Nuts"};
    private static ItemTypeDao itemTypeDao;

    public ItemDao(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
        itemTypeDao = new ItemTypeDao(context);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DBContract.Item.CREATE_TABLE);
        for (String type : DEFAULT_ITEM) {
            Item item = new Item();
            item.setName(type);
            item.setItemTypeId(itemTypeDao.getRandomType().getId());
            addItem(item);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBContract.Item.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    // Adding new items
    public void addItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        Item newItem = getItem(item.getName());
        if (newItem == null) {
            ContentValues values = new ContentValues();
            values.put(DBContract.Item.COLUMN_NAME, item.getName());
            values.put(DBContract.Item.COLUMN_ITEM_TYPE_ID, item.getItemTypeId());
            db.insert(DBContract.Item.TABLE_NAME, null, values);
        }
        db.close();
    }

    public List<Item> getItems() {
        return getItems(null);
    }

    // Getting All items
    public List<Item> getItems(String name) {
        List<Item> itemList = null;
        String selectQuery = "SELECT * FROM " + DBContract.Item.TABLE_NAME + " i";
        selectQuery += " JOIN " + DBContract.ItemType.TABLE_NAME + " it ";
        selectQuery += " ON i." + DBContract.Item.COLUMN_ITEM_TYPE_ID + " = it." + DBContract.ItemType._ID;

        if(name!=null) {
            selectQuery += " WHERE i." + DBContract.Item.COLUMN_NAME + " like ?";
        }
        selectQuery += " ORDER BY it." + DBContract.ItemType.COLUMN_NAME + ", i." + DBContract.Item.COLUMN_NAME;

        itemList = new ArrayList<Item>();
        SQLiteDatabase db = this.getReadableDatabase();
//        onUpgrade(db,1,1);
        String[] selectionArgs = {"%" + name + "%"};
        Cursor cursor = db.rawQuery(selectQuery, selectionArgs);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setId(Integer.parseInt(cursor.getString(0)));
                item.setName(cursor.getString(1));
                long itemTypeId = cursor.getLong(3);
                item.setItemTypeId(itemTypeId);
                item.setItemType(itemTypeDao.getItemType(itemTypeId));
                itemList.add(item);
            } while (cursor.moveToNext());
        }

        // return contact list
        return itemList;
    }

    public Item getItem(String name) {
        Item result = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "Select * from " + DBContract.Item.TABLE_NAME +
                " WHERE " + DBContract.Item.COLUMN_NAME + " = ?";
        String[] selectionArgs = {name};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.moveToFirst()) {
            result = new Item();
            result.setId(cursor.getLong(0));
            result.setName(cursor.getString(1));
            long itemTypeId = cursor.getLong(3);
            result.setItemTypeId(itemTypeId);
            result.setItemType(itemTypeDao.getItemType(itemTypeId));
        }
        return result;
    }

    public Item getItem(long id) {
        Item result = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "Select * from " + DBContract.Item.TABLE_NAME +
                " WHERE " + DBContract.Item._ID + " = " + id;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            result = new Item();
            result.setId(cursor.getLong(0));
            result.setName(cursor.getString(1));
            long itemTypeId = cursor.getLong(3);
            result.setItemTypeId(itemTypeId);
            result.setItemType(itemTypeDao.getItemType(itemTypeId));
        }
        return result;
    }
}
