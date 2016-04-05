package com.example.lx.memo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ccccc on 2016/4/5.
 */
public class ContactsAdapter extends ArrayAdapter<Contacts> {
    private int resourceId;
    public ContactsAdapter(Context context, int textViewResourceId,
                           List<Contacts> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contacts contacts = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.contactImage = (ImageView) view.findViewById
                    (R.id.contact_image);
            viewHolder.Name = (TextView) view.findViewById
                    (R.id.text1);
            viewHolder.Information = (TextView) view.findViewById
                    (R.id.text2);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();//重新获取viewHolder
        }
        ImageView contactImage = (ImageView) view.findViewById(R.id.contact_image);
        TextView Name = (TextView) view.findViewById(R.id.text1);
        TextView Information = (TextView) view.findViewById(R.id.text2);
        contactImage.setImageResource(contacts.getImageId());
        Name.setText(contacts.getName());
        Information.setText(contacts.getInformation());
        return view;
    }
}

class ViewHolder {
    ImageView contactImage;
    TextView Name;
    TextView Information;
}
