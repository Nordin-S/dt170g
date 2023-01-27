package se.miun.dt170g.laboration01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    void runBackgroundProcess(DailyWeather dw) {}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.refreshButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new DailyWeather object
            }
            //function to set the weather picture
            public void setWeatherPicture(DailyWeather tmp) {
                ImageView img = (ImageView) findViewById(R.id.weatherPicture);
                switch (tmp.getWeatherType()) {
                    case "Clear":

                        img.setImageResource(R.mipmap.ic_launcher);
                        break;
                    case "Clouds":

                        img.setImageResource(R.mipmap.ic_launchercloudy);
                        break;
                    case "Rain":

                        img.setImageResource(R.mipmap.ic_launcherainy);
                        break;
                    case "Snow":

                        img.setImageResource(R.mipmap.ic_launchersnowy);
                        break;
                    case "Storm":

                        img.setImageResource(R.mipmap.ic_launcherstorm);
                        break;
                }
              //  ImageView img = (ImageView) findViewById(R.id.weatherPicture);
                //img.setImageResource(R.mipmap.ic_launcherstorm);
            }
        });




        BackgroundProcess bp = new BackgroundProcess();
        bp.run(weatherParser -> runBackgroundProcess(weatherParser));
    }



}