package se.miun.dt170g.laboration01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    void runBackgroundProcess(DailyWeather dw) {}
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BackgroundProcess bp = new BackgroundProcess();
        bp.run(weatherParser -> runBackgroundProcess(weatherParser));
        ImageView img= (ImageView) findViewById(R.id.weatherPicture);
        img.setImageResource(R.mipmap.ic_launcherstorm);

    }
}