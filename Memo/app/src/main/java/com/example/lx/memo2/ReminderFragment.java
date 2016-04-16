package com.example.lx.memo2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.R;
import com.example.database.MemoDatabaseHelper;
import com.example.memo.MemoDetail;
import com.example.memo.MemoRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ccccc on 2016/4/13.
 */
public class ReminderFragment extends ListFragment {

    private TextView memo_Id;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reminder, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MemoRepo repo = new MemoRepo(getActivity());

        ArrayList<HashMap<String, String>> memoList = repo.getStudentList();
        if (memoList.size() != 0) {
            ListView lv = getListView();
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    memo_Id = (TextView) view.findViewById(R.id.memo_Id);
                    String memoId = memo_Id.getText().toString();
                    Intent objIndent = new Intent(getActivity(), MemoDetail.class);
                    objIndent.putExtra("memo_Id", Integer.parseInt(memoId));
                    startActivity(objIndent);
                }
            });
            ListAdapter adapter = new SimpleAdapter(getActivity(), memoList,
                    R.layout.memo_add, new String[]{"_id", "title", "d_day"},
                    new int[]{R.id.memo_Id, R.id.memo_title, R.id.memo_d_day});
            setListAdapter(adapter);
        }
    }
}


