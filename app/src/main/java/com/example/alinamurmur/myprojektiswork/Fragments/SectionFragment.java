package com.example.alinamurmur.myprojektiswork.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alinamurmur.myprojektiswork.Interfaces.eventListener;
import com.example.alinamurmur.myprojektiswork.R;

public class SectionFragment extends Fragment implements View.OnClickListener {
    private static String BUNDLE_CONTENT = "content";
    private int section;

    eventListener someEventListener;

    public static SectionFragment newInstance(int content) {
        SectionFragment f = new SectionFragment();
        Bundle b = new Bundle();
        b.putInt(BUNDLE_CONTENT, content);
        f.setArguments(b);
        return f;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(BUNDLE_CONTENT)) {
            section = getArguments().getInt(BUNDLE_CONTENT);
        } else {
            throw new IllegalArgumentException("Must be created through newInstance(...)");
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);

        TextView b1 = (TextView) view.findViewById(R.id.bu1);
        TextView b2 = (TextView) view.findViewById(R.id.bu2);
        TextView b3 = (TextView) view.findViewById(R.id.bu3);
        TextView b4 = (TextView) view.findViewById(R.id.bu4);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String title = "Раздел";
        switch (section) {
            case 1:
                title = "ФСК Стрелок";
                break;
            case 2:
                title = "СДК Ростов";
                break;
            case 3:
                title = "Молодежь Роствертола";
                break;
        }
        getActivity().setTitle(title);
    }

    @Override
    public void onClick(View view) {
        int num = 1;
        switch (view.getId()) {
            case R.id.bu1:
                num = 1;
                break;
            case R.id.bu2:
                num = 2;
                break;
            case R.id.bu3:
                num = 3;
                break;
            case R.id.bu4:
                num = 4;
                break;
        }
        someEventListener.sectionClickListener(num, section);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
