 package com.example.abinash.student.juniors.m_JSON;
        import java.io.IOException;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;

public class Connector {
    public static Object connect(String jURL)
    {
        try
        {
            URL url = new URL(jURL);
            HttpURLConnection con=(HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(200000);
            con.setReadTimeout(200000);
            con.setDoInput(true);
            return con;
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
            return  "Error"+e.getMessage();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return  "Error"+e.getMessage();
        }
    }
}