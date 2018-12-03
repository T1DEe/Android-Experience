package com.example.artemymarkovsky.implicitlyintents2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnToTime;
    Button btnToDate;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.dataToOtherActivity);

        btnToTime = findViewById(R.id.btnToTime);
        btnToDate = findViewById(R.id.btnToDate);
        btnToTime.setOnClickListener(this);
        btnToDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnToTime:
            {
                Intent intent = new Intent("android.intent.action.time");
                intent.putExtra("data", editText.getText().toString());

                startActivity(intent);
                break;
            }

            case R.id.btnToDate:
            {
                Intent intent = new Intent("android.intent.action.date");
                intent.putExtra("data", editText.getText().toString());

                startActivity(intent);
                break;
            }
        }
    }
}
