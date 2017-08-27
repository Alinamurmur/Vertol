package com.example.alinamurmur.myprojektiswork.Fragments;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alinamurmur.myprojektiswork.Interfaces.eventListener;
import com.example.alinamurmur.myprojektiswork.MainActivity;
import com.example.alinamurmur.myprojektiswork.R;

public class NotificationsFragment extends Fragment implements  AdapterView.OnItemClickListener {
    eventListener someEventListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment7, container, false);

        String[] names = { "Турнир", "Кубок", "Голос", "Еще что-то", "И еще" };
        ListView listView = (ListView) view.findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.item_list,names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(R.string.notif_string);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        someEventListener.onEventSelected("Событие "+(i+1));

      /**
        Context context = getActivity();

        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Resources res = context.getResources();

        Notification.Builder builder = new Notification.Builder(getContext());

        builder.setContentIntent(contentIntent)
                .setTicker("Последнее китайское предупреждение!")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.helicopter)
                .setContentTitle("Напоминание")
                .setContentText("Пора покормить кота"); // Текст уведомления

        Notification notification = builder.getNotification();

        NotificationManager notificationManager1 = ( NotificationManager ) getActivity().getSystemService( getActivity().NOTIFICATION_SERVICE );
        notificationManager1.notify(1, notification);
       **/
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

