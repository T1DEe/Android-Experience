package com.example.artemymarkovsky.basicsqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnAdd;
    Button btnRead;
    Button btnClear;

    EditText etName;
    EditText etEmail;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.nameField);
        etEmail = findViewById(R.id.emailField);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead = findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        switch (v.getId())
        {
            case R.id.btnAdd:
                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_EMAIL, email);

                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                Log.d("dbLog", "added row: " + "NAME = " + name + ", " +
                        "E-MAIL = " + email);
                break;
            case R.id.btnRead:
                Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

                if (cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int emailIndex = cursor.getColumnIndex(DBHelper.KEY_EMAIL);

                    do {
                        Log.d("dbLog", "ID = " + cursor.getInt(idIndex) + ", " +
                                                 "NAME = " + cursor.getString(nameIndex) + ", " +
                                                 "E-MAIL = " + cursor.getString(emailIndex));
                    } while (cursor.moveToNext());
                }
                else {
                    Log.d("dbLog", "0 rows in the database");
                }

                cursor.close();
                break;
            case R.id.btnClear:
                database.delete(DBHelper.TABLE_CONTACTS, null, null);
                break;
        }
        dbHelper.close();
    }
}
