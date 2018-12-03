package com.example.artemymarkovsky.trytodosomething;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    TextView myMainText;
    Button myButton1;
    Button myButton2;
    Button myButton3;
    ImageView image;
    MenuItem item4;

    TextView textColor;
    TextView textSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myMainText = findViewById(R.id.textView1);
        myButton1 = findViewById(R.id.button1);
        myButton2 = findViewById(R.id.button2);
        myButton3 = findViewById(R.id.button3);

        View.OnClickListener OnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this, "Нажата кнопка", Toast.LENGTH_SHORT);
                switch (v.getId())
                {
                    case R.id.button1:
                        myMainText.setText("нажал кнопку 1");
                        toast.show();
                        break;
                    case R.id.button2:
                        if (myButton3.isEnabled())
                        {
                            myButton3.setEnabled(false);
                            item4.setChecked(false);
                        }
                        else
                        {
                            myButton3.setEnabled(true);
                            item4.setChecked(true);
                        }
                        toast.show();
                        break;
                    case R.id.button3:
                        myMainText.setText("кнопочка 3");
                        toast.show();
                        break;
                    case R.id.textView1:
                    {
                        myButton1.setEnabled(true);
                        myButton2.setEnabled(true);
                        myButton3.setEnabled(true);
                        toast.show();
                        break;
                    }
                }
            }
        };

        myButton1.setOnClickListener(OnClickListener);
        myButton2.setOnClickListener(OnClickListener);
        myButton3.setOnClickListener(OnClickListener);
        myMainText.setOnClickListener(OnClickListener);

        image = findViewById(R.id.imageView1);
        image.setImageResource(R.drawable.ic_launcher_foreground);

        textColor = findViewById(R.id.textColor);
        textSize = findViewById(R.id.textSize);
        registerForContextMenu(textColor);
        registerForContextMenu(textSize);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        item4 = menu.add(Menu.NONE, 4, Menu.NONE, "item4").setCheckable(true);
        if (myButton3.isEnabled()) {
            item4.setChecked(true);
        }
        else {
            item4.setChecked(false);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId())
        {
            case R.id.settings:
            {
                Toast.makeText(MainActivity.this, R.string.menuItem, Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.item1:
            {
                Toast.makeText(MainActivity.this, R.string.menuItem, Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.item2:
            {
                Toast.makeText(MainActivity.this, R.string.menuItem, Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.item3:
            {
                Toast.makeText(MainActivity.this, R.string.menuItem, Toast.LENGTH_SHORT).show();
                break;
            }
            case 4:
            {
                if (myButton3.isEnabled())
                {
                    myButton3.setEnabled(false);
                    item4.setChecked(false);
                }
                else
                {
                    myButton3.setEnabled(true);
                    item4.setChecked(true);
                }

                Toast.makeText(MainActivity.this, R.string.menuItem, Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        switch(v.getId())
        {
            case R.id.textColor:
            {
                getMenuInflater().inflate(R.menu.color_context, menu);
                break;
            }
            case R.id.textSize:
            {
                getMenuInflater().inflate(R.menu.size_context, menu);
                break;
            }
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.colorRed:
            {
                textColor.setTextColor(Color.RED);
                break;
            }
            case R.id.colorBlue:
            {
                textColor.setTextColor(Color.BLUE);
                break;
            }
            case R.id.colorGreen:
            {
                textColor.setTextColor(Color.GREEN);
                break;
            }
            case R.id.textSize22:
            {
                textSize.setTextSize(22);
                break;
            }
            case R.id.textSize27:
            {
                textSize.setTextSize(27);
                break;
            }
            case R.id.textSize32:
            {
                textSize.setTextSize(32);
                break;
            }
        }
        return super.onContextItemSelected(item);
    }
}
