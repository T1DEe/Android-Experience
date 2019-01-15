package com.example.artemymarkovsky.addactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity implements View.OnClickListener {

    Button btnToPrevious;
    final String TAG = "lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnToPrevious = findViewById(R.id.btnToPrevious);
        btnToPrevious.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "SecondActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "SecondActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "SecondActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "SecondActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "SecondActivity onDestroy");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnToPrevious:
            {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }
    }
}
