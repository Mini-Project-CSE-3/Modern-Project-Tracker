package com.tracker.pt20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {
    Button logout;
    FirebaseAuth authfire;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        logout = findViewById(R.id.Logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent main = new Intent(Dashboard.this,MainActivity.class);
                startActivity(main);
            }
        });
    }
}
