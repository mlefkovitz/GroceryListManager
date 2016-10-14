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
        List<ListItem> listItem = new ArrayList<ListItem>();
        String selectQuery = "SELECT li.* FROM " + DBContract.ListItem.TABLE_NAME + " li ";
        selectQuery += " JOIN " + DBContract.Item.TABLE_NAME + " i ";
        selectQuery += " ON li." + DBContract.ListItem.COLUMN_ITEM_ID + " = i." + DBContract.Item._ID;
        selectQuery += " JOIN " + DBContract.ItemType.TABLE_NAME + " it ";
        selectQuery += " ON i." + DBContract.Item.COLUMN_ITEM_TYPE_ID + " = it." + DBContract.ItemType._ID;
        selectQuery += " WHERE li." + DBContract.ListItem.COLUMN_GROCERY_LIST_ID + " = " + grocery_list_id;
        selectQuery += " ORDER BY it." + DBContract.ItemType.COLUMN_NAME + ", i." + DBContract.Item.COLUMN_NAME;


        SQLiteDatabase db = this.getReadableDatabase();
//        onUpgrade(db,1,1);
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

    public void updateListItemQuantity(ListItem item, int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + DBContract.ListItem.TABLE_NAME +
                " SET " + DBContract.ListItem.COLUMN_QUANTITY + " = " + quantity +
                " WHERE " + DBContract.ListItem._ID + " = " + item.getId();
        db.execSQL(sql);
        db.close();
    }

    public ListItem getListItem(int id) {
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

    @NonNull
    private ListItem mapListItem(Cursor cursor) {
        ListItem listitem = new ListItem();
        listitem.setId(Integer.parseInt(cursor.getString(0)));
        listitem.setQuantity(Integer.parseInt(cursor.getString(1)));
        listitem.setChecked(Boolean.parseBoolean(cursor.getString(2)));
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
