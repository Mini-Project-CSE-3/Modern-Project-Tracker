package com.tracker.pt20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Page extends AppCompatActivity {
    Button submitlog;
    EditText emailidl,passwordl;
    FirebaseAuth authfire;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page);
        authfire = FirebaseAuth.getInstance();
        emailidl = findViewById(R.id.emailidl);
        passwordl = findViewById(R.id.passwordl);
        submitlog = findViewById(R.id.submitlog);

        mAuthListener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mfire = authfire.getCurrentUser();
                if(mfire!=null){
                    Toast.makeText(Login_Page.this,"You are logged in",Toast.LENGTH_SHORT).show();
                    Intent log = new Intent(Login_Page.this,Dashboard.class);
                    startActivity(log);
                }
                 else{
                    Toast.makeText(Login_Page.this,"Please log in",Toast.LENGTH_SHORT).show();
                }
            }
        };
        submitlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailidl.getText().toString();
                String pwd = passwordl.getText().toString();
                if (email.isEmpty()) {
                    emailidl.setError("Please enter email id");
                    emailidl.requestFocus();
                } else if (pwd.isEmpty()) {
                    passwordl.setError("Please enter a password");
                    passwordl.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(Login_Page.this, "Fields Are Empty", Toast.LENGTH_LONG).show();
                } else if (!email.isEmpty() && !pwd.isEmpty()) {
                    authfire.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(Login_Page.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Login_Page.this, "Login Failed,Try Again", Toast.LENGTH_LONG).show();
                            } else {
                                 Intent dash = new Intent(Login_Page.this,Dashboard.class);
                                 startActivity(dash);
                            }
                        }

                    });

                }
                else {
                    Toast.makeText(Login_Page.this, "Sign in Failed!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
    @Override
    protected void onStart(){
        super.onStart();
        authfire.addAuthStateListener(mAuthListener);
    }
}
