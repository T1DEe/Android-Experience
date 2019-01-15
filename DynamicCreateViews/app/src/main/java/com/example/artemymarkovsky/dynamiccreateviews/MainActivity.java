package com.example.artemymarkovsky.dynamiccreateviews;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnCreate;
    Button btnClear;
    EditText inputText;
    RadioGroup rdGroup;
    LinearLayout createField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = findViewById(R.id.btnCreate);
        btnClear = findViewById(R.id.btnClear);
        inputText = findViewById(R.id.edInput);
        rdGroup = findViewById(R.id.rbGravity);
        createField = findViewById(R.id.createField);

        btnCreate.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnCreate:
            {
                LinearLayout.LayoutParams newViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                Button btn = new Button(this);
                btn.setText(inputText.getText().toString());
                int gravity = Gravity.LEFT;

                switch (rdGroup.getCheckedRadioButtonId())
                {
                    case R.id.rbLeft:
                    {
                        gravity = Gravity.LEFT;
                        newViewParams.gravity = gravity;
                        break;
                    }
                    case R.id.rbCenter:
                    {
                        gravity = Gravity.CENTER;
                        newViewParams.gravity = gravity;
                        break;
                    }
                    case R.id.rbRight:
                    {
                        gravity = Gravity.RIGHT;
                        newViewParams.gravity = gravity;
                        break;
                    }
                }

                createField.addView(btn, newViewParams);
                break;
            }
            case R.id.btnClear:
            {
                createField.removeAllViews();
                Toast.makeText(MainActivity.this, "Удалено", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
