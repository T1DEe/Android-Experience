package com.example.artemymarkovsky.simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText leftInputField;
    EditText rightInputField;

    Button btnPlus;
    Button btnMinus;
    Button btnMultiply;
    Button btnDivision;

    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftInputField = findViewById(R.id.leftInputField);
        rightInputField = findViewById(R.id.rightInputField);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivision = findViewById(R.id.btnDivision);
        resultText = findViewById(R.id.resultText);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (leftInputField.getText().toString().equals("") || rightInputField.getText().toString().equals(""))
        {
            Toast.makeText(MainActivity.this, "Пустое поле", Toast.LENGTH_SHORT).show();
            return;
        }

        float leftValue = Float.parseFloat(leftInputField.getText().toString());
        float rightValue = Float.parseFloat(rightInputField.getText().toString());
        float result = 0;
        String operation = "";

        switch (v.getId())
        {
            case R.id.btnPlus:
            {
                result = leftValue + rightValue;
                operation = "+";
                break;
            }
            case R.id.btnMinus:
            {
                result = leftValue - rightValue;
                operation = "-";
                break;
            }
            case R.id.btnMultiply:
            {
                result = leftValue * rightValue;
                operation = "*";
                break;
            }
            case R.id.btnDivision:
            {
                result = leftValue / rightValue;
                operation = "/";
                break;
            }
        }
        String text = leftValue + " " + operation + " " + rightValue + " = " + result;
        resultText.setText(text);
    }
}
