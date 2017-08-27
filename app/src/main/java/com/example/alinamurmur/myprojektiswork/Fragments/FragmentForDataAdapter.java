package com.example.alinamurmur.myprojektiswork.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alinamurmur.myprojektiswork.R;
import com.squareup.picasso.Picasso;

public class FragmentForDataAdapter extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    String titl,url,textt;
    Context context;


    public FragmentForDataAdapter() {}


    public static FragmentForDataAdapter newInstance(int sectionNumber,
                                                     String names, String text, String img) {
        FragmentForDataAdapter fragment = new FragmentForDataAdapter();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putString("title",names);
        args.putString("text",text);
        args.putString("img",img);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titl = getArguments().getString("title");
        textt = getArguments().getString("text");
        url = getArguments().getString("img");
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
        TextView textView = (TextView)rootView.findViewById(R.id.section_label);
        TextView texView =  (TextView)rootView.findViewById(R.id.sometext);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.someimg);
        textView.setText(titl);
        texView.setText(textt);
        Picasso.with(getActivity()).load(url).into(imageView);

        return rootView;
    }
}

