package com.example.artemymarkovsky.implicitlyintents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeActivity extends Activity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        textView = findViewById(R.id.textTime);

        SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");;
        String time = tf.format(new Date(System.currentTimeMillis()));

        textView.setText(time);
    }
}
