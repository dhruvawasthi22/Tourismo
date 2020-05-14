package com.example.tourismo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class lkoActivity extends AppCompatActivity {

    ListView listView;
    TextView titleText;

    String Title[]={"Maps","Weather ","Notes","About"};
    int images[] ={R.drawable.maps,R.drawable.wf,R.drawable.note,R.drawable.about};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lko);
        listView=findViewById(R.id.lkoListview);

        lkoActivity.MyAdapter adapter =new lkoActivity.MyAdapter(this,Title,images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Toast.makeText(lkoActivity.this, "Maps", Toast.LENGTH_SHORT).show();
                    Intent itomap = new Intent(lkoActivity.this,lkomap.class);
                    startActivity(itomap);
                }
                if(position==1)
                {
                    Toast.makeText(lkoActivity.this, "Weather", Toast.LENGTH_SHORT).show();
                    Intent itow = new Intent(lkoActivity.this,cniWeather.class);
                    itow.putExtra("activity","Lucknow");
                    startActivity(itow);
                }
                if(position==2)
                {
                    Toast.makeText(lkoActivity.this, "notes", Toast.LENGTH_SHORT).show();
                    Intent itow = new Intent(lkoActivity.this,cniNotes.class);
                    //itow.putExtra("activity","Chennai");
                    startActivity(itow);
                }
                if(position==3)
                {
                    Toast.makeText(lkoActivity.this, "about", Toast.LENGTH_SHORT).show();
                    Intent itoal = new Intent(lkoActivity.this,cniAbout.class);
                    itoal.putExtra("activity","Lucknow");
                    startActivity(itoal);
                }
            }
        });

    }
    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String xtitle[];
        int ximage[];
        MyAdapter (Context c,String stitle[],int imgs[])
        {
            super(c,R.layout.lkorow,R.id.titleHerelko,stitle);
            this.context=c;
            this.xtitle=stitle;
            this.ximage=imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.lkorow,parent,false);
            ImageView imageV=row.findViewById(R.id.iconyy);
            titleText=row.findViewById(R.id.titleHerelko);
            imageV.setImageResource(ximage[position]);



            try {


                titleText.setText(xtitle[position]);
            }
            catch (NullPointerException ignored)
            {


            }



            return row;
        }
    }
}

