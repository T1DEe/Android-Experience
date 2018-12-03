package com.example.artemymarkovsky.seekbarandweight;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    SeekBar seekBar;
    Button button1;
    Button button2;

    LinearLayout.LayoutParams llParams1;
    LinearLayout.LayoutParams llParams2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        llParams1 = (LinearLayout.LayoutParams) button1.getLayoutParams();
        llParams2 = (LinearLayout.LayoutParams) button2.getLayoutParams();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int leftValue = progress;
        int rightValue = seekBar.getMax() - leftValue;

        llParams1.weight = leftValue;
        llParams2.weight = rightValue;

        if (leftValue == 0) {
            button1.setVisibility(View.INVISIBLE);
        }
        else {
            button1.setVisibility(View.VISIBLE);
        }
        if (rightValue == 0) {
            button2.setVisibility(View.INVISIBLE);
        }
        else {
            button2.setVisibility(View.VISIBLE);
        }

        button1.setText(String.valueOf(leftValue));
        button2.setText(String.valueOf(rightValue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(MainActivity.this, "start", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(MainActivity.this, "end", Toast.LENGTH_SHORT).show();
    }
}
