package com.moh.alert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnAlert, btnDate, btnHour;
    TextView myDate;
    AlertDialog.Builder dialog;
    DatePickerDialog pickerDialog;
    TimePickerDialog timePickerDialog;

    int Year, Month, Day;
    int minute, hour;
    Calendar calendar;
    String fullDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlert = findViewById(R.id.btnExit);
        btnDate = findViewById(R.id.btnDate);
        btnHour = findViewById(R.id.myTime);
        myDate = findViewById(R.id.myDate);

        calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);

        minute = Calendar.MINUTE;
        hour = Calendar.HOUR_OF_DAY;

        //Alert Dialog
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog = new AlertDialog.Builder(MainActivity.this); //display in MainActivity
                dialog.setTitle(R.string.title);
                dialog.setMessage(R.string.msg);
                dialog.setCancelable(false); //must click a button to remove the dialog
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog myDialog = dialog.create(); //create the dialog
                myDialog.show(); //show dialog

            }
        });

        //Date Picker Dialog
        //
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fullDate = dayOfMonth + " / " + (month + 1) + " / " + year;
                        myDate.setText(fullDate);
                    }
                }, Year, Month, Day); //instance the date
                pickerDialog.show();
            }
        });

        //Time Picker Dialog
        btnHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        myDate.setText(hourOfDay + " : " + minute);
                    }
                }, hour, minute, false);
                timePickerDialog.show(); // important
            }
        });


    }
}
