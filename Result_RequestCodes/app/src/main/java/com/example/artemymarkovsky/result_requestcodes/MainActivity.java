package com.example.artemymarkovsky.result_requestcodes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView textMain;
    Button btnToColor;
    Button btnToAlignment;

    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIGNMENT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textMain = findViewById(R.id.mainText);
        btnToColor = findViewById(R.id.btnToColor);
        btnToAlignment = findViewById(R.id.btnToAlignment);

        btnToColor.setOnClickListener(this);
        btnToAlignment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId())
        {
            case R.id.btnToColor:
            {
                intent = new Intent(this, ColorActivity.class);
                startActivityForResult(intent, REQUEST_CODE_COLOR);
                break;
            }
            case R.id.btnToAlignment:
            {
                intent = new Intent(this, AlignmentActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ALIGNMENT);
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {
            switch (requestCode) {
                case REQUEST_CODE_COLOR: {
                    int color = data.getIntExtra("color", Color.WHITE);     // второй аргумент – дефолтное значение
                    textMain.setTextColor(color);
                    break;
                }
                case REQUEST_CODE_ALIGNMENT: {
                    int align = data.getIntExtra("alignment", Gravity.START);
                    textMain.setGravity(align);
                    break;
                }
            }
        }
        else
        {
            Toast.makeText(this, "Wrong input", Toast.LENGTH_SHORT).show();
        }
    }
}
