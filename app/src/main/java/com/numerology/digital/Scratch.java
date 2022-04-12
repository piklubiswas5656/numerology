package com.numerology.digital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.anupkumarpanwar.scratchview.ScratchView;

public class Scratch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scratch);
        ScratchView scratchView = findViewById(R.id.scratch_view);
        getSupportActionBar().hide();
        scratchView.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {

                Toast.makeText(getApplicationContext(), "Reveled", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
                if (percent >= 50) {
                    scratchView.isRevealed();
                    Toast.makeText(getApplicationContext(), "50% Reveled", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}