package com.example.roberto.internet;

import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsynchronousHttpURLConnector extends AsyncTask<Void,Integer,String> {

    private String urlString;
    private HttpURLConnectionPostProcessorInterface httpURLConnectionPostProcessorInterface;

    private TextView textViewProgress;

    public AsynchronousHttpURLConnector(HttpURLConnectionPostProcessorInterface httpURLConnectionPostProcessorInterface, String urlString, TextView textViewProgress){
        this.urlString = urlString;

        this.httpURLConnectionPostProcessorInterface = httpURLConnectionPostProcessorInterface;
        this.textViewProgress = textViewProgress;
    }


    @Override
    protected String doInBackground(Void... voids) {

        String urlConnectionResultString = "";
        HttpURLConnection httpURLConnection = null;
        try{
            System.out.println("-----------------> "+ urlString);
            httpURLConnection = (HttpURLConnection) new URL(urlString).openConnection();

            InputStream urlConnectionInputStream = httpURLConnection.getInputStream();
            System.out.println("------------------ urlConnectionInputStream: "+urlConnectionInputStream);

            urlConnectionResultString = inputStreamToString(urlConnectionInputStream);
        }catch(Exception e){
            httpURLConnectionPostProcessorInterface.failureHandler(e);
        }
        return urlConnectionResultString;
    }

    private String inputStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        bufferedReader = new BufferedReader(inputStreamReader);
        String oneLine = null;

        int counter =0;

        try{
            while((oneLine = bufferedReader.readLine()) != null){
                stringBuilder.append(oneLine);

                publishProgress(counter++);
            }
        }catch (Exception e){
            httpURLConnectionPostProcessorInterface.failureHandler(e);
        }
        System.out.println("--------------------- Result String: "+stringBuilder.toString());
        return  stringBuilder.toString();

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        System.out.println("------------------- onPostExecute: "+ s);

        httpURLConnectionPostProcessorInterface.successHandler(s);
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        textViewProgress.setText("Number of lines in loaded web page:" + String.valueOf(values[0]));
        textViewProgress.setTextSize(16);
        System.out.println("---------------------- Number of lines in loaded web page: "+ String.valueOf(values[0]));
    }
}
