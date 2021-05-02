package com.tracker.pt20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;



import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup_Page extends AppCompatActivity {
    Button submitsign;
    EditText emailid,password;
    FirebaseAuth authfire = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__page);
        emailid = findViewById(R.id.emailids);
        password = findViewById(R.id.passwords);
        submitsign = findViewById(R.id.SubmitSign);

     submitsign.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String email = emailid.getText().toString();
             String pwd;
             pwd = password.getText().toString();
             if (email.isEmpty()) {
                 emailid.setError("Please enter email id");
                 emailid.requestFocus();
             } else if (pwd.isEmpty()) {
                 password.setError("Please enter a password");
                 password.requestFocus();
             } else if (email.isEmpty() && pwd.isEmpty()) {
                 Toast.makeText(Signup_Page.this, "Fields Are Empty", Toast.LENGTH_LONG).show();
             } else if (!email.isEmpty() && !pwd.isEmpty()) {
                 Task<AuthResult> task;
                 task = authfire.createUserWithEmailAndPassword(email,pwd);
                 task.addOnCompleteListener(Signup_Page.this, new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         if (!task.isSuccessful()) {
                             Toast.makeText(Signup_Page.this, "Sorry,something went Wrong.Please, Try Again", Toast.LENGTH_LONG).show();
                         } else {
                             startActivity(new Intent(Signup_Page.this, Dashboard.class));
                         }
                     }

                 });

             }
             else {
                 Toast.makeText(Signup_Page.this, "Sign in Failed!", Toast.LENGTH_LONG).show();
             }

         }
     });
    }

    }

