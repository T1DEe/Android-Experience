package com.example.artemymarkovsky.result_requestcodes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;


public class AlignmentActivity extends Activity implements View.OnClickListener {

    RadioGroup radioGroup;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alignment);

        radioGroup = findViewById(R.id.rgAlignments);
        btnSend = findViewById(R.id.btnSendAlignment);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent();
        switch (radioGroup.getCheckedRadioButtonId())
        {
            case R.id.rbLeft:
            {
                intent.putExtra("alignment", Gravity.START);
                break;
            }
            case R.id.rbCenter:
            {
                intent.putExtra("alignment", Gravity.CENTER);
                break;
            }
            case R.id.rbRight:
            {
                intent.putExtra("alignment", Gravity.END);
                break;
            }
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
