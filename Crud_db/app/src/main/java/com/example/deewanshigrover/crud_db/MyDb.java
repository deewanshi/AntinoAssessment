package com.example.deewanshigrover.crud_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DEEWANSHI GROVER on 25-07-2018.
 */

public class MyDb extends SQLiteOpenHelper {
    private static final String Db_name="student.db";
    private static final String Tb_name="student";
    private static final String COL_1="ID";
    private static final String COL_2="Roll";
    private static final String COL_3="Name";
    private static final String COL_4="LastName";

    public MyDb(Context context) {
        super(context, Db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Tb_name+" "+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,Roll TEXT,Name TEXT,LastName TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Tb_name);
        onCreate(db);

    }
    public boolean isInsert(String roll,String name,String sname)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,roll);
        contentValues.put(COL_3,name);
        contentValues.put(COL_4,sname);

        long res=database.insert(Tb_name,null,contentValues);
        if(res==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getAllData()
    {
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor result=database.rawQuery("select * from "+Tb_name,null);
        return result;
    }
    public boolean isUpdate(String id,String roll,String name,String sname)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,roll);
        contentValues.put(COL_3,name);
        contentValues.put(COL_4,sname);
        database.update(Tb_name,contentValues,"ID=?",new String[]{id});
        return true;
    }

    public Integer deleteData(String id)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        return database.delete(Tb_name,"ID=?",new String[]{id});
    }


}
