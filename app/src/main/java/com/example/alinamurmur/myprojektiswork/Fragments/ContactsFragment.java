package com.example.alinamurmur.myprojektiswork.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.example.alinamurmur.myprojektiswork.R;

/**
 * Created by Admin on 19.07.2017.
 */

public class ContactsFragment extends Fragment {
    private static String BUNDLE_CONTENT = "content";
    private int section;

    public static ContactsFragment newInstance( int section) {
    ContactsFragment contF = new ContactsFragment();
        Bundle b = new Bundle();
        b.putInt(BUNDLE_CONTENT, section);
        contF.setArguments(b);
        return contF;
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
        View view = inflater.inflate(R.layout.activity_contacts, container, false);
        TextView zagolovok = (TextView) view.findViewById(R.id.nameCo);
        TextView cont = (TextView) view.findViewById(R.id.contakti);
        TextView cont2 = (TextView) view.findViewById(R.id.cont2);

        String tel ="Телефон: ";

        switch (section){
            case 1:
                zagolovok.setText("ФСК Стрелок");
                cont.setText(tel + "123123");
                break;
            case 2:
                zagolovok.setText("СДК Ростов");
                cont.setText(tel + getResources().getString(R.string.ContSDK));
                cont2.setText(getResources().getString(R.string.ContSDK2));
                break;
            case 3:
                zagolovok.setText("Молодежь Роствертола");
                cont.setText(tel + getResources().getString(R.string.ContMol));
                cont2.setText(R.string.ContMol2);
                break;
        }

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p ="tel: 123123";
                switch (section){
                    case 1:
                        p = "tel:" + getString(R.string.ContMol);
                        break;
                    case 2:
                        p = "tel:" + getString(R.string.ContSDK);
                        break;
                    case 3:
                        p = "tel:" + getString(R.string.ContMol);
                        break;
                }
                Intent intent = new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse(p));
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Контакты");
    }

}
