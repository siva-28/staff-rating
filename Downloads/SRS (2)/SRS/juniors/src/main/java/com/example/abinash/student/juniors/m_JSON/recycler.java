package com.example.abinash.student.juniors.m_JSON;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class recycler extends AsyncTask<Void,Void,Boolean>{
    Context z;
    String jsonData;

    String url;
    ProgressDialog pd;

    RecyclerView rc;


    public recycler(Context z, RecyclerView rc,String url) {
        this.z = z;
      this.url=url;
        this.rc=rc;


    }


    ArrayList<String> datalist=new ArrayList<>();

    @Override
    protected Boolean doInBackground(Void... voids)
    {
        jsonData=JSONdown.download(url);
        return JSONparser.parse(datalist,jsonData);
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        pd=new ProgressDialog(z);
        pd.setTitle("Parsing");
        pd.setMessage("Parsing Data");
        pd.show();

    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);
        pd.dismiss();
        if(isParsed)
        {



                        rc.setLayoutManager(new LinearLayoutManager(z));

                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(z);
                        rc.setLayoutManager(linearLayoutManager);
                        //  call the constructor of CustomAdapter to send the reference and data to Adapter
                        CustomAdapter customAdapter = new CustomAdapter(z,datalist);
                        rc.setAdapter(customAdapter);
                    }
                    else
                    {
                        Toast.makeText(z,"No staff statuts",Toast.LENGTH_LONG).show();
                    }



    }


}
