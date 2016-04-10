package com.example.lx.memo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import Contact.ContactActivity;

/**
 * Created by ccccc on 2016/4/10.
 */
public class FriendFragment extends Fragment {
    private ImageButton button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View view=inflater.inflate(R.layout.item_contact, null);//这个就相当于你加的布局
        TextView textview1=view.findViewById(R.id.contact_person_name);//所以你的id都是基于你这个布局找的
        textview1.settext("只要初始化了里面的事件都是和activity一样的");
        textview1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), ContactActivity.class);
                //你的fragment是基于fragmentactivity的，getactivity()就可以了
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
        return view;
    }
}
