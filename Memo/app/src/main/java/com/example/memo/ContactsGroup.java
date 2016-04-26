package com.example.memo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.R;

/**
 * Created by 启琛 on 2016/4/27.
 */
public class ContactsGroup extends LinearLayout
{
    public ContactsGroup(Context context,AttributeSet attributeSet)
    {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.contacts_group, this);

        final TextView textView=(TextView)findViewById(R.id.contacts);
        final TextView textView1=(TextView)findViewById(R.id.groups);
        textView.setTextColor(getResources().getColor(R.color.colorPrimary));
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                textView1.setTextColor(getResources().getColor(R.color.SendWords));
            }
        });
        textView1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setTextColor(getResources().getColor(R.color.colorPrimary));
                textView.setTextColor(getResources().getColor(R.color.SendWords));
            }
        });
    }
}
