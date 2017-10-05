package com.example.alex.timeronhandler;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvTimer1;
    private TextView mTvTimer2;
    private TextView mTvClock;

    private Button mBtStart1;
    private Button mBtStop1;
    private Button mBtStart2;
    private Button mBtStop2;

    private long mTime = 0L;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFindView();
        setListeners();
        setTimeOnClock();
    }

    private void setListeners() {
        mBtStart1.setOnClickListener(this);
        mBtStart2.setOnClickListener(this);
        mBtStop1.setOnClickListener(this);
        mBtStop2.setOnClickListener(this);
    }

    private void setTimeOnClock() {

    }

    private void setFindView() {
        mTvTimer1 = (TextView) findViewById(R.id.tv_timer);
        mTvTimer2 = (TextView) findViewById(R.id.tv_timer2);
        mTvClock = (TextView) findViewById(R.id.tv_clock);

        mBtStart1 = (Button) findViewById(R.id.bt_start);
        mBtStart2 = (Button) findViewById(R.id.bt_start2);
        mBtStop1 = (Button) findViewById(R.id.bt_stop);
        mBtStop2 = (Button) findViewById(R.id.bt_stop2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_start:
                timerStart(1);
                break;

            case R.id.bt_start2:
                timerStart(2);
                break;
            case R.id.bt_stop:
                timerStop(1);
                break;
            case R.id.bt_stop2:
                timerStop(2);
                break;
        }
    }

    private void timerStop(int i) {
        switch (i) {
            case 1:
                break;
            case 2:
                break;
        }
    }

    private void timerStart(int i) {
        switch (i) {
            case 1:
                Runnable timeUpdaterRunnable = new Runnable() {
                    @Override
                    public void run() {
                        // вычисляем время
                        final long start = mTime;
                        long millis = SystemClock.uptimeMillis() - start;
                        int second = (int) (millis / 1000);
                        int min = second / 60;
                        second = second % 60;
                        // выводим время
                        mTvTimer1.setText("" + min + ":" + String.format("%02d", second));
                        // повторяем через каждые 200 миллисекунд
                        mHandler.postDelayed(this, 200);
                    }
                };
                break;
            case 2:
                break;
        }
    }
}

