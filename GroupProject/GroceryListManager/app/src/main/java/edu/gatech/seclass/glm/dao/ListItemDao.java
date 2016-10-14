package edu.gatech.seclass.glm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.glm.model.ListItem;

/**
 * Created by shazamW81 on 10/11/2016.
 */
public class ListItemDao extends SQLiteOpenHelper {
    private static ItemDao itemDao;

    public ListItemDao(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
        itemDao = new ItemDao(context);
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
        return getListItems(grocery_list_id, null);
    }

    public List<ListItem> getListItems(long grocery_list_id, String item_name) {
        List<ListItem> listItem = new ArrayList<ListItem>();
        String selectQuery = "SELECT li.* FROM " + DBContract.ListItem.TABLE_NAME + " li ";
        selectQuery += " JOIN " + DBContract.Item.TABLE_NAME + " i ";
        selectQuery += " ON li." + DBContract.ListItem.COLUMN_ITEM_ID + " = i." + DBContract.Item._ID;
        selectQuery += " JOIN " + DBContract.ItemType.TABLE_NAME + " it ";
        selectQuery += " ON i." + DBContract.Item.COLUMN_ITEM_TYPE_ID + " = it." + DBContract.ItemType._ID;
        selectQuery += " WHERE li." + DBContract.ListItem.COLUMN_GROCERY_LIST_ID + " = " + grocery_list_id;

        if (item_name != null && !item_name.isEmpty()) {
            item_name = item_name.trim();
            selectQuery += " AND i." + DBContract.Item.COLUMN_NAME + " like '%" + item_name + "%'";
        }

        selectQuery += " ORDER BY it." + DBContract.ItemType.COLUMN_NAME + ", i." + DBContract.Item.COLUMN_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ListItem listitem = mapListItem(cursor);
                listItem.add(listitem);
            } while (cursor.moveToNext());
        }
        return listItem;
    }

    public ListItem addListItem(ListItem listItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ListItem newListItem = getListItem(listItem.getGroceryListId(), listItem.getItemId());
        if (newListItem == null) {
            ContentValues values = new ContentValues();
            values.put(DBContract.ListItem.COLUMN_GROCERY_LIST_ID, listItem.getGroceryListId());
            values.put(DBContract.ListItem.COLUMN_ITEM_ID, listItem.getItemId());
            values.put(DBContract.ListItem.COLUMN_QUANTITY, listItem.getQuantity());
            values.put(DBContract.ListItem.COLUMN_CHECKED, listItem.isChecked());
            db.insert(DBContract.ListItem.TABLE_NAME, null, values);
            newListItem = getListItem(listItem.getGroceryListId(), listItem.getItemId());
        }
        db.close();
        return newListItem;
    }

    private ListItem getListItem(long groceryListId, long itemId) {
        ListItem listitem = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "Select * from " + DBContract.ListItem.TABLE_NAME +
                " WHERE " + DBContract.ListItem.COLUMN_GROCERY_LIST_ID + " = " + groceryListId +
                " AND " + DBContract.ListItem.COLUMN_ITEM_ID + " = " + itemId;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            listitem = mapListItem(cursor);
        }
        return listitem;
    }

    public void updateListItem(ListItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + DBContract.ListItem.TABLE_NAME +
                " SET " + DBContract.ListItem.COLUMN_QUANTITY + " = " + item.getQuantity() +
                " , " + DBContract.ListItem.COLUMN_CHECKED + " = " + (item.isChecked() ? 1 : 0) +
                " WHERE " + DBContract.ListItem._ID + " = " + item.getId();
        db.execSQL(sql);
        db.close();
    }

    public ListItem getListItem(long id) {
        ListItem listitem = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "Select * from " + DBContract.ListItem.TABLE_NAME +
                " WHERE " + DBContract.ListItem._ID + " = " + id;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            listitem = mapListItem(cursor);
        }
        return listitem;
    }

    public void uncheckAll(long groceryListId) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + DBContract.ListItem.TABLE_NAME +
                " SET " + DBContract.ListItem.COLUMN_CHECKED + " = " + 0 +
                " WHERE " + DBContract.ListItem.COLUMN_GROCERY_LIST_ID + " = " + groceryListId;
        db.execSQL(sql);
        db.close();
    }

    @NonNull
    private ListItem mapListItem(Cursor cursor) {
        ListItem listitem = new ListItem();
        listitem.setId(Integer.parseInt(cursor.getString(0)));
        listitem.setQuantity(Integer.parseInt(cursor.getString(1)));
        listitem.setChecked(cursor.getInt(2) == 1);
        listitem.setItemId(cursor.getLong(3));
        listitem.setItem(itemDao.getItem(cursor.getLong(3)));
        listitem.setGroceryListId(Integer.parseInt(cursor.getString(4)));
        return listitem;
    }

    public void deleteListItem(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "DELETE FROM " + DBContract.ListItem.TABLE_NAME +
                " WHERE " + DBContract.ListItem._ID + " = " + id;
        db.execSQL(sql);
        db.close();
    }
}
