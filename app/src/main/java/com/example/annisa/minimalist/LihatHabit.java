package com.example.annisa.minimalist;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LihatHabit extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    TextView text1, text2, text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_habit);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //mendapatkan nilai id yang dipilih dengan key "id_habit"
        Intent intent = getIntent();
        int id_habit = intent.getExtras().getInt("id_habit");

        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.nama_habit);
        text2 = (TextView) findViewById(R.id.deskripsi_habit);
        text3 = (TextView) findViewById(R.id.waktu_habit);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM habit WHERE id = '" +
                id_habit+ "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(1).toString());
            text2.setText(cursor.getString(2).toString());
            text3.setText(cursor.getString(3).toString());

        }

    }



}