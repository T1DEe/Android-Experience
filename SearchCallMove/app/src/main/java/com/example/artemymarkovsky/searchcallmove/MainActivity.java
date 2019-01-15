package com.example.artemymarkovsky.searchcallmove;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class MainActivity extends Activity {

    Button btnToWeb;
    Button btnToMap;
    Button btnToCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.btnToWeb:
                    {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/T1DEe"));
                        startActivity(intent);
                        break;
                    }
                    case R.id.btnToMap:
                    {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("geo:53.889349,28.034277"));
                        startActivity(intent);
                        break;
                    }
                    case R.id.btnToCall:
                    {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:1234"));
                        startActivity(intent);
                        break;
                    }
                }
            }
        };

        btnToWeb = findViewById(R.id.btnToWeb);
        btnToMap = findViewById(R.id.btnToMap);
        btnToCall = findViewById(R.id.btnToCall);
        btnToWeb.setOnClickListener(listener);
        btnToMap.setOnClickListener(listener);
        btnToCall.setOnClickListener(listener);
    }
}
