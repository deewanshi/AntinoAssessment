package com.example.deewanshigrover.sqlcrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DEEWANSHI GROVER on 13-10-2018.
 */

public class MyDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="student.db";
    private static final String TABLE_NAME="student";
    private static final String COL_1="ID";
    private static final String COL_2="ROLL";
    private static final String COL_3="NAME";
    private static final String COL_4="SURNAME";
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+TABLE_NAME+" "+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,ROLL TEXT,NAME TEXT,SURNAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }


    public boolean isInsert(String roll,String name,String surName){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,roll);
        contentValues.put(COL_3,name);
        contentValues.put(COL_4,surName);
        long l = database.insert(TABLE_NAME,null,contentValues);
        if (l == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getAllData()
    {

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor result= sqLiteDatabase.rawQuery("Select * from "+TABLE_NAME,null);
        return result;
    }


    public boolean isUpdate(String id,String roll,String name,String surName)
    {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,roll);
        contentValues.put(COL_3,name);
        contentValues.put(COL_4,surName);

        database.update(TABLE_NAME,contentValues,"ID=?",new String[]{id});
        return true;

    }

    public int deleteData(String id)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        return database.delete(TABLE_NAME,"ID=?",new  String[]{id});
    }

}
