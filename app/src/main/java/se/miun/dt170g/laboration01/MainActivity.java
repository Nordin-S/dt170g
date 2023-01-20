package se.miun.dt170g.laboration01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    void runBackgroundProcess(DailyWeather dw) {}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BackgroundProcess bp = new BackgroundProcess();
        bp.run(weatherParser -> runBackgroundProcess(weatherParser));
    }



}