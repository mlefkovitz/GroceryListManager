package edu.gatech.seclass.glm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.glm.model.GroceryList;

/**
 * Created by thome127 on 10/9/16.
 */
public class GroceryListDao extends SQLiteOpenHelper {

    public GroceryListDao(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DBContract.GroceryList.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBContract.GroceryList.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    // Adding new groceryList
    public void addGroceryList(GroceryList groceryList) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.GroceryList.COLUMN_NAME, groceryList.getName());
        db.insert(DBContract.GroceryList.TABLE_NAME, null, values);
        db.close();
    }

    // Getting All groceryLists
    public List<GroceryList> getGroceryLists(String name) {
        List<GroceryList> groceryListList = null;
        String selectQuery = "SELECT * FROM " + DBContract.GroceryList.TABLE_NAME + " gl";

        if(name!=null) {
            selectQuery += " WHERE gl." + DBContract.GroceryList.COLUMN_NAME + " like ?";
        }

        groceryListList = new ArrayList<GroceryList>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = {"%" + name + "%"};
        Cursor cursor = db.rawQuery(selectQuery, selectionArgs);
        if (cursor.moveToFirst()) {
            do {
                GroceryList groceryList = new GroceryList();
                groceryList.setId(Integer.parseInt(cursor.getString(0)));
                groceryList.setName(cursor.getString(1));
                groceryListList.add(groceryList);
            } while (cursor.moveToNext());
        }
        return groceryListList;
    }

    public void updateGroceryList(long id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + DBContract.GroceryList.TABLE_NAME +
                " SET " + DBContract.GroceryList.COLUMN_NAME + " = " + name +
                " WHERE " + DBContract.GroceryList._ID + " = " + id;
        db.execSQL(sql);
        db.close();
    }
}
