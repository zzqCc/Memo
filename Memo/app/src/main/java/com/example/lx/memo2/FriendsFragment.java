package com.example.lx.memo2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ccccc on 2016/4/13.
 */
public class FriendsFragment extends ListFragment {

    private String[] values = new String[] { "侏儒", "人类", "暗夜精灵", "矮人", "德莱尼",
            "狼人" ,"雷雪","女巫","预言家","猎人","平民","赵一鸣","周芷茜"};
    private String[] content = new String[] { "zhuru","human","fairy","short","blare",
            "wolf","xueba","witch","forecast","hunter","citizen","dashen","xuezha"};

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_friends, container, false);
            return rootView;


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < values.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("values", values[i]);
            listItem.put("content",content[i]);
            listItems.add(listItem);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), listItems,
                R.layout.list_item, new String[] { "values","content" },
                new int[] { R.id.txt_title,R.id.txt_content });
        setListAdapter(adapter);

    }
}
