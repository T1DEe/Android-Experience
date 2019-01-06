package com.example.artemymarkovsky.countriesdatabase;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    final String LOG_TAG = "dbLog";

    String name[] = {"", "", "", "", "", "", "", "", "", ""};
    int population[] = {"", "", "", "", "", "", "", "", "", ""};
    String region[] = {"", "", "", "", "", "", "", "", "", ""};

    Button btnAll, btnFunc, btnPupulMoreThen, btnRegPopul, btnRegPopulMoreThen, btnSort;
    EditText etFunc, etPopulMoreThen, etRegPopulMoreThen;
    RadioGroup rgSortBy;
    RadioButton rbSortByName, rbSortByReg, rbSortByPopul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
