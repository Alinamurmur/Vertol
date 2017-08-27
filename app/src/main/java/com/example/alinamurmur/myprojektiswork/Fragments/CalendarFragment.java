package com.example.alinamurmur.myprojektiswork.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alinamurmur.myprojektiswork.Interfaces.eventListener;
import com.example.alinamurmur.myprojektiswork.R;

/**
 * Created by Admin on 19.07.2017.
 */

public class CalendarFragment extends Fragment implements View.OnClickListener {

    eventListener mCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_calendar, container, false);

        TextView t1 = (TextView)view.findViewById(R.id.january);
        TextView t2 = (TextView)view.findViewById(R.id.february);
        TextView t3 = (TextView)view.findViewById(R.id.march);
        TextView t4 = (TextView)view.findViewById(R.id.april);
        TextView t5 = (TextView)view.findViewById(R.id.may);
        TextView t6 = (TextView)view.findViewById(R.id.june);
        TextView t7 = (TextView)view.findViewById(R.id.july);
        TextView t8 = (TextView)view.findViewById(R.id.august);
        TextView t9 = (TextView)view.findViewById(R.id.september);
        TextView t10 = (TextView)view.findViewById(R.id.october);
        TextView t11 = (TextView)view.findViewById(R.id.november);
        TextView t12 = (TextView)view.findViewById(R.id.december);

        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnClickListener(this);
        t5.setOnClickListener(this);
        t6.setOnClickListener(this);
        t7.setOnClickListener(this);
        t8.setOnClickListener(this);
        t9.setOnClickListener(this);
        t10.setOnClickListener(this);
        t11.setOnClickListener(this);
        t12.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        String month ="month";
        switch (view.getId()) {
            case R.id.january:
                month = getString(R.string.m1);
                break;
            case R.id.february:
                month = getString(R.string.m2);
                break;
            case R.id.march:
                month = getString(R.string.m3);
                break;
            case R.id.april:
                month = getString(R.string.m4);
                break;
            case R.id.may:
                month = getString(R.string.m5);
                break;
            case R.id.june:
                month = getString(R.string.m6);
                break;
            case R.id.july:
                month = getString(R.string.m7);
                break;
            case R.id.august:
                month = getString(R.string.m8);
                break;
            case R.id.september:
                month = getString(R.string.m9);
                break;
            case R.id.october:
                month = getString(R.string.m10);
                break;
            case R.id.november:
                month = getString(R.string.m11);
                break;
            case R.id.december:
                month = getString(R.string.m12);
                break;
        }
        mCallback.onMonthSelected(month);
    }

 @Override
     public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);
         getActivity().setTitle("Календарь");
     }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (eventListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onSomeEventListener");
        }
    }

}
