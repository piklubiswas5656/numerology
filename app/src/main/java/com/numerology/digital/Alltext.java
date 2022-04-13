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
    private TextView redaingtext, redingdes, whatistext, whatisdes;
    private TextView howtodes, toolbartext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alltext);
        getSupportActionBar().hide();
        intil();
        onclick();
        getname = getIntent().getStringExtra(Constant.ALLTEXTREADING);


        condi();

    }

    private void condi() {
        if (getname.equals("Expression")) {
            whatistext.setText(R.string.Expressionwhatistitle);
            whatisdes.setText(R.string.ExpresionWhatisdes);
            howtodes.setText(R.string.ExpresionHowtodes);
            toolbartext.setText("Expression");

        } else if (getname.equals("Personality")) {
            whatistext.setText(R.string.PersonalityWhatistitle);
            whatisdes.setText(R.string.PersonalityWhatisdes);
            howtodes.setText(R.string.PersonalityHowtodes);
            toolbartext.setText("Personality");
        } else if (getname.equals("Soul")) {
            whatistext.setText(R.string.SoulUrgeWhatistitle);
            whatisdes.setText(R.string.SoulUrgeWhatisdes);
            howtodes.setText(R.string.SoulUrgeHowtodes);
            toolbartext.setText("Soul");
        } else if (getname.equals("LifePath")) {
            whatistext.setText(R.string.LifePathWhatistitle);
            whatisdes.setText(R.string.LifePathWhatisdes);
            howtodes.setText(R.string.LifePathHowtodes);
            toolbartext.setText("LifePath");
        } else if (getname.equals("Attitude")) {
            whatistext.setText(R.string.AttitudeWhatistitle);
            whatisdes.setText(R.string.AttitudeWhatisdes);
            howtodes.setText(R.string.AttitudeHowtodes);
            toolbartext.setText("Attitudeh");
        } else if (getname.equals("Birth")) {
            whatistext.setText(R.string.BirthWhatistitle);
            whatisdes.setText(R.string.BirthWhatisdes);
            howtodes.setText(R.string.BirthHowtodes);
            toolbartext.setText("Birth");
        }
    }

    private void intil() {
        toolbartext = findViewById(R.id.toolbartext);
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
        whatistext = findViewById(R.id.WhatisText);
        whatisdes = findViewById(R.id.WhatIsfullText);
        howtodes = findViewById(R.id.HowTofullText);
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