package com.numerology.digital;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class FillYourDetail extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private Button datepickerButton;
    private TextView dateofbirthText;
    private Button next;
    private String dd, mm, yyyy, gender = "Male";
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_your_detail);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        radioGroup = findViewById(R.id.radioGroup);


        datepickerButton = findViewById(R.id.datepicker_button);
        dateofbirthText = findViewById(R.id.dateofbirthTextView);
        next = findViewById(R.id.next);


        initDatePicker();

        datepickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datePickerDialog.show();

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(dateofbirthText.getText().toString()) || TextUtils.isEmpty(gender)) {
                    Toast.makeText(getApplicationContext(), "Please Enter Date of Birth", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(FillYourDetail.this, Register.class);
                    intent.putExtra(Constant.DAY, dd);
                    intent.putExtra(Constant.MONTH, mm);
                    intent.putExtra(Constant.YEAR, yyyy);
                    intent.putExtra(Constant.GENDER, gender);
                    startActivity(intent);
                    finish();

                }
            }
        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
//                String date = makeDateString(day, month, year);
//                dateofbirthText.setText(date);
                String date = String.valueOf(day + " " + getMonthFormat(month) + " " + year);
                dateofbirthText.setText(date);
                dd = String.valueOf(day);
                mm = String.valueOf(month);
                yyyy = String.valueOf(year);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year) {
        return day + "/" + month + "/" + year;
    }

    private String getMonthFormat(int month) {
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "MAY";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AUG";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OCT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public void CheckButton(View view) {
        int radioid = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioid);
        gender = radioButton.getText().toString();
    }
}