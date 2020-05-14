package com.example.tourismo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email,pass;
    Button signinButton;
    TextView loginTextView;
     FirebaseAuth mAuth;


     public void onclickSignin(View view)
     {


         Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.bounce);
         signinButton.startAnimation(animation);


         String emailstr,passstr;
         emailstr=email.getText().toString();
         passstr=pass.getText().toString();


         if(emailstr.isEmpty())
         {
             email.setError("Enter Email");
             email.requestFocus();

         }
         else if(passstr.isEmpty())
         {
             pass.setError("Enter password");
             pass.requestFocus();
         }
         else if((emailstr.isEmpty()) && (passstr.isEmpty()))
         {
             Toast.makeText(this, "Enter Info", Toast.LENGTH_SHORT).show();
         }
         else
         {
             mAuth.createUserWithEmailAndPassword(emailstr,passstr)
                     .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                             if (task.isSuccessful()) {
                                 startActivity(new Intent(MainActivity.this,HomeActivity.class));

                             }
                             else {
                                 Toast.makeText(MainActivity.this, "Not Successful", Toast.LENGTH_SHORT).show();

                             }


                         }
                     });

         }




     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mAuth = FirebaseAuth.getInstance();
        email=findViewById(R.id.emailTextView1);
        pass=findViewById(R.id.passTextView1);
        loginTextView=findViewById(R.id.signintext);
        signinButton=findViewById(R.id.loginButton);

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

    }
}
