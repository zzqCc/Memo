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
public class top_menu extends LinearLayout {
    public top_menu(Context context,AttributeSet attributeSet)
    {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.top_menu, this);
        ImageButton button1=(ImageButton)findViewById(R.id.history);
        ImageButton button2=(ImageButton)findViewById(R.id.add);
        ImageButton button3=(ImageButton)findViewById(R.id.edit);
        ImageButton button4=(ImageButton)findViewById(R.id.setting);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "you click history", Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getContext(),"you click add",Toast.LENGTH_SHORT).show();
            }
        });
        button3.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getContext(),"you click edit",Toast.LENGTH_SHORT).show();
            }
        });
        button4.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getContext(),"you click setting",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
