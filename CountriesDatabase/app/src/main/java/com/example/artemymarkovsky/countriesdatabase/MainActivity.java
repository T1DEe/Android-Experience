package com.example.artemymarkovsky.countriesdatabase;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends Activity implements View.OnClickListener {

    // данные
    String name[] = {"Китай", "США", "Бразилия", "Россия", "Япония", "Германия", "Египет", "Италия", "Франция", "Канада"};
    int population[] = {1400, 311, 195, 142, 128, 82, 80, 60, 66, 35};
    String region[] = {"Азия", "Америка", "Америка", "Европа", "Азия", "Европа", "Африка", "Европа", "Европа", "Америка"};

    // эл-ты экрана
    Button btnAll, btnFunc, btnPopulMoreThen, btnRegPopul, btnRegPopulMoreThen, btnSort;
    EditText etFunc, etPopulMoreThen, etRegPopulMoreThen;
    RadioGroup rgSortBy;

    DBHelper dbHelper;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAll = findViewById(R.id.btnAll);
        btnAll.setOnClickListener(this);
        btnFunc = findViewById(R.id.btnFunc);
        btnFunc.setOnClickListener(this);
        btnPopulMoreThen = findViewById(R.id.btnPopulMoreThen);
        btnPopulMoreThen.setOnClickListener(this);
        btnRegPopul = findViewById(R.id.btnRegPopul);
        btnRegPopul.setOnClickListener(this);
        btnRegPopulMoreThen = findViewById(R.id.btnRegPopulMoreThen);
        btnRegPopulMoreThen.setOnClickListener(this);
        btnSort = findViewById(R.id.btnSort);
        btnSort.setOnClickListener(this);

        etFunc = findViewById(R.id.etFunc);
        etPopulMoreThen = findViewById(R.id.etPopulMoreThen);
        etRegPopulMoreThen = findViewById(R.id.etRegPopulMoreThen);

        rgSortBy = findViewById(R.id.rgSortBy);

        dbHelper = new DBHelper(this);
        // подключение к созданной БД
        db = dbHelper.getWritableDatabase();

        // указатель в БД
        Cursor cursor = db.query(DBHelper.TABLE_NAME, null, null,null, null, null,null);
        // если БД пуста - заполняем
        if(cursor.getCount() == 0)
        {
            ContentValues contentValues = new ContentValues();
            for (int i=0; i < name.length; i++)
            {
                contentValues.put("name", name[i]);
                contentValues.put("population", population[i]);
                contentValues.put("region", region[i]);
                Log.d(DBHelper.LOG_TAG, "id = " + db.insert(DBHelper.TABLE_NAME, null, contentValues));
            }
        }
        // удаляем курсор
        cursor.close();
        // эмитируем нажатие кнопки
        onClick(btnAll);
    }

    @Override
    public void onClick(View v) {
        Cursor cursor = null;
        // подключение к созданной БД
        db = dbHelper.getWritableDatabase();

        // данные с экрана
        String funcField = etFunc.getText().toString();
        String populMoreThenField = etPopulMoreThen.getText().toString();
        String regPopulMoreThenField = etRegPopulMoreThen.getText().toString();

        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        switch (v.getId())
        {
            // все записи
            case R.id.btnAll:
                Log.d(DBHelper.LOG_TAG, "--- Все записи ---");
                cursor = db.query(DBHelper.TABLE_NAME, null, null,null, null, null,null);
                break;
            // записи по функции
            case R.id.btnFunc:
                Log.d(DBHelper.LOG_TAG, "--- Функия "+ funcField + " ---");
                columns = new String[] {funcField};
                cursor = db.query(DBHelper.TABLE_NAME, columns, null, null, null, null,null);
                break;
            // записи с населением больше введенного значения
            case R.id.btnPopulMoreThen:
                Log.d(DBHelper.LOG_TAG, "--- Записи с населением больше " + populMoreThenField + " миллионов ---");
                selection = "people > ?";
                selectionArgs = new String[] {populMoreThenField};
                cursor = db.query(DBHelper.TABLE_NAME, null, selection, selectionArgs, null, null,null);
                break;
            // записи по региону
            case R.id.btnRegPopul:
                Log.d(DBHelper.LOG_TAG, "--- Население по региону ---");
                columns = new String[] { "region", "sum(people) as people"};
                groupBy = "region";
                cursor = db.query(DBHelper.TABLE_NAME, columns, null, null, groupBy,null, null );
                break;
            // записи по региону и больше чем заданное значение
            case R.id.btnRegPopulMoreThen:
                Log.d(DBHelper.LOG_TAG, "--- Население по региону и больше " + regPopulMoreThenField + " миллионов ---");
                columns = new String[] {"region", "sum(people) as people"};
                groupBy = "region";
                having = "sum(people) > " + regPopulMoreThenField;
                cursor = db.query(DBHelper.TABLE_NAME, columns, null, null, groupBy, having, null);
                break;
            case R.id.btnSort:
                switch (rgSortBy.getCheckedRadioButtonId())
                {
                    case R.id.rbSortByName:
                        Log.d(DBHelper.LOG_TAG, "--- Сортировка по имени ---");
                        orderBy = "name";
                        break;
                    case R.id.rbSortByPopul:
                        Log.d(DBHelper.LOG_TAG, "--- Сортировка по населению ---");
                        orderBy = "population";
                        break;
                    case R.id.rbSortByReg:
                        Log.d(DBHelper.LOG_TAG, "--- Сортировка по региону ---");
                        orderBy = "region";
                        break;
                }
                cursor = db.query(DBHelper.TABLE_NAME, null, null, null, null, null, orderBy);
                break;
        }

        if(cursor != null)
        {
            if(cursor.moveToFirst())
            {
                String str;
                do {
                    str = "";
                    for (String cn : cursor.getColumnNames())
                    {
                        str = str.concat(cn + " = " + cursor.getString(cursor.getColumnIndex(cn)) + "; ");
                    }
                    Log.d(DBHelper.LOG_TAG, str);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } else
            Log.d(DBHelper.LOG_TAG, "Error: Cursor is null");

        dbHelper.close();
    }
}
