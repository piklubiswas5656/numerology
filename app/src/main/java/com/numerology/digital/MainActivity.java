package com.numerology.digital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {
    private Context context = MainActivity.this;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private ImageView imageView;

    private LinearLayout bottomnavmyprfile, bottomnavCompatibility, bottomnavHealthandwork, bottomnavaffirmation;
    private LinearLayout main, comp, halth, affirmatin;
    //bottomnavigation text
    private TextView BottomBtnoneText, BottomBtntwoText, BottomBtntreeText, BottomBtnfourText;

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
    }

    private void init() {
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

}