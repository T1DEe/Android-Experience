package com.example.artemymarkovsky.layoutfromactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);      // создаем layout
        linearLayout.setOrientation(LinearLayout.VERTICAL);             // задаем ориентацию
        ViewGroup.LayoutParams linLayoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                                        // создаем параметры layout'a

        setContentView(linearLayout, linLayoutParams);  // обединянем параметры с layout'ом

        ViewGroup.LayoutParams layparParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tv = new TextView(this);
        tv.setText("Text");
        linearLayout.addView(tv, layparParams);     // добавление view на layout

        Button button1 = new Button(this);
        button1.setText("button1");
        linearLayout.addView(button1, layparParams);

        LinearLayout.LayoutParams linlayParamsLeftMargin = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linlayParamsLeftMargin.leftMargin = 50;

        Button button2 = new Button(this);
        button2.setText("button2");
        linearLayout.addView(button2, linlayParamsLeftMargin);
    }
}
