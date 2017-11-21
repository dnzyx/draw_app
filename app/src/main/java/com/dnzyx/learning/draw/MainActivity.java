package com.dnzyx.learning.draw;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Handler handler;

    private draw_view mMyView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();
        mMyView = new draw_view(this, handler);
        setContentView(mMyView);
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(mUIUpdateRunnable);
            }
        }).start();

    }

    private Runnable mUIUpdateRunnable = new Runnable() {
        @Override
        public void run() {
            mMyView.invalidate();
        }
    };
}
