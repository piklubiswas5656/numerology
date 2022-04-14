package com.numerology.digital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Number_Activity extends AppCompatActivity {
    private String getNumber, namenumber;
    private TextView Personality_text, toolbartext_one, toolbartext_two;
    private ImageView backbutton, readingimage, whatisiamge;
    private LinearLayout compatibilityreadingliner, compatibilitywhatisredinglinier;
    private CardView readingcardview, whatiscardview;
    private boolean ReadingCheck = false, whatisCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        getSupportActionBar().hide();
        initt();
        condi();
        onclick();


    }

    private void initt() {
        readingcardview = findViewById(R.id.readingcardview);
        whatiscardview = findViewById(R.id.WhatisCardview);
        readingimage = findViewById(R.id.ReadingImage);
        whatisiamge = findViewById(R.id.WhatIsImage);
        Personality_text = findViewById(R.id.compatibilityreadingtext);
        toolbartext_one = findViewById(R.id.toolbartextone);
        toolbartext_two = findViewById(R.id.toolbartexttwo);
        backbutton = findViewById(R.id.btnCloseResultLayoutt);
        compatibilityreadingliner = findViewById(R.id.ReadingLiner2);
        compatibilitywhatisredinglinier = findViewById(R.id.WhatIsLinertwo);
        backbutton.setOnClickListener(v -> onBackPressed());
        SharedPreferences getShared = getApplicationContext().getSharedPreferences(Constant.USER, MODE_PRIVATE);

        namenumber = getShared.getString(Constant.NAMENUMBER, "1");
        getNumber = getIntent().getStringExtra(Constant.PERSONALITYNUMBER);
        toolbartext_one.setText(String.valueOf(namenumber));
    }

    private void onclick() {
        readingcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ReadingCheck) {

                    readingimage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                    compatibilityreadingliner.setVisibility(View.VISIBLE);
                    ReadingCheck = false;
                } else if (!ReadingCheck) {

                    readingimage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                    compatibilityreadingliner.setVisibility(View.GONE);
                    ReadingCheck = true;
                }
            }
        });

        whatiscardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (whatisCheck) {
                    readingimage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                    compatibilitywhatisredinglinier.setVisibility(View.GONE);

                    whatisCheck = false;
                } else if (!whatisCheck) {
                    readingimage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                    compatibilitywhatisredinglinier.setVisibility(View.VISIBLE);

                    whatisCheck = true;
                }
            }
        });

    }

    private void condi() {
        if (getNumber.equals(Constant.ONE)) {
            Personality_text.setText(R.string.one);
            toolbartext_two.setText(String.valueOf("1"));
        } else if (getNumber.equals(Constant.TWO)) {
            Personality_text.setText(R.string.two);
            toolbartext_two.setText(String.valueOf("2"));
        } else if (getNumber.equals(Constant.TREE)) {
            Personality_text.setText(R.string.three);
            toolbartext_two.setText(String.valueOf("3"));
        } else if (getNumber.equals(Constant.FOUR)) {
            Personality_text.setText(R.string.four);
            toolbartext_two.setText(String.valueOf("4"));
        } else if (getNumber.equals(Constant.FIVE)) {
            Personality_text.setText(R.string.five);
            toolbartext_two.setText(String.valueOf("5"));
        } else if (getNumber.equals(Constant.SIX)) {
            Personality_text.setText(R.string.six);
            toolbartext_two.setText(String.valueOf("6"));
        } else if (getNumber.equals(Constant.SEVEN)) {
            Personality_text.setText(R.string.seven);
            toolbartext_two.setText(String.valueOf("7"));
        } else if (getNumber.equals(Constant.EIGHT)) {
            Personality_text.setText(R.string.eight);
            toolbartext_two.setText(String.valueOf("8"));
        } else if (getNumber.equals(Constant.NINE)) {
            Personality_text.setText(R.string.nine);
            toolbartext_two.setText(String.valueOf("9"));
        }
    }
}