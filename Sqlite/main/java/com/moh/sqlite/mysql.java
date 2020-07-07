package com.moh.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class mysql extends SQLiteOpenHelper {
    public static String DB_Name = "mydatabase.db";

    public mysql(@Nullable Context context) {
        super(context, DB_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student (id INTEGER primary key autoincrement, name text, email text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists student");
        onCreate(db);
    }

    //extends SQLiteOpenHelper
    //implement methods onCreate onUpgrade
    //add constructor


    //insert Values
    public boolean insertValues(String name, String mail) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", mail);

        long result = database.insert("student", null, values);

        if (result == -1)
            return false;
        else
            return true;
    }

    //get Values from db
    public ArrayList getValues() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery("select * from student", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String mail = cursor.getString(2);

            arrayList.add(id + " - " + name + " - " + mail);
            cursor.moveToNext();
        }
        return arrayList;
    }

    //Update Values
    public boolean updateValues(String id, String name, String mail) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", mail);
        database.update("student", values, "id=?", new String[]{id});
        return true;
    }

    //Dalete Row
    public Integer deleteRow(String id) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("student", "id=?", new String[]{id});
    }

}
