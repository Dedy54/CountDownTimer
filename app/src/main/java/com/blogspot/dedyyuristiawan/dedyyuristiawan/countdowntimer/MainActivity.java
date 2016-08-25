package com.blogspot.dedyyuristiawan.dedyyuristiawan.countdowntimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewShowTime;
    private CountDownTimer countDownTimer;
    private long totalTimeCountInMilliseconds;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewShowTime = (TextView) findViewById(R.id.tvTimeCount);
        startTimer(2);
//		countDownTimer.cancel();
    }

    private void startTimer(int time) {
        totalTimeCountInMilliseconds = 60 * time * 1000;
        totalTimeCountInMilliseconds = totalTimeCountInMilliseconds + 1000;
        countDownTimer = new CountDownTimer(totalTimeCountInMilliseconds, 1000) {

            @Override
            public void onTick(long leftTimeInMilliseconds) {
                long seconds = leftTimeInMilliseconds / 1000;
                String minute =  String.format("%02d", seconds / 60);
                String second =  String.format("%02d", seconds % 60);
                textViewShowTime.setText(minute+" : "+ second);
            }

            @Override
            public void onFinish() {
                textViewShowTime.setText("Time up!");
            }
        }.start();
    }
}
