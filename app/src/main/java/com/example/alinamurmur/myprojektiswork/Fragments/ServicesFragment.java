package com.example.alinamurmur.myprojektiswork.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alinamurmur.myprojektiswork.Interfaces.eventListener;
import com.example.alinamurmur.myprojektiswork.R;

/**
 * Created by Admin on 19.07.2017.
 */

public class ServicesFragment extends Fragment implements AdapterView.OnItemClickListener {

    eventListener someEventListener;
    private static String BUNDLE_CONTENT = "content";
    private int section;

    public static ServicesFragment newInstance( int section) {
        ServicesFragment fragment = new ServicesFragment();
        Bundle b = new Bundle();
        b.putInt(BUNDLE_CONTENT, section);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(BUNDLE_CONTENT)) {
            section = getArguments().getInt(BUNDLE_CONTENT);
        } else {
            throw new IllegalArgumentException("Must be created through newInstance(...)");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_uslugi, container, false);

        TextView textView = (TextView)view.findViewById(R.id.nameU);
        textView.setText("");

        String[] names = { "Галатея", "Вокальная студия", "Карате" };
        ListView listView = (ListView) view.findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.item_list,names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        switch (section){
            case 1:
                textView.setText("ФСК Стрелок");
                break;
            case 2:
                textView.setText("СДК Ростов");
                break;
            case 3:
                textView.setText("Молодежь Роствертола");
                break;
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Услуги");
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            someEventListener.onArticleSelected("Статья "+i, i, 0);
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
