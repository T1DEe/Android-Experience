package com.example.artemymarkovsky.addactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    Button button;

    final String TAG = "lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnToNext);
        button.setOnClickListener(this);

        Log.d(TAG, "MainActivity onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "MainActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "MainActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "MainActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "MainActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "MainActivity onDestroy");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnToNext:
            {
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
