package com.example.tourismo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText emaillog,passlog;
    //Button logininButton;
    TextView signinTextView;
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    public void onClickLogin(View view)
    {
        String emailstr,passstr;
        emailstr=emaillog.getText().toString();
        passstr=passlog.getText().toString();

        if(emailstr.isEmpty())
        {
            emaillog.setError("Enter Email");
            emaillog.requestFocus();

        }
        else if(passstr.isEmpty())
        {
            passlog.setError("Enter password");
            passlog.requestFocus();
        }
        else if((emailstr.isEmpty()) && (passstr.isEmpty()))
        {
            Toast.makeText(this, "Enter Info", Toast.LENGTH_SHORT).show();
        }
        else
        {
           mAuth.signInWithEmailAndPassword(emailstr,passstr).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful())
                   {
                       Intent itohome= new Intent(LoginActivity.this,HomeActivity.class);
                       startActivity(itohome);
                   }
                   else
                   {
                       Toast.makeText(LoginActivity.this, "Error! Please try again", Toast.LENGTH_SHORT).show();
                   }
               }
           });

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        emaillog=findViewById(R.id.emailTextView1);
        passlog=findViewById(R.id.passTextView1);
        signinTextView=findViewById(R.id.signintext);
        authStateListener=new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser=mAuth.getCurrentUser();

                if( firebaseUser != null)
                {
                    Toast.makeText(LoginActivity.this, "You are Logged in!!!", Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(i);
                }
                else
                {
                    //Toast.makeText(LoginActivity.this, "Please sign in first!!", Toast.LENGTH_SHORT).show();
                }

            }
        };

        signinTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent isignin =new Intent(LoginActivity.this,MainActivity.class);
                startActivity(isignin);

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(authStateListener);
    }
}
