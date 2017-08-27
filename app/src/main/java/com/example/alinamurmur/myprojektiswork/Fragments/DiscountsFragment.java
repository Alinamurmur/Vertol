package com.example.alinamurmur.myprojektiswork.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alinamurmur.myprojektiswork.Interfaces.eventListener;
import com.example.alinamurmur.myprojektiswork.R;

/**
 * Created by Alina on 29.06.2017.
 */

public class DiscountsFragment extends Fragment implements AdapterView.OnItemClickListener {

    RecyclerView.Adapter mAdapter;
    Context context;

    eventListener someEventListener;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment7, container, false);

        String[] names = { "Аквапарк", "Автошкола", "Зоопарк", "Еще что-то" };
        ListView listView = (ListView) view.findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.item_list,names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(R.string.skidki_string);
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                someEventListener.onDiscountSelected("Скидка "+position);

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

