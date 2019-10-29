package com.example.annisa.minimalist;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class Login extends AppCompatActivity  implements View.OnClickListener {

    // private static final String TAG = "login";


    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)

    FirebaseAuth mAuth;
    Button btn_login1, btn_signin0;
    EditText username, password;
    ProgressBar progressBar;
    private static final int TIME_INTERVAL = 2000; // # milliseconds, waktu diantara 2 detik ketukan back pressed
    private long mBackPressed;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        btn_login1 = findViewById(R.id.btn_login1);
        btn_signin0 = findViewById(R.id.btn_signin0);
        username = findViewById(R.id.email);
        password = findViewById(R.id.password);

        btn_login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });

        btn_signin0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                Login.this.startActivity(intent);
                Login.this.finish();
            }
        });
    }



    @Override
    public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_signin0:
                    Intent intent = new Intent(Login.this, Register.class);
                    Login.this.startActivity(intent);
                    Login.this.finish();
                    break;

                case R.id.btn_login1:
                    userLogin();
                    break;
            }

    }
    private void userLogin(){
        String usernameKey = username.getText().toString().trim();
        String passwordKey = password.getText().toString().trim();

        if (usernameKey.isEmpty()) {
            username.setError("usernameKey is required");
            username.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(usernameKey).matches()) {
            username.setError("Please enter a valid usernameKey");
            username.requestFocus();
            return;
        }

        if (passwordKey.isEmpty()) {
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

        if (password.length() < 6) {
            password.setError("Minimum lenght of password should be 6");
            password.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(usernameKey, passwordKey).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               // progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

            if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
            {
                super.onBackPressed();
                return;
            }
            else { Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show(); }

            mBackPressed = System.currentTimeMillis();
        }
}
