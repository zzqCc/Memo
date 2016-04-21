package com.example.lx.memo2;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.R;
import com.example.edit.EditActivity;
import com.example.memo.MemoActivity;
import com.example.memo.Popup;

public class MainActivity extends FragmentActivity implements OnClickListener{
    private Button option;

    private LinearLayout ll_reminder;
    private LinearLayout ll_friends;

    private Fragment reminderFragment;
    private Fragment friendsFragment;

    private ImageButton friends;
    private ImageButton reminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        initFragment(0);
    }

    private void initFragment(int index) {
        // 由于是引用了V4包下的Fragment，所以这里的管理器要用getSupportFragmentManager获取
           FragmentManager fragmentManager = getSupportFragmentManager();
           // 开启事务
           FragmentTransaction transaction = fragmentManager.beginTransaction();
           // 隐藏所有Fragment
           hideFragment(transaction);
           switch (index) {
               case 0:
                if (reminderFragment == null) {
                        reminderFragment = new ReminderFragment();
                        transaction.add(R.id.fl_content, reminderFragment);
                    } else {
                        transaction.show(reminderFragment);
                    }
                break;
             case 1:
                if (friendsFragment == null) {
                        friendsFragment = new FriendsFragment();
                        transaction.add(R.id.fl_content, friendsFragment);
                    } else {
                        transaction.show(friendsFragment);
                    }
                break;
               default:
                break;
        }

            // 提交事务
            transaction.commit();

        }

    //隐藏Fragment
    private void hideFragment(FragmentTransaction transaction) {
         if (reminderFragment != null) {
                 transaction.hide(reminderFragment);
         }
         if (friendsFragment != null) {
             transaction.hide(friendsFragment);
         }
     }

    public void initEvent(){
        ll_friends.setOnClickListener(this);
        ll_reminder.setOnClickListener(this);

    }

    public void initView(){

        ll_friends = (LinearLayout) findViewById(R.id.ll_friends);
        ll_reminder = (LinearLayout) findViewById(R.id.ll_reminder);

        option=(Button)findViewById(R.id.option);
        option.setOnClickListener(this);
        friends = (ImageButton) findViewById(R.id.friends);
        friends.setOnClickListener(this);
        reminder = (ImageButton) findViewById(R.id.reminder);
        reminder.setOnClickListener(this);

        setDefaultFragment();
    }

    //test must be finished before the 4.13
    @SuppressLint("NewApi")
    private void setDefaultFragment() {}

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.reminder:
                Toast.makeText(this,"clicked reminder",Toast.LENGTH_SHORT).show();
                initFragment(0);
                break;
            case R.id.friends:
                Toast.makeText(this,"clicked friends",Toast.LENGTH_SHORT).show();
                initFragment(1);
                break;
            case R.id.option:
                Popup popup=new Popup();
                popup.showPopupWindow(MainActivity.this, findViewById(R.id.option));
        }
    }

}
