package com.example.alinamurmur.myprojektiswork.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.alinamurmur.myprojektiswork.Adapters.AdapterForMainPager;
import com.example.alinamurmur.myprojektiswork.Interfaces.eventListener;
import com.example.alinamurmur.myprojektiswork.R;
import com.rd.PageIndicatorView;
import com.rd.animation.AnimationType;

public class MainFragment extends Fragment implements View.OnClickListener {

    eventListener someEventListener;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.glavni, container, false);

        ViewPager pager = (ViewPager) view.findViewById(R.id.viewpager2);
        pager.setAdapter(buildAdapter());

        PageIndicatorView pageIndicatorView = (PageIndicatorView) view.findViewById(R.id.indicatorMain);
        pageIndicatorView.setViewPager(pager);
        pageIndicatorView.setAnimationType(AnimationType.SCALE);
        int color = ContextCompat.getColor(getActivity(),R.color.PrimaryColor);
        pageIndicatorView.setSelectedColor(color);


        LinearLayout c1 = (LinearLayout) view.findViewById(R.id.but1);
        c1.setOnClickListener(this);
        LinearLayout c2 = (LinearLayout)view.findViewById(R.id.but2);
        c2.setOnClickListener(this);
        LinearLayout c3 = (LinearLayout)view.findViewById(R.id.but3);
        c3.setOnClickListener(this);
        LinearLayout c4 = (LinearLayout)view.findViewById(R.id.but4);
        c4.setOnClickListener(this);
        LinearLayout c5 = (LinearLayout)view.findViewById(R.id.but5);
        c5.setOnClickListener(this);
        LinearLayout c6 = (LinearLayout)view.findViewById(R.id.but6);
        c6.setOnClickListener(this);

        return view;
    }

    private PagerAdapter buildAdapter() {
        return(new AdapterForMainPager(getActivity(), getFragmentManager()));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Главная страница");

    }


    @Override
    public void onClick(View view) {
        int num =0;
        switch (view.getId()) {
            case R.id.but1:
                num = 1;
                break;
            case R.id.but2:
                num=2;
                break;
            case R.id.but3:
                num=3;
                break;
            case R.id.but4:
                num=4;
                break;
            case R.id.but5:
                num=5;
                break;
            case R.id.but6:
                num=6;
                break;
        }
        someEventListener.someEvent(num);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            someEventListener = (eventListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onSomeEventListener");
        }
    }
}
