package com.example.annisa.minimalist;




import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habit.db";
    private static final int DATABASE_VERSION = 2;
    public static final String TABLE_HABIT = "habit";
    public static final String TABLE_DIARY = "diary";
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql_habit = "create table habit(id integer primary key, nama text null, deskripsi text null, waktu time null);";
        Log.d("Data", "onCreate: " + sql_habit);
        String sql_diary = "create table diary(id integer primary key, isi text null, feel text,waktu text null);";
        Log.d("Data", "onCreate: " + sql_diary);
        db.execSQL(sql_habit);
        db.execSQL(sql_diary);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_HABIT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_DIARY);
        onCreate(db);
    }

}