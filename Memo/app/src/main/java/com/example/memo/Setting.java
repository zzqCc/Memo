package com.example.memo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.R;

/**
 * Created by 启琛 on 2016/4/21.
 */
public class Setting extends Activity
{
    private String[] data = {"个人信息","黑名单","提醒设置","关于我们","退出登录"};
    @Override
    protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_setting);
        TextView textView=(TextView)findViewById(R.id.back_from_setting);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                Setting.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.setting_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String string=data[position];
                switch (string)
                {
                    case "个人信息":
                        Toast.makeText(Setting.this, "个人信息", Toast.LENGTH_SHORT).show();
                        break;
                    case "黑名单":
                        Toast.makeText(Setting.this,"黑名单",Toast.LENGTH_SHORT).show();
                        break;
                    case "提醒设置":
                        Toast.makeText(Setting.this,"提醒设置",Toast.LENGTH_SHORT).show();
                        break;
                    case "关于我们":
                        Toast.makeText(Setting.this,"关于我们",Toast.LENGTH_SHORT).show();
                        break;
                    case "退出登录":
                        Toast.makeText(Setting.this,"退出登录",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;

                }
            }
        });
    }
}