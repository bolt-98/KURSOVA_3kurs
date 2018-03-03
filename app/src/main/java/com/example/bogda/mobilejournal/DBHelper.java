package com.example.bogda.mobilejournal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DBSubject";
    public static final String TABLENAME = "SubjectTable";
    public static final String key_ID = "_id";
    public static final String Predmet = "Subject";




    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLENAME + "(" + key_ID + " integer primary key,"+ Predmet+" text" + ")" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLENAME);
         onCreate(db);
    }
}
