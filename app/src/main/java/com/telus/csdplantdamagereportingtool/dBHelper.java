package com.telus.csdplantdamagereportingtool;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chad on 12/03/16.
 */

public class dBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "plant.db";
    public static final String TABLE_NAME = "damage";
    public static final String COL_1 = "id";
    public static final String COL_2 = "Tid";
    public static final String COL_3 = "datetime";
    public static final String COL_4 = "Region";
    public static final String COL_5 = "CLLI";
    public static final String COL_6 = "damageType";
    public static final String COL_7 = "lat";
    public static final String COL_8 = "lng";
    public static final String COL_9 = "comments";
    public static final String COL_10 = "photoLocation";

    public dBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + "TEXT ," +
                COL_3 + "DATETIME, " +
                COL_4 + "INTEGER, " +
                COL_5 + "INTEGER, " +
                COL_6 + "INTEGER, " +
                COL_7 + "FLOAT, " +
                COL_8 + "FLOAT, " +
                COL_9 + "TEXT, " +
                COL_10 + "TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String Tid, String datetime, int region, int CLLI, int damageType, String lat, String lng, String text, String picLocation) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, Tid);
        contentValues.put(COL_3, datetime);
        contentValues.put(COL_4, region);
        contentValues.put(COL_5, CLLI);
        contentValues.put(COL_6, damageType);
        contentValues.put(COL_7, lat);
        contentValues.put(COL_8, lng);
        contentValues.put(COL_9, text);
        contentValues.put(COL_10, picLocation);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}
