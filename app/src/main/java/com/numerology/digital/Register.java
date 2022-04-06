package com.numerology.digital;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Register extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private Button datepickerButton;
    private TextView dateofbirthText;
    private RelativeLayout save;
    private EditText firstnameEditText, lastnameEditText;
    private String dd, mm, yyyy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        datepickerButton = findViewById(R.id.datepicker_button);
        dateofbirthText = findViewById(R.id.dateofbirthTextView);
        save = findViewById(R.id.save);
        firstnameEditText = findViewById(R.id.firstnameEdittext);
        lastnameEditText = findViewById(R.id.lastnameEdittext);
        initDatePicker();

        datepickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datePickerDialog.show();

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(firstnameEditText.getText()) || TextUtils.isEmpty(lastnameEditText.getText()) || TextUtils.isEmpty(dateofbirthText.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
                } else {

                    SharedPreferences sp = getSharedPreferences(Constant.USER, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString(Constant.FIRSTNAME, firstnameEditText.getText().toString());
                    editor.putString(Constant.LASTNAME, lastnameEditText.getText().toString());
                    editor.putString(Constant.DAY, dd);
                    editor.putString(Constant.MONTH, mm);
                    editor.putString(Constant.YEAR, yyyy);
                    editor.commit();
                    editor.apply();
                    startActivity(new Intent(Register.this, MainActivity.class));
                    Toast.makeText(getApplicationContext(), firstnameEditText.getText().toString()+" Welcome to Numerology", Toast.LENGTH_LONG).show();
                    finish();

                    Toast.makeText(getApplicationContext(), "Please Enter All Details", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
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
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

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


}