package com.example.artemymarkovsky.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText editText;
    Button btnSave;
    Button btnLoad;
    Button btnDelete;
    SharedPreferences shPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnLoad = findViewById(R.id.btnLoad);
        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);
        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

//        loadText();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnSave:
            {
                saveText();
                break;
            }
            case R.id.btnLoad:
            {
                loadText();
                break;
            }
            case  R.id.btnDelete:
            {
                deleteText();
                break;
            }
        }

    }

    private void saveText()
    {
        shPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = shPref.edit();
        editor.putString("save", editText.getText().toString());
        editor.apply();
        Toast.makeText(this,"Text saved", Toast.LENGTH_SHORT).show();
    }

    private void loadText() {
        shPref = getPreferences(MODE_PRIVATE);
        String loadedText = shPref.getString("save", "");
        editText.setText(loadedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    private void deleteText() {
        shPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = shPref.edit();
        editor.remove(editText.getText().toString());
        editor.apply();
        Toast.makeText(this, "Text removed", Toast.LENGTH_SHORT).show();
    }
}
