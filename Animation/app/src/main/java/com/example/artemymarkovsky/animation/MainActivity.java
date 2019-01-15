package com.example.artemymarkovsky.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView textView;

    final int MENU_ALPHA_ID = 1;
    final int MENU_SCALE_ID = 2;
    final int MENU_MOVE_ID = 3;
    final int MENU_ROTATE_ID = 4;
    final int MENU_MIX_ID = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId())
        {
            case R.id.textView:
            {
                menu.add(0, MENU_ALPHA_ID, 0, "alpha");
                menu.add(0, MENU_SCALE_ID, 0, "scale");
                menu.add(0, MENU_MOVE_ID, 0, "move");
                menu.add(0, MENU_ROTATE_ID, 0,"rotate");
                menu.add(0, MENU_MIX_ID, 0, "mix");
                break;
            }
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        Animation anim = null;

        switch (item.getItemId())
        {
            case MENU_ALPHA_ID:
            {
                anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
                break;
            }
            case MENU_SCALE_ID:
            {
                anim = AnimationUtils.loadAnimation(this, R.anim.scale);
                break;
            }
            case MENU_MOVE_ID:
            {
                anim = AnimationUtils.loadAnimation(this, R.anim.move);
                break;
            }
            case MENU_ROTATE_ID:
            {
                anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
                break;
            }
            case MENU_MIX_ID:
            {
                anim = AnimationUtils.loadAnimation(this, R.anim.mix);
                break;
            }
        }
        textView.startAnimation(anim);
        return super.onContextItemSelected(item);
    }
}
