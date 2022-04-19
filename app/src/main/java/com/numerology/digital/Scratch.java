package com.numerology.digital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.anupkumarpanwar.scratchview.ScratchView;
import com.numerology.digital.model.quotesModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Scratch extends AppCompatActivity {
    ArrayList<quotesModel> holder;

    private SimpleDateFormat simpleDateFormat;
    private int day;
    private int month;
    private String date;
    private TextView scratchText;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scratch);
        ScratchView scratchView = findViewById(R.id.scratch_view);
        scratchText = findViewById(R.id.textScratchh);
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
        list();
        Calendar cal = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd");
        day = Integer.parseInt(simpleDateFormat.format(cal.getTime()));
        simpleDateFormat = new SimpleDateFormat("MM");
        month = Integer.parseInt(simpleDateFormat.format(cal.getTime()));

        date = String.valueOf(day + "/" + month);

        for (int i = 0; i <= holder.size(); i++) {
            if (holder.get(i).getDate().equals(date)) {
                scratchText.setText(String.valueOf(holder.get(i).getQuotes()));
                break;
            }
        }
//        int i=0;
//        while (holder.get(i).getDate().equals(date)){
//            scratchText.setText(holder.get(i).getQuotes());
//            i++;
//        }


    }

    private ArrayList<quotesModel> list() {

        holder = new ArrayList<>();
        quotesModel quote1 = new quotesModel("19/4", "“All our dreams can come true, if we have the courage to pursue them.”");
        holder.add(quote1);
        quotesModel quote2 = new quotesModel("20/4", "“The secret of getting ahead is getting started.”");
        holder.add(quote2);
        quotesModel quote3 = new quotesModel("21/4", "“I’ve missed more than 9,000 shots in my career. I’ve lost almost 300 games. 26 times I’ve been trusted to take the game winning shot and missed. I’ve failed over and over and over again in my life and that is why I succeed.”");
        holder.add(quote3);
        quotesModel quote4 = new quotesModel("22/4", "“Don’t limit yourself. Many people limit themselves to what they think they can do. You can go as far as your mind lets you. What you believe, remember, you can achieve.”");
        holder.add(quote4);
        quotesModel quote6 = new quotesModel("24/4", "“The best time to plant a tree was 20 years ago. The second best time is now.”");
        holder.add(quote6);
        quotesModel quote7 = new quotesModel("25/4", "“Only the paranoid survive.”");
        holder.add(quote7);

        quotesModel quote8 = new quotesModel("26/4", "“It’s hard to beat a person who never gives up.”");
        holder.add(quote8);
        quotesModel quote9 = new quotesModel("27/4", "“I wake up every morning and think to myself, ‘how far can I push this company in the next 24 hours.’”");
        holder.add(quote9);
        quotesModel quote10 = new quotesModel("28/4", "If people are doubting how far you can go, go so far that you can’t hear them anymore.” ");
        holder.add(quote10);
        quotesModel quote11 = new quotesModel("29/4", "“We need to accept that we won’t always make the right decisions, that we’ll screw up royally sometimes – understanding that failure is not the opposite of success, it’s part of success.”");
        holder.add(quote11);


        quotesModel quote12 = new quotesModel("30/4", "“Write it. Shoot it. Publish it. Crochet it, sauté it, whatever. MAKE.”");
        holder.add(quote12);
        quotesModel quote13 = new quotesModel("1/5", "“You’ve gotta dance like there’s nobody watching, love like you’ll never be hurt, sing like there’s nobody listening, and live like it’s heaven on earth.”");
        holder.add(quote13);
        quotesModel quote14 = new quotesModel("2/5", "“Fairy tales are more than true: not because they tell us that dragons exist, but because they tell us that dragons can be beaten.”");
        holder.add(quote14);
        quotesModel quote15 = new quotesModel("3/5", "“Everything you can imagine is real.”");
        holder.add(quote15);
        quotesModel quote16 = new quotesModel("4/5", "“When one door of happiness closes, another opens; but often we look so long at the closed door that we do not see the one which has been opened for us.” ");
        holder.add(quote16);
        quotesModel quote17 = new quotesModel("5/5", "“Do one thing every day that scares you.”");
        holder.add(quote17);
        quotesModel quote18 = new quotesModel("6/5", "“It’s no use going back to yesterday, because I was a different person then.”");
        holder.add(quote18);
        quotesModel quote19 = new quotesModel("7/5", "“Smart people learn from everything and everyone, average people from their experiences, stupid people already have all the answers.” ");
        holder.add(quote19);
        quotesModel quote20 = new quotesModel("8/5", "“Do what you feel in your heart to be right – for you’ll be criticized anyway.”");
        holder.add(quote20);
        quotesModel quote21 = new quotesModel("9/5", "“Happiness is not something ready made. It comes from your own actions.”");
        holder.add(quote21);
        quotesModel quote22 = new quotesModel("10/5", "“Whatever you are, be a good one.”");
        holder.add(quote22);
        quotesModel quote23 = new quotesModel("11/5", "“The same boiling water that softens the potato hardens the egg. It’s what you’re made of. Not the circumstances.” ");
        holder.add(quote23);
        quotesModel quote24 = new quotesModel("12/5", "“If we have the attitude that it’s going to be a great day it usually is.” ");
        holder.add(quote24);
        quotesModel quote25 = new quotesModel("13/5", "“You can either experience the pain of discipline or the pain of regret. The choice is yours.”");
        holder.add(quote25);
        quotesModel quote26 = new quotesModel("14/5", "“Impossible is just an opinion.”");
        holder.add(quote26);
        quotesModel quote27 = new quotesModel("15/5", "“Your passion is waiting for your courage to catch up.” ");
        holder.add(quote27);
        quotesModel quote28 = new quotesModel("16/5", "“Magic is believing in yourself. If you can make that happen, you can make anything happen.” ");
        holder.add(quote28);
        quotesModel quote29 = new quotesModel("17/5", "“If something is important enough, even if the odds are stacked against you, you should still do it.”");
        holder.add(quote29);
        quotesModel quote30 = new quotesModel("18/5", "“Hold the vision, trust the process.”");
        holder.add(quote30);
        quotesModel quote31 = new quotesModel("19/5", "“Don’t be afraid to give up the good to go for the great.”");
        holder.add(quote31);



        return holder;
    }
}