package com.example.lx.memo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 启琛 on 2016/4/13.
 */
public class LogIn extends Activity
{
    @Override
    protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.log_in);
        final Button button=(Button)findViewById(R.id.log_in);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LogIn.this,MainActivity.class);
                startActivity(intent);
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
