package com.numerology.digital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Rasifal extends AppCompatActivity {
    TextView rasifalText;
    String rasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasifal);
        rasifalText = findViewById(R.id.rasifaltext);
        rasi = getIntent().getStringExtra(Constant.RASIFALTEXT);
        if (rasi.equals("Aries")) {
            rasifalText.setText(R.string.Aries);
        }else if(rasi.equals("Taurus")){
            rasifalText.setText(R.string.Taurus);
        }else if(rasi.equals("Gemini")){
            rasifalText.setText(R.string.Gemini);
        }
        else if(rasi.equals("Cancer")){
            rasifalText.setText(R.string.Cancer);
        }
        else if(rasi.equals("Leo")){
            rasifalText.setText(R.string.Leo);
        }
        else if(rasi.equals("Virgo")){
            rasifalText.setText(R.string.Virgo);
        }
        else if(rasi.equals("Libra")){
            rasifalText.setText(R.string.Libra);
        }
        else if(rasi.equals("Scorpio")){
            rasifalText.setText(R.string.Scorpio);
        }
        else if(rasi.equals("Sagittarius")){
            rasifalText.setText(R.string.Sagittarius);
        }
        else if(rasi.equals("Capricorn")){
            rasifalText.setText(R.string.Capricorn);
        }
        else if(rasi.equals("Aquarius")){
            rasifalText.setText(R.string.Aquarius);
        }
        else if(rasi.equals("Pisces")){
            rasifalText.setText(R.string.Pisces);
        }

    }
}