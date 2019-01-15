package com.example.artemymarkovsky.implicitlyintents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnToTime;
    Button btnToDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToTime = findViewById(R.id.btnTime);
        btnToDate = findViewById(R.id.btnDate);

        btnToTime.setOnClickListener(this);
        btnToDate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId())
        {
            case R.id.btnTime:
            {
                intent = new Intent("android.intent.action");
                startActivity(intent);
                break;
            }
            case R.id.btnDate:
            {
                intent = new Intent("android.intent.action");
                startActivity(intent);
                break;
            }
        }
    }
}
