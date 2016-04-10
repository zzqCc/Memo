package com.example.lx.memo;


import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.R;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private ImageButton reminder;
    private ImageButton friends;

    private FriendFragment mFriendFragment;
    private ReminderFragment mReminderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
    }

    public void initView() {
        // 初始化控件和声明事件
        reminder = (ImageButton) findViewById(R.id.reminder);
        friends = (ImageButton) findViewById(R.id.friends);
        reminder.setOnClickListener(this);
        friends.setOnClickListener(this);

        // 设置默认的Fragment
        setDefaultFragment();
    }

    @SuppressLint("NewApi")
    private void setDefaultFragment() {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        mReminderFragment = new ReminderFragment();
        transaction.replace(R.id.id_content, mReminderFragment);
        transaction.commit();
    }

    @SuppressLint("NewApi")
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this,"you clicked it",Toast.LENGTH_SHORT);

        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.reminder:
                if (mReminderFragment == null) {
                    mReminderFragment = new ReminderFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content, mReminderFragment);
                break;
            case R.id.friends:
                if (mFriendFragment == null) {
                    mFriendFragment = new FriendFragment();
                }
                transaction.replace(R.id.id_content, mFriendFragment);
                break;
        }
        // transaction.addToBackStack();
        // 事务提交
        transaction.commit();
    }
}
