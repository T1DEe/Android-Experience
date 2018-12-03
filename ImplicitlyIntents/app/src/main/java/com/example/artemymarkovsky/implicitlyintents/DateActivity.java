package com.example.artemymarkovsky.implicitlyintents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateActivity extends Activity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        textView = findViewById(R.id.textDate);

        SimpleDateFormat df = new SimpleDateFormat("dd:MM:yyyy");
        String date = df.format(new Date(System.currentTimeMillis()));

        textView.setText(date);
    }
}
