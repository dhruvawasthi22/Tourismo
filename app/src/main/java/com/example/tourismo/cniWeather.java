package com.example.tourismo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class cniWeather extends AppCompatActivity {
    TextView detail;
    TextView cityname;
    ProgressBar progressBar;

    public class DownloadTask extends AsyncTask<String,Void,String>
    {
        @Override
        protected String doInBackground(String... urls) {
            String result ="";
            URL url;
            HttpURLConnection urlConnection= null;
            try
            {
                url=new URL(urls[0]);
                urlConnection=(HttpURLConnection) url.openConnection();
                InputStream in=urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data=reader.read();

                while(data!=-1)
                {
                    char current=(char)data;
                    result +=current;
                    data=reader.read();
                }
               // Log.i("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaaa",result);
                return result;

            }catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);

                String weatherinfo= jsonObject.getString("weather");
               String temperature=jsonObject.getString("main");
               JSONObject tempobject =new JSONObject(temperature);
               String temp=tempobject.getString("temp");
               String hmd=tempobject.getString("humidity");
               // Log.i("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaaa",temp);

                JSONArray arr=new JSONArray(weatherinfo);
                String msg="";
                for(int i=0;i<arr.length();i++)
                {
                    JSONObject jsonpart=arr.getJSONObject(i);
                    String main=jsonpart.getString("main");
                    String desc=jsonpart.getString("description");
                    //String temp=jsonpart.getString("temp");
                    if(!main.equals("")&& !desc.equals(("")))
                    {
                        msg+=main+":"+desc+"\n";
                    }

                  // Log.i("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaaa",jsonpart.getString("temp"));
                   //Log.i("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx",jsonpart.getString("description"));

                }











                if(!msg.equals(""))
                {
                    progressBar.setVisibility(View.INVISIBLE);
                    msg+= "Temperature(F): "+temp+"\n"+"Humidity: "+hmd;
                    detail.setText(msg);
                }
            }
            catch (Exception e)
            {
               e.printStackTrace();
               Log.i("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx","ERROR");
            }

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cni_weather);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        String city = intent.getStringExtra("activity");
        detail=findViewById(R.id.detailTextview);
        cityname=findViewById(R.id.cityTextview);
        cityname.setText(city);
        DownloadTask task= new DownloadTask();
        task.execute("https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=5875d8e0b181d132aafc4cb280ddb52f");


    }
}
