package com.example.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.R;

import java.util.List;

/**
 * Created by ccccc on 2016/4/13.
 */
public class ContactAdapter extends ArrayAdapter<Contact> {
    private int resourceId;

    public ContactAdapter(Context context,int textViewResourceId,List<Contact> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        Contact contact = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById
                    (R.id.text1);
            viewHolder.information = (TextView) view.findViewById
                    (R.id.text2);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.name.setText(contact.getName());
        viewHolder.information.setText(contact.getInformation());
        return view;
    }

    class ViewHolder{

        TextView name;

        TextView information;
    }
}
