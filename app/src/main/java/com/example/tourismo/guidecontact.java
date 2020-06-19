package com.example.tourismo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class guidecontact extends AppCompatActivity {
    ListView listView;
    TextView nameList,infoList;
    String guideslist[]=new String[100];
    String infolist[]=new String[100];
    int i=0;
    String value,value2,value3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidecontact);
        Intent intent = getIntent();
        final String city = intent.getStringExtra("activity");
        listView=findViewById(R.id.guideListView);
        final MyAdapter adapter =new guidecontact.MyAdapter(this,guideslist,infolist);
        listView.setAdapter(adapter);

        @IgnoreExtraProperties
         class Message {

            public String name;
            public String rating;
            public String num;

            public Message() {
                // Default constructor required for calls to DataSnapshot.getValue(Post.class)
            }

            public Message(String gn, String gr, String gnum) {
                this.name = gn;
                this.rating = gr;
                this.num = gnum;
            }

            @Exclude
            public Map<String, Object> toMap() {
                HashMap<String, Object> result = new HashMap<>();
                result.put("name", name);
                result.put("rating", rating);
                result.put("number", num);

                return result;
            }
        }

        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mDbRef = mDatabase.getReference();

        mDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                long val=dataSnapshot.getChildrenCount();
                try {
                    long j;
                    for ( j = 1; j <= val; j++) {
                        String jj=Long.toString(j);

                         value = dataSnapshot.child(city).child(jj).child("name").getValue().toString();
                         value2 = dataSnapshot.child(city).child(jj).child("rating").getValue().toString();
                        value3 = dataSnapshot.child(city).child(jj).child("number").getValue().toString();

                        guideslist[i] ="Name- "+ value;
                        infolist[i] = "Rating- "+value2 + " Ph. number -" + value3;
                        i++;
                        Log.i("XXXXXXXXXXXXXXXXXXXXXXX",value+" XXXXXxxx "+value2+"XXXXXXXXX"+value3);
                    }


                }
                catch (Exception e)
                {
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError error) {
                //Failed to read value
                  Log.w("XXXXXXXXXXXXXXX", "Failed to read value.", error.toException());
            }
        });
    }
    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String xname[];
        String xinfo[];
        MyAdapter (Context c,String sname[],String sinfo[])
        {
            super(c,R.layout.guiderow,R.id.namehere,sname);
            this.context=c;
            this.xname=sname;
            this.xinfo=sinfo;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.guiderow,parent,false);

            nameList=row.findViewById(R.id.namehere);
            infoList=row.findViewById(R.id.infohere);


            try {
                nameList.setText(xname[position]);
                infoList.setText(xinfo[position]);
            }
            catch (NullPointerException ignored)
            {
            }
            return row;
        }
    }
}