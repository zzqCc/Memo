package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.R;
import com.example.lx.memo2.MainActivity;

/**
 * Created by ccccc on 2016/4/14.
 */
public class LogIn extends Activity
{
    @Override
    protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);
        Button login=(Button)findViewById(R.id.log_in);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, MainActivity.class);;
                startActivity(intent);
                finish();
            }
        });
        TextView textView1=(TextView)findViewById(R.id.register);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LogIn.this, "立即注册", Toast.LENGTH_SHORT).show();
            }
        });
        TextView textView=(TextView)findViewById(R.id.find_password);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LogIn.this,"找回密码",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
