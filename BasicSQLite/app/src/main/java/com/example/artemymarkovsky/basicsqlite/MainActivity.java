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
    Button btnDeleteById;
    Button btnUpdateById;
    Button btnDeleteByName;
    Button btnUpdateByName;

    EditText etId;
    EditText etName;
    EditText etEmail;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.idField);
        etName = findViewById(R.id.nameField);
        etEmail = findViewById(R.id.emailField);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead = findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnDeleteById = findViewById(R.id.btnDeleteById);
        btnDeleteById.setOnClickListener(this);

        btnUpdateById = findViewById(R.id.btnUpdateById);
        btnUpdateById.setOnClickListener(this);

        btnDeleteByName = findViewById(R.id.btnDeleteByName);
        btnDeleteByName.setOnClickListener(this);

        btnUpdateByName = findViewById(R.id.btnUpdateByName);
        btnUpdateByName.setOnClickListener(this);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {
        String id = etId.getText().toString();
        String name = etName.getText().toString();;
        String email = etEmail.getText().toString();;

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        switch (v.getId())
        {
            //–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
            case R.id.btnAdd:
                if(name.equals("") || email.equals(""))
                    break;

                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_EMAIL, email);

                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                Log.d("dbLog", "added row: " + "NAME = " + name + ", " +
                        "E-MAIL = " + email);
                break;
            //–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
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
            //–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
            case R.id.btnClear:
                database.delete(DBHelper.TABLE_CONTACTS, null, null);
                break;
            //–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
            case R.id.btnDeleteById:
                if(id.equals(""))
                    break;

                int delCountById = database.delete(DBHelper.TABLE_CONTACTS, DBHelper.KEY_ID + " = " + id, null);
                Log.d("dbLog", delCountById + " rows was delete");
                break;
            //–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
            case R.id.btnUpdateById:
                if(id.equals(""))
                    break;

                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_EMAIL, email);

                int updCountById = database.update(DBHelper.TABLE_CONTACTS, contentValues, DBHelper.KEY_ID + " = ?", new String[] {id});
                Log.d("dbLog", updCountById + " rows was update");
                break;
            //–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
            case R.id.btnDeleteByName:
                if(name.equals(""))
                    break;

                int delCountByName = database.delete(DBHelper.TABLE_CONTACTS, DBHelper.KEY_NAME + " = ?", new String[] {name} );
                Log.d("dbLog", delCountByName + " rows was delete");
                break;
            //–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
            case R.id.btnUpdateByName:
                if(name.equals(""))
                    break;

                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_EMAIL, email);

                int updCountByName = database.update(DBHelper.TABLE_CONTACTS, contentValues, DBHelper.KEY_NAME + " = ?", new String[] {name});
                Log.d("dbLog", updCountByName + " rows was update");
                break;
            //–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
        }
        dbHelper.close();
    }
}
