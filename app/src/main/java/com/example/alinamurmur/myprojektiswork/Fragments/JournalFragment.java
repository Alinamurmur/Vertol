package com.example.alinamurmur.myprojektiswork.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alinamurmur.myprojektiswork.Adapter2;
import com.example.alinamurmur.myprojektiswork.R;
import com.example.alinamurmur.myprojektiswork.RecyclerItemClickListener;

import java.util.ArrayList;

/**
 * Created by Alina on 29.06.2017.
 */

public class JournalFragment extends Fragment implements  RecyclerItemClickListener.OnItemClickListener, AdapterView.OnItemClickListener {

    RecyclerView.Adapter mAdapter;
    Context context;
    ListView listView;

    public static interface ListListener{
        void itemClicked(int id);
    }
    private ListListener listListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        RecyclerView mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler2);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(context,this));
        mAdapter = new Adapter2(getVipusk());
        mRecyclerView.setAdapter(mAdapter);


        String[] names = { "Наш главный праздник", "Хорошее сочетание", "Гордость первого цеха", "Вместе создавать будущее", "Человек дела", "Игра, которую любят", "Ритм спартакиады"};
        listView = (ListView) view.findViewById(R.id.listTrud);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.item_list,names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(R.string.trud_string);
    }

    private ArrayList getVipusk() {
        ArrayList results = new ArrayList<Vivi>();
        for (int index = 0; index < 10; index++) {
            Vivi obj = new Vivi("Выпуск № " + (index +1));
            results.add(index, obj);
        }
        return results;
    }



    @Override
    public void onItemClick(View view, int position) {
        String[] strings = {};
switch (position){
    case 0:
        strings = getResources().getStringArray(R.array.list);
        break;
    case 1:
        strings = getResources().getStringArray(R.array.list2);
        break;
    case 2:
        strings = getResources().getStringArray(R.array.list);
        break;
    case 3:
        strings = getResources().getStringArray(R.array.list2);
        break;
    case 4:
        strings = getResources().getStringArray(R.array.list);
        break;
    case 5:
        strings = getResources().getStringArray(R.array.list2);
        break;
    default:
        strings = getResources().getStringArray(R.array.list);
        break;
}
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.item_list,strings);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (listListener != null) {
            listListener.itemClicked(i);}

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listListener = (ListListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onSomeEventListener");
        }
    }
}

