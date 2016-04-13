package com.example.lx.memo2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.R;

/**
 * Created by ccccc on 2016/4/13.
 */
public class ReminderFragment extends Fragment {

    @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
              return inflater.inflate(R.layout.fragment_reminder, container, false);
    }
}
