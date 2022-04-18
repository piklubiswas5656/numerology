package com.numerology.digital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.numerology.digital.Fragment.Affirmation_Fragment;
import com.numerology.digital.Fragment.Comatibility_Fragment;
import com.numerology.digital.Fragment.HealthWork_Fragment;
import com.numerology.digital.Fragment.MyProfile_Fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context = MainActivity.this;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private ImageView imageView;
    private TextView textView_actionBar;
    private LinearLayout bottomnavmyprfile, bottomnavCompatibility, bottomnavHealthandwork, bottomnavaffirmation;
    private LinearLayout main, comp, halth, affirmatin;
    //bottomnavigation text
    private TextView BottomBtnoneText, BottomBtntwoText, BottomBtntreeText, BottomBtnfourText;

    private String firstname, lastname;
    private int tempint, expressiontempint;
    private int temp, temptwo, temptree, expressiontemp, expressiontemptwo, expressiontemptree;
    private String lifeday, lifemonth, lifeyear;
    String name;
    private int digitvalue, expressiondigitvalue;
    private int finaldigit, expressionfinaldigit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        navigationViewitemclick();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        allbottomtexthide();

        getSupportFragmentManager().beginTransaction().replace(R.id.liner_main, new MyProfile_Fragment()).commit();
        onclick();
        try {

            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);
            textView_actionBar = (TextView) findViewById(getResources().getIdentifier("action_bar_textView", "id", getPackageName()));
            textView_actionBar.setText("Your_title");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    private void init() {
        Personalitynumber();
        Expressionnumber();
        Lifepath();
        attitude();
        Birthnumber();
        //bottomnavigation text
        BottomBtnoneText = findViewById(R.id.BottomBtnoneText);
        BottomBtntwoText = findViewById(R.id.BottomBtntwoText);
        BottomBtntreeText = findViewById(R.id.BottomBtnthreeText);
        BottomBtnfourText = findViewById(R.id.BottomBtnfourText);

        //bottomnavigation text end


        main = findViewById(R.id.liner_main);

        //navigation
        drawerLayout = findViewById(R.id.layoutParent);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView = findViewById(R.id.navigationDrawer);
        navigationView.setCheckedItem(R.id.navProfiles);
        //navigation end
        bottomnavmyprfile = findViewById(R.id.bottomnavmyprfile);
        bottomnavCompatibility = findViewById(R.id.bottomnavCompatibility);
        bottomnavHealthandwork = findViewById(R.id.bottomnavHealthandwork);
        bottomnavaffirmation = findViewById(R.id.bottomnavaffirmation);


    }

    private void Personalitynumber() {
        SharedPreferences getShared = getSharedPreferences(Constant.USER, MODE_PRIVATE);
        firstname = getShared.getString(Constant.FIRSTNAME, "firstname");
        lastname = getShared.getString(Constant.LASTNAME, "lastname");
        name = firstname + lastname;
        String[] result = name.replaceAll("\\s", "").toUpperCase().split("");


        for (int x = 0; x < result.length; x++) {

            tempint = tempint + getPersonalityNumber(result[x]);
////            hello.append(String.valueOf(getPersonalityNumber(result[x])));
//            hello.append((String.valueOf(tempint) + "\n\n"));
        }


        if (tempint > 9) {
            digitvalue = tempint;

            List<Integer> digits = new ArrayList<Integer>();

            collectDigits(digitvalue, digits);
            for (int x = 0; x < digits.size(); x++) {

                temp = temp + digits.get(x);
////            hello.append(String.valueOf(getPersonalityNumber(result[x])));
//            hello.append((String.valueOf(tempint) + "\n\n"));
            }
            if (temp > 9) {

                List<Integer> digittwo = new ArrayList<Integer>();

                collectDigits(temp, digittwo);
                for (int x = 0; x < digittwo.size(); x++) {

                    temptwo = temptwo + digittwo.get(x);
////
                }
                if (temptwo > 9) {
                    List<Integer> digitthree = new ArrayList<Integer>();

                    collectDigits(temptwo, digitthree);
                    for (int x = 0; x < digitthree.size(); x++) {

                        temptree = temptree + digitthree.get(x);
////
                    }
                    finaldigit = temptree;
                } else {
                    finaldigit = temptwo;
                }


            } else {
                finaldigit = temp;
            }

        } else {
            finaldigit = tempint;

        }
        SharedPreferences sp = getSharedPreferences(Constant.USER, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Constant.NAMENUMBER, String.valueOf(finaldigit));
        editor.commit();
        editor.apply();
    }

    private void Expressionnumber() {
        SharedPreferences getShared = getSharedPreferences(Constant.USER, MODE_PRIVATE);
        firstname = getShared.getString(Constant.FIRSTNAME, "firstname");
        lastname = getShared.getString(Constant.LASTNAME, "lastname");
        String nameexpressin = firstname + lastname;
        String[] result = nameexpressin.replaceAll("\\s", "").toUpperCase().split("");


        for (int x = 1; x < result.length; x++) {

            expressiontempint = expressiontempint + getPersonalityNumber(result[x]);
////            hello.append(String.valueOf(getPersonalityNumber(result[x])));
//            hello.append((String.valueOf(tempint) + "\n\n"));
        }


        if (expressiontempint > 9) {
            if (expressiontempint == 11 || expressiontempint == 22) {
                expressionfinaldigit = expressiontempint;
            } else {
                expressiondigitvalue = expressiontempint;

                List<Integer> digits = new ArrayList<Integer>();

                collectDigits(expressiondigitvalue, digits);
                for (int x = 0; x < digits.size(); x++) {

                    expressiontemp = expressiontemp + digits.get(x);
////            hello.append(String.valueOf(getPersonalityNumber(result[x])));
//            hello.append((String.valueOf(tempint) + "\n\n"));
                }
                if (expressiontemp > 9) {
                    if (expressiontemp == 11 || expressiontemp == 22) {
                        expressionfinaldigit = expressiontemp;
                    } else {
                        List<Integer> digittwo = new ArrayList<Integer>();

                        collectDigits(expressiontemp, digittwo);
                        for (int x = 0; x < digittwo.size(); x++) {

                            expressiontemptwo = expressiontemptwo + digittwo.get(x);
////
                        }
                        if (expressiontemptwo > 9) {
                            if (expressiontemptwo == 11 || expressiontemptwo == 22) {
                                expressionfinaldigit = expressiontemptwo;
                            } else {
                                List<Integer> digitthree = new ArrayList<Integer>();

                                collectDigits(expressiontemptwo, digitthree);
                                for (int x = 0; x < digitthree.size(); x++) {

                                    expressiontemptree = expressiontemptree + digitthree.get(x);
////
                                }
                                expressionfinaldigit = expressiontemptree;
                            }
                        } else {
                            expressionfinaldigit = expressiontemptwo;
                        }

                    }
                } else {
                    expressionfinaldigit = expressiontemp;
                }

            }

        } else {
            expressionfinaldigit = expressiontempint;

        }
        SharedPreferences sp = getSharedPreferences(Constant.USER, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Constant.EXPRESSIONNUMBER, String.valueOf(expressionfinaldigit));
        editor.commit();
        editor.apply();
    }

    private void Lifepath() {
        SharedPreferences getShared = getSharedPreferences(Constant.USER, MODE_PRIVATE);
        lifeday = getShared.getString(Constant.DAY, "day");
        lifemonth = getShared.getString(Constant.MONTH, "lastname");
        lifeyear = getShared.getString(Constant.YEAR, "lastname");
        int yearlifetemp = 0, yearlifetemptwo = 0, yearlifetempthree = 0, yearlifefinal = 0;

        int montlifetemp = 0, monthlifetemptwo = 0, monthlifefinal;
        int daylifetemp = 0, daylifetemptwo = 0, daylifefinal = 0;
        int totaltemp = 0, totaltemptwo = 0, totaltempthree = 0, totaltempfour = 0, totalfinal = 0;
        //year
        int year = Integer.parseInt(lifeyear);

        List<Integer> digits = new ArrayList<Integer>();

        collectDigits(year, digits);
        for (int x = 0; x < digits.size(); x++) {

            yearlifetemp = yearlifetemp + digits.get(x);
        }
        if (yearlifetemp > 9) {
            List<Integer> digitstwo = new ArrayList<Integer>();

            collectDigits(yearlifetemp, digitstwo);
            for (int x = 0; x < digitstwo.size(); x++) {

                yearlifetemptwo = yearlifetemptwo + digitstwo.get(x);
            }
            if (yearlifetemptwo > 9) {
                List<Integer> digitstree = new ArrayList<Integer>();

                collectDigits(yearlifetemptwo, digitstree);
                for (int x = 0; x < digitstree.size(); x++) {

                    yearlifetempthree = yearlifetempthree + digitstree.get(x);
                }
                yearlifefinal = yearlifetempthree;
            } else {
                yearlifefinal = yearlifetemptwo;
            }
        } else {
            yearlifefinal = yearlifetemp;
        }
        //year end
        //month
        int month = Integer.parseInt(lifemonth);
        List<Integer> digitsmonth = new ArrayList<Integer>();
        collectDigits(month, digitsmonth);
        for (int x = 0; x < digitsmonth.size(); x++) {

            montlifetemp = montlifetemp + digitsmonth.get(x);
        }
        if (montlifetemp > 9) {
            List<Integer> digitsmonthtwo = new ArrayList<Integer>();
            collectDigits(montlifetemp, digitsmonthtwo);
            for (int x = 0; x < digitsmonthtwo.size(); x++) {

                monthlifetemptwo = monthlifetemptwo + digitsmonthtwo.get(x);
            }
            monthlifefinal = monthlifetemptwo;
        } else {
            monthlifefinal = montlifetemp;
        }
        //month end

        //day
        int day = Integer.parseInt(lifeday);
        List<Integer> digitsday = new ArrayList<Integer>();
        collectDigits(day, digitsday);
        for (int x = 0; x < digitsday.size(); x++) {

            daylifetemp = daylifetemp + digitsday.get(x);
        }
        if (daylifetemp > 9) {
            List<Integer> digitsdaytwo = new ArrayList<Integer>();
            collectDigits(daylifetemp, digitsdaytwo);
            for (int x = 0; x < digitsdaytwo.size(); x++) {

                daylifetemptwo = daylifetemptwo + digitsdaytwo.get(x);
            }
            daylifefinal = daylifetemptwo;
        } else {
            daylifefinal = daylifetemp;
        }
        //day end

        int finaltotal = yearlifefinal + monthlifefinal + daylifefinal;


        //final

        List<Integer> digitsfinal = new ArrayList<Integer>();
        collectDigits(finaltotal, digitsfinal);
        for (int x = 0; x < digitsfinal.size(); x++) {

            totaltemp = totaltemp + digitsfinal.get(x);
        }
        if (totaltemp > 9) {
            List<Integer> digitsfinaltwo = new ArrayList<Integer>();
            collectDigits(totaltemp, digitsfinaltwo);
            for (int x = 0; x < digitsfinaltwo.size(); x++) {

                totaltemptwo = totaltemptwo + digitsfinaltwo.get(x);
            }
            if (totaltemptwo > 9) {
                List<Integer> digitsfinalthree = new ArrayList<Integer>();
                collectDigits(totaltemptwo, digitsfinalthree);
                for (int x = 0; x < digitsfinalthree.size(); x++) {

                    totaltempthree = totaltempthree + digitsfinalthree.get(x);
                }
                totalfinal = totaltempthree;
            } else {
                totalfinal = totaltemptwo;
            }
        } else {
            totalfinal = totaltemp;
        }


        //final end


        SharedPreferences sp = getSharedPreferences(Constant.USER, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Constant.LIFEPATH, String.valueOf(totalfinal));
        editor.commit();
        editor.apply();

    }

    private void attitude() {

        SharedPreferences getShared = getSharedPreferences(Constant.USER, MODE_PRIVATE);
        String dayy = getShared.getString(Constant.DAY, "day");
        String monthh = getShared.getString(Constant.MONTH, "lastname");
        int montlifetemp = 0, monthlifetemptwo = 0, monthlifefinal;
        int daylifetemp = 0, daylifetemptwo = 0, daylifefinal = 0;
        //month
        int month = Integer.parseInt(monthh);
        List<Integer> digitsmonth = new ArrayList<Integer>();
        collectDigits(month, digitsmonth);
        for (int x = 0; x < digitsmonth.size(); x++) {

            montlifetemp = montlifetemp + digitsmonth.get(x);
        }
        if (montlifetemp > 9) {
            List<Integer> digitsmonthtwo = new ArrayList<Integer>();
            collectDigits(montlifetemp, digitsmonthtwo);
            for (int x = 0; x < digitsmonthtwo.size(); x++) {

                monthlifetemptwo = monthlifetemptwo + digitsmonthtwo.get(x);
            }
            monthlifefinal = monthlifetemptwo;
        } else {
            monthlifefinal = montlifetemp;
        }
        //month end

        //day
        int day = Integer.parseInt(dayy);
        List<Integer> digitsday = new ArrayList<Integer>();
        collectDigits(day, digitsday);
        for (int x = 0; x < digitsday.size(); x++) {

            daylifetemp = daylifetemp + digitsday.get(x);
        }
        if (daylifetemp > 9) {
            List<Integer> digitsdaytwo = new ArrayList<Integer>();
            collectDigits(daylifetemp, digitsdaytwo);
            for (int x = 0; x < digitsdaytwo.size(); x++) {

                daylifetemptwo = daylifetemptwo + digitsdaytwo.get(x);
            }
            daylifefinal = daylifetemptwo;
        } else {
            daylifefinal = daylifetemp;
        }
        //day end

        int totaltemp = 0, totaltemptwo = 0, totaltempthree = 0, totaltempfour = 0, totalfinal = 0;
        int finaltotal = monthlifefinal + daylifefinal;

        //final

        List<Integer> digitsfinal = new ArrayList<Integer>();
        collectDigits(finaltotal, digitsfinal);
        for (int x = 0; x < digitsfinal.size(); x++) {

            totaltemp = totaltemp + digitsfinal.get(x);
        }
        if (totaltemp > 9) {
            List<Integer> digitsfinaltwo = new ArrayList<Integer>();
            collectDigits(totaltemp, digitsfinaltwo);
            for (int x = 0; x < digitsfinaltwo.size(); x++) {

                totaltemptwo = totaltemptwo + digitsfinaltwo.get(x);
            }
            if (totaltemptwo > 9) {
                List<Integer> digitsfinalthree = new ArrayList<Integer>();
                collectDigits(totaltemptwo, digitsfinalthree);
                for (int x = 0; x < digitsfinalthree.size(); x++) {

                    totaltempthree = totaltempthree + digitsfinalthree.get(x);
                }
                totalfinal = totaltempthree;
            } else {
                totalfinal = totaltemptwo;
            }
        } else {
            totalfinal = totaltemp;
        }


        //final end


        SharedPreferences sp = getSharedPreferences(Constant.USER, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Constant.ATTITUDE, String.valueOf(totalfinal));
        editor.commit();
        editor.apply();
    }

    private void Birthnumber() {
        SharedPreferences getShared = getSharedPreferences(Constant.USER, MODE_PRIVATE);
        String dayy = getShared.getString(Constant.DAY, "day");
        int daylifetemp = 0, daylifetemptwo = 0, daylifefinal = 0;


        //day
        int day = Integer.parseInt(dayy);
        List<Integer> digitsday = new ArrayList<Integer>();
        collectDigits(day, digitsday);
        for (int x = 0; x < digitsday.size(); x++) {

            daylifetemp = daylifetemp + digitsday.get(x);
        }
        if (daylifetemp > 9) {
            List<Integer> digitsdaytwo = new ArrayList<Integer>();
            collectDigits(daylifetemp, digitsdaytwo);
            for (int x = 0; x < digitsdaytwo.size(); x++) {

                daylifetemptwo = daylifetemptwo + digitsdaytwo.get(x);
            }
            daylifefinal = daylifetemptwo;
        } else {
            daylifefinal = daylifetemp;
        }
        //day end
        SharedPreferences sp = getSharedPreferences(Constant.USER, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Constant.BIRTH, String.valueOf(daylifefinal));
        editor.commit();
        editor.apply();
    }


    private void allbottomtexthide() {
        BottomBtnoneText.setVisibility(View.VISIBLE);
        BottomBtntwoText.setVisibility(View.INVISIBLE);
        BottomBtntreeText.setVisibility(View.INVISIBLE);
        BottomBtnfourText.setVisibility(View.INVISIBLE);
    }


    private void onclick() {
        //bottom bottomnavigation
        bottomnavmyprfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allbottomtexthide();

                getSupportFragmentManager().beginTransaction().replace(R.id.liner_main, new MyProfile_Fragment()).commit();
            }
        });
        bottomnavCompatibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                main, comp, halth, affirmatin;

                BottomBtnoneText.setVisibility(View.INVISIBLE);
                BottomBtntwoText.setVisibility(View.VISIBLE);
                BottomBtntreeText.setVisibility(View.INVISIBLE);
                BottomBtnfourText.setVisibility(View.INVISIBLE);
                getSupportFragmentManager().beginTransaction().replace(R.id.liner_main, new Comatibility_Fragment()).addToBackStack(null).commit();


            }
        });
        //bottomnavigation end


        bottomnavHealthandwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomBtnoneText.setVisibility(View.INVISIBLE);
                BottomBtntwoText.setVisibility(View.INVISIBLE);
                BottomBtntreeText.setVisibility(View.VISIBLE);
                BottomBtnfourText.setVisibility(View.INVISIBLE);
                getSupportFragmentManager().beginTransaction().replace(R.id.liner_main, new HealthWork_Fragment()).addToBackStack(null).commit();
            }
        });
        bottomnavaffirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomBtnoneText.setVisibility(View.INVISIBLE);
                BottomBtntwoText.setVisibility(View.INVISIBLE);
                BottomBtntreeText.setVisibility(View.INVISIBLE);
                BottomBtnfourText.setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction().replace(R.id.liner_main, new Affirmation_Fragment()).addToBackStack(null).commit();
            }
        });
    }


    //for digit split
    private static void collectDigits(int num, List<Integer> digits) {
        if (num / 10 > 0) {
            collectDigits(num / 10, digits);
        }
        digits.add(num % 10);
    }

    //for chr to number
    private int getPersonalityNumber(String chr) {
        int number = 0;
        if (chr.equals("J") || chr.equals("A") || chr.equals("S")) {
            number = 1;
        } else if (chr.equals("B") || chr.equals("K") || chr.equals("T")) {
            number = 2;
        } else if (chr.equals("C") || chr.equals("L") || chr.equals("U")) {
            number = 3;
        } else if (chr.equals("D") || chr.equals("M") || chr.equals("V")) {
            number = 4;
        } else if (chr.equals("N") || chr.equals("W") || chr.equals("E")) {
            number = 5;
        } else if (chr.equals("F") || chr.equals("X") || chr.equals("O")) {
            number = 6;
        } else if (chr.equals("G") || chr.equals("P") || chr.equals("Y")) {
            number = 7;
        } else if (chr.equals("H") || chr.equals("Q") || chr.equals("Z")) {
            number = 8;
        } else if (chr.equals("R") || chr.equals("I")) {
            number = 9;
        }


        return number;
    }

    //navigationdrawer

    private void navigationViewitemclick() {
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            navigationDrawerItemSelector(menuItem);
            return false;
        });
    }

    private void navigationDrawerItemSelector(MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.navProfiles:
                getSupportFragmentManager().beginTransaction().replace(R.id.liner_main, new MyProfile_Fragment()).commit();
                break;

//            case R.id.navNumber:
//                startActivity(new Intent(getApplicationContext(), Number_Activity.class));
//                break;

            case R.id.navCompatibility:
                getSupportFragmentManager().beginTransaction().replace(R.id.liner_main, new Comatibility_Fragment()).addToBackStack(null).commit();
                break;
            case R.id.navHalth:
                getSupportFragmentManager().beginTransaction().replace(R.id.liner_main, new HealthWork_Fragment()).addToBackStack(null).commit();
                break;
            case R.id.navAffirmation:
                getSupportFragmentManager().beginTransaction().replace(R.id.liner_main, new Affirmation_Fragment()).addToBackStack(null).commit();
                break;
            case R.id.navShare:
                //Share
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, getPackageName());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, "Share by");
                startActivity(shareIntent);
                break;

        }

        closeDrawer();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.newUser:
                startActivity(new Intent(getApplicationContext(), FillYourDetail.class));
                return true;
        }
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void closeDrawer() {
        this.drawerLayout.closeDrawer(GravityCompat.START);
    }

    //navigationdrawe_end
   /* public void myprofile(View view) {
//        if (getSupportFragmentManager().getFragments() != null && getSupportFragmentManager().getFragments().size() > 0) {
//            for (int i = 0; i < getSupportFragmentManager().getFragments().size(); i++) {
//                Fragment frg = getSupportFragmentManager().getFragments().get(i);
//                if (frg != null)
//                    getSupportFragmentManager().beginTransaction().remove(frg).commit();
//            }
//        }
        getSupportFragmentManager().beginTransaction().replace(R.id.liner_main, new Comatibility_Fragment());
    }
*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.newuser_menu, menu);

        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            SpannableString spannable = new SpannableString(
                    menu.getItem(i).getTitle().toString());
            spannable.setSpan(new ForegroundColorSpan(Color.YELLOW), 0, spannable.length(), 0);
            menuItem.setTitle(spannable);
        }
        return true;
    }
}