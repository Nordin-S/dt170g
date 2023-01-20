package se.miun.dt170g.laboration01;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RetrieveFeedTask extends AsyncTask<String, String, String> {

    public String doInBackground(String... urls) {
        String result = null;
        HttpURLConnection urlConnection = null;
        URL url;
        try {
            url = new URL(urls[0]);
//                this code could give us a error if he had a malformed url.
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:221.0) Gecko/20100101 Firefox/31.0");

            InputStream in = urlConnection.getInputStream();
//                we use this to do the loading from the net. this is just a stream that holds the input of data
            InputStreamReader reader = new InputStreamReader(in);
//                to read that data, we created this.
            int data = reader.read();
//                which will keep track of the location through the html content that we are currently on.
            //Log.i("Lord", String.valueOf(data));
            while (data != -1) {
//                    the data will count throught 1 2 3 ... and keeps on going while reading caracters,
//                    and when it gets to the end it gets the value of -1.
                char current = (char) data;
//                    this is the current caractor that is being downloaded.
                result += current;
                data = reader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed";
        }
        return result;
    }

}
