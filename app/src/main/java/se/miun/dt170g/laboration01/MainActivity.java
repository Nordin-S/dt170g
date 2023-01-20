package se.miun.dt170g.laboration01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrieveFeedTask task = new RetrieveFeedTask();
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
