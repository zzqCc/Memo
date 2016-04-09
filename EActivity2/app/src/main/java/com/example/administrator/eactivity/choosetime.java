package com.example.administrator.eactivity;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker.OnTimeChangedListener;



public class choosetime extends Activity {

    private EditText dateEt=null;
    private EditText timeEt=null;
    private Button Yeba;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosetime);
        timeEt=(EditText)findViewById(R.id.timeEt);
        TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);
        Yeba = (Button) findViewById(R.id.yeah);

        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int monthOfYear=calendar.get(Calendar.MONTH);
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);


        timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {

            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                timeEt.setText("您选择的时间是：" + hourOfDay + "时" + minute + "分。");
            }

        });


        Yeba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backWithTime = new Intent();
                backWithTime.putExtra("data_return" , timeEt.getText());
                setResult(RESULT_OK, backWithTime);
                finish();
            }
        });


        //*****************************************************************//



        //*****************************************************************//





    } // end onCreate function






} // end choosetime class
