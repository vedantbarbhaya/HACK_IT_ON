package com.example.vedantbarbhaya.swachh_bangalore;
import android.content.ContentValues; import android.content.Context; import android.database.Cursor; import android.database.sqlite.SQLiteDatabase; import android.database.sqlite.SQLiteOpenHelper;

import static android.os.Build.ID;

/**

 Created by vishalkundar on 29/09/18. */

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "HACK-IT-ON";

    public static final String TABLE_NAME = "COMPLAIN_LIST";

    public static final String COL_1 = "SL_NO";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PHONE_NO";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "COMPLAINT_ID";
    public static final String COL_6 = "LONGITUDE";
    public static final String COL_7 = "LATITUDE";
//public static final String COL_8 = "IMAGE";

    public Database (Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT , PHONE_NO TEXT , EMAIL TEXT , COMPLAINT_ID INTEGER AUTOINCREMENT , LONGITUDE DOUBLE , LATITUDE DOUBLE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("drop table if exists "+ TABLE_NAME);
        onCreate(db);
    }
    public void insertData(String name,String ph_no,String email,Double longitude,Double latitude) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, ph_no);
        contentValues.put(COL_4, email);
        contentValues.put(COL_6, longitude);
        contentValues.put(COL_7, latitude);
        db.insert(TABLE_NAME, null, contentValues);
    }
  /*  public boolean updateData(Integer value,String name,String ph_no,String email,Integer complaint_id,double longitude,double latitude)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,value);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,ph_no);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5,complaint_id);
        contentValues.put(COL_6,longitude);
        contentValues.put(COL_7,latitude);
        db.update(TABLE_NAME,contentValues,"ID = ?",new String[value]);
        return true;

    }
    */
    public Cursor getTableData( )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    }
