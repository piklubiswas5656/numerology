package com.numerology.digital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Number_Activity extends AppCompatActivity {
    private String getNumber;
    private TextView Personality_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        Personality_text = findViewById(R.id.Personality_text);
        getNumber = getIntent().getStringExtra(Constant.PERSONALITYNUMBER);
        if (getNumber.equals(Constant.ONE)) {
            Personality_text.setText(R.string.one);
        } else if (getNumber.equals(Constant.TWO)) {
            Personality_text.setText(R.string.two);
        } else if (getNumber.equals(Constant.TREE)) {
            Personality_text.setText(R.string.three);
        } else if (getNumber.equals(Constant.FIVE)) {
            Personality_text.setText(R.string.five);
        } else if (getNumber.equals(Constant.SIX)) {
            Personality_text.setText(R.string.six);
        } else if (getNumber.equals(Constant.SEVEN)) {
            Personality_text.setText(R.string.seven);
        } else if (getNumber.equals(Constant.EIGHT)) {
            Personality_text.setText(R.string.eight);
        } else if (getNumber.equals(Constant.NINE)) {
            Personality_text.setText(R.string.nine);
        }

    }
}