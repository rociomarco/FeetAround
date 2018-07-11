package com.example.rosiomarco.projectsummer;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;

public class DownloadUrl {

    public String readURl(String myUrl)throws IOException
    {
        String data = "";
        InputStream inputStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url =  new URL (myUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) !=null)
            {
                sb.append(line);

            }

            data = sb.toString();
            Log.d("downloadUrl", data.toString());
            br.close();

        } catch (IOException e) {
            Log.d("Exception",e.toString());
        } finally {
            inputStream.close();
            urlConnection.disconnect();
        }

        return data;

    }
}
