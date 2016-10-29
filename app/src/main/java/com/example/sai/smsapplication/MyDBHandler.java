package com.example.sai.smsapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by sai on 10/29/2016.
 */
public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "messages.db";
    private static final String TABLE_NAME = "messages";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PHONENUMBER = "phonenumber";
    private static final String COLUMN_MESSAGE = "message";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_STATUS = "status";

    public MyDBHandler(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context,DATABASE_NAME,factory,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_PHONENUMBER + " TEXT ," +
                COLUMN_MESSAGE + " TEXT ," +
                COLUMN_TIME + " TEXT ," +
                COLUMN_STATUS + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    public void addMessage(UserMessages msg) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_MESSAGE,msg.get_message());
        values.put(COLUMN_PHONENUMBER,msg.get_mobileNo());
        values.put(COLUMN_TIME,msg.get_time());
        values.put(COLUMN_STATUS,msg.get_status());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<UserMessages> msgtoString(){
        ArrayList<UserMessages> al = new ArrayList<UserMessages>();
        UserMessages usmsg = new UserMessages();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + "WHERE 1";
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("phonenumber")) != null){
                usmsg.set_mobileNo(c.getString(c.getColumnIndex("phonenumber")));
                usmsg.set_message(c.getString(c.getColumnIndex("message")));
                usmsg.set_time(c.getString(c.getColumnIndex("time")));
                usmsg.set_status(c.getString(c.getColumnIndex("status")));
            }
            al.add(usmsg);

        }
        return al;
    }
}

