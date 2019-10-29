package com.example.annisa.minimalist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateHabit extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_habit);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //mendapatkan nilai id yang dipilih dengan key "id_habit"
        Intent intent = getIntent();
        final int id_habit = intent.getExtras().getInt("id_habit");

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.update_nama_habit);
        text2 = (EditText) findViewById(R.id.update_deskripsi_habit);
        text3 = (EditText) findViewById(R.id.update_waktu_habit);
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
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        // daftarkan even onClick pada btnSimpan
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String key_nama = text1.getText().toString().trim();
                String key_deskripsi =text2.getText().toString().trim();
                String key_waktu = text3.getText().toString().trim();

                if (key_nama.isEmpty()) {
                    text1.setError("habit name is required");
                    text1.requestFocus();
                    return;
                }


                if (key_deskripsi.isEmpty()) {
                    text2.setError("Description is required");
                    text2.requestFocus();
                    return;
                }
                if (key_waktu.isEmpty()) {
                    text3.setError("Time is required");
                    text3.requestFocus();
                    return;
                }
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update habit set nama = '" + text1.getText().toString() +
                        "',deskripsi ='" + text2.getText().toString() +
                        "',waktu ='" + text3.getText().toString() +
                        "' where id = '"+id_habit+"'");
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                MainActivity_Habit.ma.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }



}