package com.example.alinamurmur.myprojektiswork.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alinamurmur.myprojektiswork.Adapters.SampleAdapter;
import com.example.alinamurmur.myprojektiswork.R;
import com.rd.PageIndicatorView;
import com.rd.animation.AnimationType;

// Fragment where is ViewPager

public class FragmentScroll extends Fragment {
    int id =0 ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scroll,
                container, false);

        ViewPager pager = (ViewPager) view.findViewById(R.id.viewpager);
        pager.setAdapter(buildAdapter());
        pager.setCurrentItem(id);

        PageIndicatorView pageIndicatorView = (PageIndicatorView) view.findViewById(R.id.indicator);
        pageIndicatorView.setViewPager(pager);
        pageIndicatorView.setSelection(id);
        pageIndicatorView.setAnimationType(AnimationType.SCALE);
        return view;
    }
   private PagerAdapter buildAdapter() {
        return(new SampleAdapter(getActivity(), getFragmentManager()));
    }

    public void getSelected(int id){
        this.id = id;
    }

}




