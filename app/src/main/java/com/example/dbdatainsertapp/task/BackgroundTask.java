package com.example.dbdatainsertapp.task;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String, Void, String> {

    Context ctx;

    public BackgroundTask(Context ctx){

        this.ctx = ctx;

    }

    @Override
    protected String doInBackground(String... params) {

        String reg_url = "http://localhost/project/android/register.php";
        String method = params[0];

        if (method.equals("register")) {

            String name = params[1];
            String password = params[2];
            String contact = params[3];
            String country = params[4];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);

                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data = URLEncoder.encode("name","UTF-8")+ " = "+ URLEncoder.encode("name","UTF-8")
                        + "&" + URLEncoder.encode("password","UTF-8")+ " = "+ URLEncoder.encode("password","UTF-8")
                        + "&" + URLEncoder.encode("contact","UTF-8")+ " = "+ URLEncoder.encode("contact","UTF-8")
                        + "&" + URLEncoder.encode("country","UTF-8")+ " = "+ URLEncoder.encode("country","UTF-8");

                bWriter.write(data);
                bWriter.flush();
                bWriter.close();
                os.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();

                return "Registration Success";


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
