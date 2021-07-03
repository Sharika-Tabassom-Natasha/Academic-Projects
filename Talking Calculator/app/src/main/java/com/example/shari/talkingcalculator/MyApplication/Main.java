package com.example.shari.talkingcalculator.MyApplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shari.talkingcalculator.R;

public class Main extends AppCompatActivity {

    private  static int time = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Main.this,Menu.class);
                startActivity(i);
                finish();
            }
        },time);
    }
}
