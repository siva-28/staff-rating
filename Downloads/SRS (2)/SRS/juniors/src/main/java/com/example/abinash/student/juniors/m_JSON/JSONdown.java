package com.example.abinash.student.juniors.m_JSON;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONdown
{




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

