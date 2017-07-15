package com.example.android.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //0 is red, 1 is yello, 2 is empty
    int colour = 0;
    int[] checked = {2,2,2,2,2,2,2,2,2};
    int[][] winner = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void drop (View view) {

        ImageView counter = (ImageView)view;
        int tag = Integer.parseInt(counter.getTag().toString());
        if (checked[tag] == 2) {
            counter.setTranslationY(-1000f);
            counter.setTranslationX(-1000f);
            checked[tag] = colour;
            if (colour == 0) {
                counter.setImageResource(R.drawable.red);
                colour = 1;
            } else {
                counter.setImageResource(R.drawable.yellow);
                colour = 0;
            }
            counter.animate().translationYBy(1000f).translationXBy(1000f).setDuration(300);
            for (int i = 0; i < 8; i++) {
                if (checked[winner[i][0]] == 0 && checked[winner[i][1]] == 0 && checked[winner[i][2]] == 0){
                    Toast.makeText(MainActivity.this, "Red is Winner", Toast.LENGTH_SHORT).show();
                    break;
                } else if (checked[winner[i][0]] == 1 && checked[winner[i][1]] == 1 && checked[winner[i][2]] == 1){
                    Toast.makeText(MainActivity.this, "yellow is Winner", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
