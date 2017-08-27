package com.example.alinamurmur.myprojektiswork.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alinamurmur.myprojektiswork.R;

/**
 * Created by Alina on 14.07.2017.
 */

public class Anketa extends Fragment implements View.OnClickListener {
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anketa,container,false);

        EditText fio = (EditText)view.findViewById(R.id.fio);
        button = (Button)view.findViewById(R.id.buAnk);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Заявка принята", Toast.LENGTH_SHORT).show();
    }
}
