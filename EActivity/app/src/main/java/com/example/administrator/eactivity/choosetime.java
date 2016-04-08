package com.example.administrator.eactivity;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker.OnTimeChangedListener;
/**
 * Created by Administrator on 2016/4/5.
 */
public class choosetime extends AppCompatActivity {

    private EditText dateEt=null;
    private EditText timeEt=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosetime);
        dateEt=(EditText)findViewById(R.id.dateEt);
        timeEt=(EditText)findViewById(R.id.timeEt);
        DatePicker datePicker=(DatePicker)findViewById(R.id.datePicker);
        TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);

        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int monthOfYear=calendar.get(Calendar.MONTH);
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, monthOfYear, dayOfMonth, new OnDateChangedListener(){

            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                dateEt.setText("您选择的日期是："+year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日。");
            }

        });

        timePicker.setOnTimeChangedListener(new OnTimeChangedListener(){

            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                timeEt.setText("您选择的时间是："+hourOfDay+"时"+minute+"分。");
            }

        });
    }

}
