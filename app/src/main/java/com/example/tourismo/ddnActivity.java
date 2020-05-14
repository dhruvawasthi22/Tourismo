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

public class ddnActivity extends AppCompatActivity {
    ListView listView;
    TextView titleText;

    String Title[]={"Maps","Weather","Notes","About"};
    int images[] ={R.drawable.maps,R.drawable.wf,R.drawable.note,R.drawable.about};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddn);
        listView=findViewById(R.id.ddnListview);



        ddnActivity.MyAdapter adapter =new ddnActivity.MyAdapter(this,Title,images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Toast.makeText(ddnActivity.this, "Maps", Toast.LENGTH_SHORT).show();
                    Intent itomap = new Intent(ddnActivity.this,ddnmap.class);
                    startActivity(itomap);
                }
                if(position==1)
                {
                    Toast.makeText(ddnActivity.this, "Weather", Toast.LENGTH_SHORT).show();
                    Intent itow = new Intent(ddnActivity.this,cniWeather.class);
                    itow.putExtra("activity","Dehradun");
                    startActivity(itow);
                }
                if(position==2)
                {
                    Toast.makeText(ddnActivity.this, "notes", Toast.LENGTH_SHORT).show();
                    Intent itow = new Intent(ddnActivity.this,cniNotes.class);
                    //itow.putExtra("activity","Chennai");
                    startActivity(itow);
                }
                if(position==3)
                {
                    Toast.makeText(ddnActivity.this, "about", Toast.LENGTH_SHORT).show();
                    Intent itoad = new Intent(ddnActivity.this,cniAbout.class);
                    itoad.putExtra("activity","Dehradun");
                    startActivity(itoad);
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
            super(c,R.layout.ddnrow,R.id.titleHereddn,stitle);
            this.context=c;
            this.xtitle=stitle;
            this.ximage=imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.ddnrow,parent,false);
            ImageView imageV=row.findViewById(R.id.iconzz);
            titleText=row.findViewById(R.id.titleHereddn);
            imageV.setImageResource(ximage[position]);

            //Log.i("aaaaaaaaaaaaaa",xtitle[position]);

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
