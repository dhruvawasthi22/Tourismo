package com.example.tourismo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class aboutme extends AppCompatActivity {
    TextView appdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);
        appdetail=findViewById(R.id.textView2about);
        appdetail.setText("A mobile application that can act like a first hand guide to a tourist providing them with maps,information about numerous tourist spots,weather update and much more in a single place.\n" +"This applications that is specifically geared to limited places or Geo-locations."+"\nDeveloper: " +
                "Dhruv Awasthi \nContent: Sakshi");
    }
}
