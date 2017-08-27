package com.example.alinamurmur.myprojektiswork.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alinamurmur.myprojektiswork.R;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_POSITIVE;

public class TelKniga  extends Fragment{
    int int2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.telkniga_fragment,container,false);

        final String[] names = { "Директор", "Главбух", "Менеджер по продажам", "Главный инженер", "Завхоз", "Гомер"};
        ListView listView = (ListView) view.findViewById(R.id.bookphone);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.item_list,names);
        listView.setAdapter(adapter);
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                builder.setMessage(R.string.dialog_message)
                        .setTitle(names[i]);
                AlertDialog dialog = builder.create();

                dialog.setButton(BUTTON_POSITIVE,"Позвонить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String p = "tel:" + "89087074038";
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse(p));
                        startActivity(intent);
                    }

                });
                dialog.setButton(BUTTON_NEGATIVE,"Написать", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ivp@gmail.com"});
                        emailIntent.setType("message/rfc822");
                        startActivity(Intent.createChooser(emailIntent,
                                "Отправка письма..."));

                    }
                });
                dialog.show();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Телефонная книга");
    }
}
