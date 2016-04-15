package com.example.lx.memo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);

        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.option);
        button.setOnClickListener(new View.OnClickListener() {//点击选项
            @Override
            public void onClick(View v) {
                Popup popup=new Popup();
                popup.showPopupWindow(MainActivity.this, findViewById(R.id.option));
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
                ;

            }
        });
    }
}

