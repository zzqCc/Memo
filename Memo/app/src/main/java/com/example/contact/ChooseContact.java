package com.example.contact;

/**
 * Created by ccccc on 2016/4/13.
 */
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.R;

public class ChooseContact extends Activity implements OnClickListener
{
    private List<CheckBox> checkboxs = new ArrayList<CheckBox>();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        String[] checkboxText = new String[]{"Android","iPhone","Windows Mobile","Symbian","Meego","BlackBeery","Palm"};
        super.onCreate(savedInstanceState);

        //装载main.xml文件
        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.layout_choosecontact, null);
        for (int i = 0; i < checkboxText.length;i++)
        {
            //装载checkbox.xml文件
            LinearLayout checkboxLinearLayout = (LinearLayout) getLayoutInflater().
                    inflate(R.layout.layout_checkbox, null);
            //获得checkbox.xml文件中的CheckBox对象
            checkboxs.add((CheckBox) checkboxLinearLayout.findViewById(R.id.checkbox));
            //设置CheckBox的文本
            checkboxs.get(i).setText(checkboxText[i]);

            //将包含CheckBox的LinearLayout对象添加到由主布局文件生成的LinearLayout对象中
            linearLayout.addView(checkboxLinearLayout, i);
        }
        setContentView(linearLayout);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        String s = "";
        for (CheckBox checkbox : checkboxs)
        {
            if (checkbox.isChecked())
                s += checkbox.getText() + "\n";
        }
        if ("".equals(s)){
            s = "您还没选呢！";
            new AlertDialog.Builder(this).setMessage(s)
                    .setPositiveButton("关闭", null).show();
        }
        else{
            Intent intent = new Intent();
            intent.putExtra("contact_return",s.toString());
            setResult(RESULT_OK,intent);
            finish();
        }
    }


}
