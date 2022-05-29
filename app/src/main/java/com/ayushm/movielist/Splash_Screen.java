package com.ayushm.movielist;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.ayushm.movielist.task1.Task1Activity;
import com.ayushm.movielist.task2.MainActivity;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView task1,task2;

        task1 = (TextView) findViewById(R.id.task_1);
        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tasku1 = new Intent(Splash_Screen.this, Task1Activity.class);
                startActivity(tasku1);
            }
        });

        task2 = (TextView) findViewById(R.id.task_2);
        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tasku2 = new Intent(Splash_Screen.this, MainActivity.class);
               startActivity(tasku2);
            }
        });
    }
}