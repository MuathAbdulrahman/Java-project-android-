package com.example.project;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String desc , String Quantity) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.ITEM, name);
        contentValue.put(DatabaseHelper.PRICE, desc);
        contentValue.put(DatabaseHelper.Quantity, Quantity);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }



    public int update(String _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        //contentValues.put(DatabaseHelper.ITEM, name);
        //contentValues.put(DatabaseHelper.PRICE, desc);
        contentValues.put(DatabaseHelper.Quantity, desc);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }


}