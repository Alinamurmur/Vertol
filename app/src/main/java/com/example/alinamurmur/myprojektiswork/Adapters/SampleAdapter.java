package com.example.alinamurmur.myprojektiswork.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.alinamurmur.myprojektiswork.DataForDelete.DataClass;
import com.example.alinamurmur.myprojektiswork.Fragments.FragmentForDataAdapter;
import com.example.alinamurmur.myprojektiswork.R;

import java.util.ArrayList;


public class SampleAdapter extends FragmentPagerAdapter {
    static Context context = null;

    public SampleAdapter(Context ctxt, FragmentManager mgr) {
        super(mgr);
        this.context = ctxt;
    }

    @Override
    public int getCount() {
        return(7);
    }

    @Override
    public Fragment getItem(int position) {

        ArrayList<DataClass> list = getData();

        return  FragmentForDataAdapter.newInstance(position,
                list.get(position).getName(),
                list.get(position).getText(),list.get(position).getImg());

    }


    private static ArrayList<DataClass> getData() {

        ArrayList results = new ArrayList<DataClass>();
        String[] names = {"Наш главный праздник", "Хорошее сочетание",
                "Гордость первого цеха", "Вместе создавать будущее", "Человек дела",
                "Игра, которую любят", "Ритм спартакиады"};

        String[] text = {context.getResources().getString(R.string.text1),
                context.getResources().getString(R.string.text2), context.getResources().getString(R.string.text3),
                context.getResources().getString(R.string.text4), context.getResources().getString(R.string.text5),
                context.getResources().getString(R.string.text6), context.getResources().getString(R.string.text7)};

        String[] imgs = {"https://pp.userapi.com/c543100/v543100923/295e7/RUsboeu4U6c.jpg",
                "https://pp.userapi.com/c543100/v543100923/295f0/yOY3KAVYFSA.jpg",
                "https://pp.userapi.com/c543100/v543100923/295f9/sInYh6gw8k0.jpg",
                "https://pp.userapi.com/c543100/v543100923/29602/SzSxjqRsJbk.jpg",
                "https://pp.userapi.com/c543100/v543100923/2960b/sUfsno_YfuY.jpg",
                "https://pp.userapi.com/c543100/v543100923/29614/gSBrs3H_jqo.jpg",
                "https://pp.userapi.com/c543100/v543100923/2961d/LljwLHB6NIM.jpg"};

        for (int index = 0; index < 7; index++) {
            DataClass data = new DataClass(names[index], text[index], imgs[index]);
            results.add(index, data);
        }
        return results;


    }
}