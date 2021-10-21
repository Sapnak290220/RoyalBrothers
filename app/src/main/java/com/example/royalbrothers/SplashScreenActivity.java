package com.example.royalbrothers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                SharedPreferences prefs = getSharedPreferences("myPref", MODE_PRIVATE);
                String name = prefs.getString("activity","not Yet");//"No name defined" is the default value.


                if(name.equalsIgnoreCase("not Yet"))
                {
                    Intent i=new Intent(SplashScreenActivity.this, OnBoardingScreenActivity.class);
                    startActivity(i);
                }
                else {
                    Intent i=new Intent(SplashScreenActivity.this, HomeScreenActivity.class);
                    startActivity(i);
                }

                //Intent is used to switch from one activity to another.


                //invoke the SecondActivity.

                finish();
                //the current activity will get finished.
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}