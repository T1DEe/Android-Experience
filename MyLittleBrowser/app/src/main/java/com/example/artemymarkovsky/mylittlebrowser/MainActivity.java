package com.example.artemymarkovsky.mylittlebrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        (findViewById(R.id.btnSearch)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultStr = "https://" + editText.getText().toString();
                Toast.makeText(getApplicationContext(), resultStr, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setAction("android.intent.action.browser");
                intent.putExtra("address", resultStr);
                startActivity(intent);
            }
        });
    }
}
