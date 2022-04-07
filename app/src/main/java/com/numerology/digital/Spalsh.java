package com.numerology.digital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class Spalsh extends AppCompatActivity {


    /**
     * Duration of wait
     **/
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_spalsh);
        //hide actionbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                checkuserExistence();
                Spalsh.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    public void checkuserExistence() {
        SharedPreferences sp = getSharedPreferences(Constant.USER, MODE_PRIVATE);
        if (sp.contains(Constant.FIRSTNAME)) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        } else
            startActivity(new Intent(getApplicationContext(), FillYourDetail.class));
    }
}