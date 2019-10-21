package com.example.m0716081;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData extends AsyncTask <String , Void , String> {

    MainActivity mainActivity;

    public FetchData(MainActivity activity){
        this.mainActivity = activity;
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection urlConnection = null;

        BufferedReader reader =  null;
        String result = null;
        String params = strings[0];
        try {
            URL url = new URL("http://api.mathjs.org/v4/?expr="+ params);
            urlConnection  = ( HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                return null;
            }

            result = buffer.toString();




        }
        catch (Exception e){
            Log.e("oops", e.getMessage() +"");
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        this.mainActivity.setResult(s);
    }
}
