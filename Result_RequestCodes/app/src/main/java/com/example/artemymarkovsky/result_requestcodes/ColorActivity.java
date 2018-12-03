package com.example.artemymarkovsky.result_requestcodes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class ColorActivity extends Activity implements View.OnClickListener {

    RadioGroup radioGroup;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        radioGroup = findViewById(R.id.rgColors);
        btnSend = findViewById(R.id.btnSendColor);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent();
        switch (radioGroup.getCheckedRadioButtonId())
        {
            case R.id.rbRed:
            {
                intent.putExtra("color", Color.RED);
                break;
            }
            case R.id.rbGreen:
            {
                intent.putExtra("color", Color.GREEN);
                break;
            }
            case R.id.rbBlue:
            {
                intent.putExtra("color", Color.BLUE);
                break;
            }
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
