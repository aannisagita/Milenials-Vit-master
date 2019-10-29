package com.example.annisa.minimalist;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BuatDiary extends AppCompatActivity{
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2,  text3;
    Spinner sp;
    TextView txtTime;
    private int  mHour, mMinute,mDate,mMonth,mYear,menit,jam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_diary);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtTime=(EditText) findViewById(R.id.editwaktu);
        sp = (Spinner) findViewById(R.id.spinner_diary);
       //txtTime.setOnClickListener(this);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.isi_diary);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);

        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        mDate = c.get(Calendar.DATE);
        mMonth = c.get(Calendar.JUNE);
        mYear = c.get(Calendar.YEAR);
        final String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String key_isi = text1.getText().toString().trim();


                if (key_isi.isEmpty()) {
                    text1.setError("Diary is required");
                    text1.requestFocus();
                    return;
                }

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into diary(isi, feel, waktu) values('" +
                        text1.getText().toString() + "','" +
                        sp.getSelectedItem().toString() + "','" +
                        mHour+":"+mMinute+", "+mDate+" "+month+" "+mYear + "')");
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                MainActivity_Diary.ma.RefreshList();
                //masuk ke list langsung
                finish();
                //alarm();
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