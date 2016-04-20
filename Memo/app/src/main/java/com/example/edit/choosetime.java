package com.example.edit;

/**
 * Created by ccccc on 2016/4/12.
 */
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.Toast;

import com.example.R;


public class choosetime extends Activity {

    private EditText dateEt=null;
    private EditText timeEt=null;
    private Button Yeba;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosetime);
        timeEt=(EditText)findViewById(R.id.timeEt);
        dateEt=(EditText)findViewById(R.id.datEt);
        TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);
        Yeba = (Button) findViewById(R.id.yeah);
        DatePicker datePicker = (DatePicker) findViewById(R.id.dpPicker);

        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int monthOfYear=calendar.get(Calendar.MONTH);
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, monthOfYear, dayOfMonth, new OnDateChangedListener(){

            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                dateEt.setText("您选择的日期是：" + year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日。");
            }

        });


        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(choosetime.this,
                        hourOfDay + "小时" + minute + "分钟",
                        Toast.LENGTH_SHORT).show();
                timeEt.setText("您选择的时间是：" + hourOfDay + "时" + minute + "分。");
            }

        });


        Yeba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backWithTime = new Intent();
                backWithTime.putExtra("data_return" , dateEt.getText().toString()+timeEt.getText().toString());
                setResult(RESULT_OK,backWithTime);
                finish();
            }
        });


        //*****************************************************************//



        //*****************************************************************//





    } // end onCreate function






} // end choosetime class