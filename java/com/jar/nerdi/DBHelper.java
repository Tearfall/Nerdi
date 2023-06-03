package com.jar.nerdi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase LoginDB) {
        LoginDB.execSQL("create Table users (username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase LoginDB, int i, int i1) {
        LoginDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase LoginDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = LoginDB.insert("users", null, contentValues);
        if (result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkUsername(String username){
        SQLiteDatabase LoginDB = this.getWritableDatabase();
        Cursor cursor = LoginDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if (cursor.getCount()>0){
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase LoginDB = this.getWritableDatabase();
        Cursor cursor = LoginDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});
        if(cursor.getCount()>0){
            return true;
        } else {
            return false;
        }
    }
}