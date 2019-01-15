package com.example.artemymarkovsky.implicitlyintents2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDateActivity extends Activity {

    TextView title;
    TextView tvTimeDate;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_date);

        title = findViewById(R.id.textTitle);
        tvTimeDate = findViewById(R.id.textTimeDate);

        String action = getIntent().getAction();

        textView = findViewById(R.id.textData);

        switch (action)
        {
            case "android.intent.action.time":
            {
                title.setText("Time");

                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
                String time = timeFormat.format(new Date(System.currentTimeMillis()));

                tvTimeDate.setText(time);

                textView.setText(getIntent().getStringExtra("data"));
                break;
            }

            case "android.intent.action.date":
            {
                title.setText("Date");

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
                String date = dateFormat.format(new Date(System.currentTimeMillis()));

                tvTimeDate.setText(date);

                textView.setText(getIntent().getStringExtra("data"));
                break;
            }
        }
    }
}
