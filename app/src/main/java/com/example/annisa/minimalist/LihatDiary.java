package com.example.annisa.minimalist;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LihatDiary extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;

    TextView text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_diary);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //mendapatkan nilai id yang dipilih dengan key "id_diary"
        Intent intent = getIntent();
        int id_diary = intent.getExtras().getInt("id_diary");

        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.timestamp_diary);
        text2 = (TextView) findViewById(R.id.deskripsi_diary);
        text3 = (TextView) findViewById(R.id.perasaan_diary);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM diary WHERE id = '" +
                id_diary+ "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text1.setText(cursor.getString(3).toString());
        }

    }



}