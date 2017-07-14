package com.example.android.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean flag = true;
    public void drop (View view) {

        ImageView counter = (ImageView)view;
        counter.setTranslationY(-1000f);
        counter.setTranslationX(-1000f);

//        int height = counter.getLayoutParams().height;
//        int width = counter.getLayoutParams().width;
//        String str = height + " " + width;
//        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

        if (flag) {
            counter.setImageResource(R.drawable.yellow);
            flag = false;
        } else {
            counter.setImageResource(R.drawable.red);
            flag = true;
        }

        counter.animate().translationYBy(1000f).translationXBy(1000f).setDuration(300);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
