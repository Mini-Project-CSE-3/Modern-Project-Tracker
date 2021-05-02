package com.tracker.pt20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button loginbtn;
    Button signupbtn;
    FirebaseAuth authfire;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        authfire = FirebaseAuth.getInstance();


        loginbtn = findViewById(R.id.Loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginPage();
            }
        });
        signupbtn = findViewById(R.id.signup);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpPage();
            }
        });
    }
    public void openLoginPage() {
        Intent intent = new Intent(this, Login_Page.class);
        startActivity(intent);
    }
    public void openSignUpPage(){
        Intent signups = new Intent(this,Signup_Page.class);
        startActivity(signups);
    }
}


































