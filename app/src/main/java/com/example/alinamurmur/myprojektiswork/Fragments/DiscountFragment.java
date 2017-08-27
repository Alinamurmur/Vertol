package com.example.alinamurmur.myprojektiswork.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alinamurmur.myprojektiswork.R;

/**
 * Created by Александр on 20.07.2017.
 */

public class DiscountFragment extends Fragment {

    private static String BUNDLE_CONTENT = "content";
    private String title;

    public static DiscountFragment newInstance(String content) {
        DiscountFragment f = new DiscountFragment();
        Bundle b = new Bundle();
        b.putString(BUNDLE_CONTENT, content);
        f.setArguments(b);
        return f;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(BUNDLE_CONTENT)) {
            title = getArguments().getString(BUNDLE_CONTENT);
        } else {
            throw new IllegalArgumentException("Must be created through newInstance(...)");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_skidki, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(title);
    }
}
