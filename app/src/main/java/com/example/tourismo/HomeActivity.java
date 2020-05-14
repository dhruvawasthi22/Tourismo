package com.example.tourismo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    Button logout;
    FirebaseAuth mAuth;
    ImageView chennaiImageview,lucknowImageview,dehradunImageview;
    private  FirebaseAuth.AuthStateListener authStateListener;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.home_menu,menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent itosignin = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(itosignin);
                return true;
            case R.id.aboutapp:
                Intent itoapp=new Intent(HomeActivity.this,aboutme.class);
                startActivity(itoapp);
                return true;

            default:
                return false;

        }

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        chennaiImageview=findViewById(R.id.myImageView1);
        lucknowImageview=findViewById(R.id.myImageView2);
        dehradunImageview=findViewById(R.id.myImageView3);

        lucknowImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itolko=new Intent(HomeActivity.this,lkoActivity.class);
                startActivity(itolko);

            }
        });

        chennaiImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itocni=new Intent(HomeActivity.this,cniActivity.class);
                startActivity(itocni);

            }
        });

        dehradunImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itoddn=new Intent(HomeActivity.this,ddnActivity.class);
                startActivity(itoddn);

            }
        });

    }
}
