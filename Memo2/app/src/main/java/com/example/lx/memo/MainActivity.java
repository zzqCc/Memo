package com.example.lx.memo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState)
    {

        super.onCreate(saveInstanceState);

        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.option);
        button.setOnClickListener(new View.OnClickListener() {//点击选项
            @Override
            public void onClick(View v) {
                showPopupWindow(MainActivity.this,findViewById(R.id.option));
                Toast.makeText(MainActivity.this,"click", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showPopupWindow(Context context,View parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View vPopupWindow=inflater.inflate(R.layout.option_item, null);
        final PopupWindow pw= new PopupWindow(vPopupWindow,600,700);
        pw.setFocusable(true);
        pw.setTouchable(true);
        Button button1=(Button) vPopupWindow.findViewById(R.id.add_item);
        button1.setOnClickListener(new View.OnClickListener() {//点击历史
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "历史", Toast.LENGTH_SHORT).show();
            }
        });
        Button button2=(Button) vPopupWindow.findViewById(R.id.add_item);
        button2.setOnClickListener(new View.OnClickListener() {//点击历史
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "添加联系人", Toast.LENGTH_SHORT).show();
            }
        });
        Button button3=(Button) vPopupWindow.findViewById(R.id.edit_item);
        button3.setOnClickListener(new View.OnClickListener() {//点击历史
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "编辑", Toast.LENGTH_SHORT).show();
            }
        });
        Button button4=(Button)vPopupWindow.findViewById(R.id.setting_item);
        button4.setOnClickListener(new View.OnClickListener() {//点击历史
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
            }
        });
        pw.showAsDropDown(parent);
        }

    }
