package com.example.lx.memo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by 启琛 on 2016/4/9.
 */
public class bottom_menu extends LinearLayout {
    public bottom_menu(Context context,AttributeSet attributeSet)
    {
        super(context,attributeSet);
        LayoutInflater.from(context).inflate(R.layout.bottom_menu,this);
        ImageButton button1=(ImageButton)findViewById(R.id.reminder);
        ImageButton button2=(ImageButton)findViewById(R.id.friends);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "you click reminder", Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"you click friends",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
