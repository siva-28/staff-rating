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

public class JSONparser extends AsyncTask<Void,Void,Boolean>{
    Context z;
    String jsonData;
    Spinner sp;
    String url="http://10.10.66.254:5000/";
    ProgressDialog pd;
    String data;
    RecyclerView rc;


    public JSONparser(Context z, Spinner sp, RecyclerView rc) {
        this.z = z;
        this.jsonData = jsonData;
        this.sp = sp;
        this.rc=rc;


    }

    ArrayList<String> dep=new ArrayList<>();
    ArrayList<String> datalist=new ArrayList<>();

    @Override
    protected Boolean doInBackground(Void... voids)
    {
        jsonData=JSONdown.download(url+"dep");
        return this.parse(dep,jsonData);
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
            ArrayAdapter<String> adapter= new ArrayAdapter<String>(z,android.R.layout.simple_list_item_1,dep);
            sp.setAdapter(adapter);

            sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
                {

                    

                    final AsyncTask<Void, Void, Boolean> execute = new recycler(z,rc,url+dep.get(i)).execute();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

        }
        else
        {
            Toast.makeText(z,"Please try again later.",Toast.LENGTH_LONG).show();
        }
    }
    static Boolean parse(ArrayList<String> d, String json)
    {
        try
        {
            JSONObject  ja = new JSONObject(json);
            JSONArray array= ja.getJSONArray("result");
            d.clear();
            for(int i=0;i<array.length();i++)
            {

                JSONObject object= array.getJSONObject(i);
                d.add(object.getString("name"));

            }
            return true;

        }
        catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static String download(String j) {
        String result = null;

        Object connection = Connector.connect(j);
        if (connection.toString().startsWith("Error")) {
            return connection.toString();
        }

        try {

            URL url = new URL(j);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            result = inputStreamToString(in);
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "Server is busy";


    }

    private static String inputStreamToString(InputStream in) {

        String rLine = "";
        StringBuilder answer = new StringBuilder();

        InputStreamReader isr = new InputStreamReader(in);

        BufferedReader rd = new BufferedReader(isr);

        try {
            while ((rLine = rd.readLine()) != null) {
                answer.append(rLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer.toString();
    }

}
