package com.numerology.digital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Alltext extends AppCompatActivity {
    private ImageView backbutton;
    private ImageView redingImage, whatisImage, howtoImage;
    private Boolean ReadingCheck = true, whatisCheck = false, howtoCheck = false;
    private LinearLayout redingliner2, whatisliner2, howtoliner2;
    private CardView readingCardview, whatiscardview, howtoCardView;
    private String getname;
    private TextView redaingtext, redingdes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alltext);
        intil();
        onclick();
        getname = getIntent().getStringExtra(Constant.ALLTEXTREADING);



    }

    private void intil() {
        backbutton = findViewById(R.id.btnCloseResultLayout);
        backbutton.setOnClickListener(v -> onBackPressed());
        redingImage = findViewById(R.id.ReadingImage);
        redingliner2 = findViewById(R.id.ReadingLiner2);
        readingCardview = findViewById(R.id.readingcardview);
        whatiscardview = findViewById(R.id.WhatisCardview);
        howtoCardView = findViewById(R.id.howToCardView);
        whatisImage = findViewById(R.id.WhatIsImage);
        whatisliner2 = findViewById(R.id.WhatIsLiner2);
        howtoliner2 = findViewById(R.id.HowToLiner2);
        howtoImage = findViewById(R.id.HowToImage);
        redaingtext = findViewById(R.id.ReadingText);
        redingdes = findViewById(R.id.ReadingfullText);
    }

    private void onclick() {
        readingCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ReadingCheck) {

                    redingImage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                    redingliner2.setVisibility(View.VISIBLE);
                    ReadingCheck = false;
                } else if (!ReadingCheck) {

                    redingImage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                    redingliner2.setVisibility(View.GONE);
                    ReadingCheck = true;
                }
            }
        });

        whatiscardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (whatisCheck) {
                    whatisImage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                    whatisliner2.setVisibility(View.GONE);

                    whatisCheck = false;
                } else if (!whatisCheck) {
                    whatisImage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                    whatisliner2.setVisibility(View.VISIBLE);

                    whatisCheck = true;
                }
            }
        });
        howtoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (howtoCheck) {
                    howtoImage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                    howtoliner2.setVisibility(View.GONE);

                    howtoCheck = false;
                } else if (!howtoCheck) {
                    howtoImage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                    howtoliner2.setVisibility(View.VISIBLE);

                    howtoCheck = true;
                }
            }
        });
    }

    private void initcheck() {
        if (ReadingCheck) {

            redingImage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
            redingliner2.setVisibility(View.VISIBLE);
            ReadingCheck = false;
        } else if (!ReadingCheck) {

            redingImage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
            redingliner2.setVisibility(View.GONE);
            ReadingCheck = true;
        }


        if (whatisCheck) {
            whatisImage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
            whatisliner2.setVisibility(View.GONE);

            whatisCheck = false;
        } else if (!whatisCheck) {
            whatisImage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
            whatisliner2.setVisibility(View.VISIBLE);

            whatisCheck = true;
        }

        if (howtoCheck) {
            howtoImage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
            howtoliner2.setVisibility(View.GONE);

            howtoCheck = false;
        } else if (!howtoCheck) {
            howtoImage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
            howtoliner2.setVisibility(View.VISIBLE);

            howtoCheck = true;
        }
    }


}