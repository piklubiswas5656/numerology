package com.numerology.digital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HealthWork extends AppCompatActivity {
    private String getHelathandWork;
    private CardView healthcardview;
    private TextView readingtext, readingdes;
    private boolean ReadingCheck = true;
    private ImageView ReadingImage, backbutton;
    private LinearLayout redingliner2;
    private TextView toolbartext;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_work);
        getSupportActionBar().hide();
        inint();
        condi();
        onclick();
    }

    private void inint() {
        toolbartext = findViewById(R.id.toolbartextt);
        backbutton = findViewById(R.id.btnCloseResultLayoutt);
        backbutton.setOnClickListener(v -> onBackPressed());
        healthcardview = findViewById(R.id.halthcardview);
        readingtext = findViewById(R.id.ReadingTextt);
        readingdes = findViewById(R.id.Readingdes);
        ReadingImage = findViewById(R.id.ReadingImage);
        redingliner2 = findViewById(R.id.ReadingLiner22);
        getHelathandWork = getIntent().getStringExtra(Constant.ALLTEXTREADING);
    }

    private void condi() {
        if (getHelathandWork.equals("Behaviour")) {
            readingtext.setText(R.string.behaviourtitle);
            toolbartext.setText("Behaviour");

        } else if (getHelathandWork.equals("Career")) {
            readingtext.setText(R.string.careertitle);
            toolbartext.setText("Career");

        } else if (getHelathandWork.equals("Health")) {
            readingtext.setText(R.string.healthtitle);
            toolbartext.setText("Health");
        } else if (getHelathandWork.equals("Money")) {
            readingtext.setText(R.string.moneytitle);
            toolbartext.setText("Money");
        }
    }


    private void onclick() {
        healthcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ReadingCheck) {

                    ReadingImage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                    redingliner2.setVisibility(View.VISIBLE);
                    ReadingCheck = false;
                } else if (!ReadingCheck) {

                    ReadingImage.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                    redingliner2.setVisibility(View.GONE);
                    ReadingCheck = true;
                }
            }
        });
    }
}