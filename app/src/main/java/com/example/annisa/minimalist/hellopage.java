package com.example.annisa.minimalist;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class hellopage extends AppCompatActivity{

    ImageButton masukmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hellopage);

        masukmenu= findViewById(R.id.masukmenu);

        masukmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hellopage.this, MainActivity.class);
                hellopage.this.startActivity(intent);
                hellopage.this.finish();
            }
        });
    }
}
