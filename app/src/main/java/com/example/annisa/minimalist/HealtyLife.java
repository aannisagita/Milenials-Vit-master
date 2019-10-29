package com.example.annisa.minimalist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HealtyLife extends AppCompatActivity {

    Button relax, healtyfood, workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healty_life);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        workout= findViewById(R.id.workout);
        healtyfood= findViewById(R.id.healtyfood);
        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealtyLife.this, MapsActivity_Workout.class);
               HealtyLife.this.startActivity(intent);
            }
        });



        healtyfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealtyLife.this,MapsActivity_Food.class);
                HealtyLife.this.startActivity(intent);
            }
        });

    }
}
