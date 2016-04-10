package com.example.lx.memo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.R;
import com.example.contact.ContactActivity;

/**
 * Created by ccccc on 2016/4/10.
 */
public class FriendFragment extends Fragment {
    private ImageButton reminder;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View view=inflater.inflate(R.layout.item_contact, container,false);//这个就相当于你加的布局
        reminder = (ImageButton) getActivity().findViewById(R.id.reminder);
        reminder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), ContactActivity.class);
                //你的fragment是基于fragmentactivity的，getactivity()就可以了
                startActivity(intent);
            }
        });
        return view;
    }
}
