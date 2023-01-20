package se.miun.dt170g.laboration01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    //    We Are going to download Web Content.
    //    1) we start by creating a new class.
    public class DownloadTask extends AsyncTask<String, Void, String> {
        //    a class is a collection of methods and variables that we can use in our app.
//    AsyncTask: is a way of running our code on a different thread than the main thread.
//    so far we used onCreate method thread which known as ui thread. it is advised to run
//    any code that gets a bit of time on a different thread rather than the main thread.
//    so we are creating some code that will be run in background.
//    AsyncTask usually gets 3 parameter.
//    The First one: is the type of variable that we are going to send to this class. to instruct it what to do.
//    The Second One: is the name of the method that we may or maynot use to show the progress of this async task
//    The Third One: is the type of the variable that is going to be returned by this class.
        @Override
        protected String doInBackground(String... urls) {
//            protected : this protected means that this string can be accessed from anywhere in the package, not just
//            this class and not just this java file, it can be access from anywhere in the app.
//            String... : this is know as varArgs and this is a new variable in java and we can think of it like an array.
//            3)To access the vaiable that we sent here we do this:
            Log.i("URL:", urls[0]);
//            5)we are going to write code to download from internet:
            String result = "Hi";
            URL url;
            HttpURLConnection urlConnection = null;
//            HttpUrlConnection is like a browser. so it open a browser and use it to fetch the content
            try {
                url = new URL(urls[0]);
//                this code could give us a error if he had a malformed url.
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
                InputStream in = urlConnection.getInputStream();
//                we use this to do the loading from the net. this is just a stream that holds the input of data
                InputStreamReader reader = new InputStreamReader(in);
//                to read that data, we created this.
                int data = reader.read();
//                which will keep track of the location through the html content that we are currently on.
                Log.i("Lord", String.valueOf(data));
                while (data != -1) {
//                    the data will count throught 1 2 3 ... and keeps on going while reading caracters,
//                    and when it gets to the end it gets the value of -1.
                    char current = (char) data;
//                    this is the current caractor that is being downloaded.
                    result += current;
                    data = reader.read();
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return "Failed";
            }
//            6)finally we need to ask permission to use internet connection. we do that in the manifest
//            androidManifest.xml file.
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        2)Now that we created our DownloadTask Class we can call it from our onCreate Method.
        DownloadTask task = new DownloadTask();
//        because the Download Task accept varArgs, we can send it as many request as we want like in our call to that task without specifiing in Download Task
//        How many they are.
//        3) to get the value that is returned from the Download Task we are going to create a String and
//        equal that string to the task.execute and in the end call the get() method.
        String result = null;
        try {
            result = task.execute("https://api.met.no/weatherapi/locationforecast/2.0/classic?lat=62.39433856937368&lon=17.28406989931221").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
//            this prints all the information about the error to the logs.
            Log.i("Lord", "Error1");
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.i("Lord", "Error2");
        }
        Log.i("Lord", result);
    }
}