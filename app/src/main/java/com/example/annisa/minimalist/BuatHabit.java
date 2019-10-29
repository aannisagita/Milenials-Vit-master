package com.example.annisa.minimalist;



import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

import android.widget.TimePicker;
import android.app.TimePickerDialog;

public class BuatHabit extends AppCompatActivity implements View.OnClickListener{
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2,  text3;
    Button btnTimePicker;
    TextView txtTime;
    private int  mHour, mMinute,menit,jam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_habit);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtTime=(EditText) findViewById(R.id.editwaktu);

       txtTime.setOnClickListener(this);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editwaktu);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);

        buathabit();
    }


    @Override
    public void onClick(View v) {

        //time picker
            // Get Current Time

            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);
            //Log.d("myTag", "This is my message");
            // Launch Time Picker Dialog

            final TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);

                             menit = (minute);
                             jam = (hourOfDay);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
    }

    public void alarm(){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MINUTE,menit); //set menit noit
        cal.set(Calendar.HOUR_OF_DAY, jam);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);
    }

    public void buathabit(){

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
                db.execSQL("insert into habit(nama, deskripsi, waktu) values('" +
                        text1.getText().toString() + "','" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();



                alarm();
                startActivity(new Intent(BuatHabit.this, MainActivity_Habit.class));
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