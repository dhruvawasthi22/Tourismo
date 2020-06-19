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

public class cniActivity extends AppCompatActivity {
    ListView listView;
    TextView titleText;

    String Title[]={"Maps","Weather","Notes","About","Guide Contact"};
    int images[] ={R.drawable.maps,R.drawable.wf,R.drawable.note,R.drawable.about,R.drawable.guide};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cni);
        listView=findViewById(R.id.cniListView);



        MyAdapter adapter =new MyAdapter(this,Title,images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Toast.makeText(cniActivity.this, "Maps", Toast.LENGTH_SHORT).show();
                    Intent itomap = new Intent(cniActivity.this,cnimap.class);
                    startActivity(itomap);
                }
                if(position==1)
                {
                    Toast.makeText(cniActivity.this, "Weather", Toast.LENGTH_SHORT).show();
                    Intent itow = new Intent(cniActivity.this,cniWeather.class);
                    itow.putExtra("activity","Chennai");
                    startActivity(itow);
                }
                if(position==2)
                {
                    Toast.makeText(cniActivity.this, "Notes", Toast.LENGTH_SHORT).show();
                    Intent iton = new Intent(cniActivity.this,cniNotes.class);

                    startActivity(iton);
                }
                if(position==3)
                {
                    Toast.makeText(cniActivity.this, "About", Toast.LENGTH_SHORT).show();
                    Intent itoa = new Intent(cniActivity.this,cniAbout.class);
                    itoa.putExtra("activity","Chennai");
                    startActivity(itoa);
                }
                if(position==4)
                {
                    Toast.makeText(cniActivity.this, "Please wait for a few seconds!! Fetching data", Toast.LENGTH_SHORT).show();
                    Intent itog = new Intent(cniActivity.this,guidecontact.class);
                    itog.putExtra("activity","chennai");
                    startActivity(itog);

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
            super(c,R.layout.cnirow,R.id.titleHere,stitle);
            this.context=c;
            this.xtitle=stitle;
            this.ximage=imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               View row=layoutInflater.inflate(R.layout.cnirow,parent,false);
            ImageView imageV=row.findViewById(R.id.iconxx);
            titleText=row.findViewById(R.id.titleHere);
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
