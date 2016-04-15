package com.example.lx.memo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * Created by 启琛 on 2016/4/15.
 */
public class Popup extends Activity
{
    public  void showPopupWindow(final Context context,View parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View vPopupWindow=inflater.inflate(R.layout.option_item, null);
        final PopupWindow pw= new PopupWindow(vPopupWindow,600,700);
        pw.setFocusable(true);
        pw.setTouchable(true);
        Button button1=(Button) vPopupWindow.findViewById(R.id.history_item);
        button1.setOnClickListener(new View.OnClickListener() {//点击历史
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "历史", Toast.LENGTH_SHORT).show();
            }
        });
        Button button2=(Button) vPopupWindow.findViewById(R.id.add_item);
        button2.setOnClickListener(new View.OnClickListener() {//点击历史
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "添加联系人", Toast.LENGTH_SHORT).show();
            }
        });
        Button button3=(Button) vPopupWindow.findViewById(R.id.edit_item);
        button3.setOnClickListener(new View.OnClickListener() {//点击历史
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "编辑", Toast.LENGTH_SHORT).show();
            }
        });
        Button button4=(Button)vPopupWindow.findViewById(R.id.setting_item);
        button4.setOnClickListener(new View.OnClickListener() {//点击历史
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "设置", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,Setting.class);
                context.startActivity(intent);
            }
        });
        pw.showAsDropDown(parent);
    }

}

