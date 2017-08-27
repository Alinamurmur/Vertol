package com.example.alinamurmur.myprojektiswork.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alinamurmur.myprojektiswork.Models.Article;
import com.example.alinamurmur.myprojektiswork.R;
import com.rd.PageIndicatorView;
import com.rd.animation.AnimationType;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

/**
 * Created by Резидент on 24.08.2017.
 */

public class AdapterForMainPager extends FragmentPagerAdapter {

    static Context context = null;

    public AdapterForMainPager(Context con, FragmentManager fm) {
        super(fm);
        this.context = con;
    }

    @Override
    public Fragment getItem(int position) {
        ArrayList<Article> list = getData();

        return  FragmentPagerM.newInstance(list.get(position).getTitle(),
                list.get(position).getDate(),list.get(position).getImg());
    }

    @Override
    public int getCount() {
        return 3;
    }

    private static ArrayList<Article> getData() {

        ArrayList results = new ArrayList<Article>();

        String[] names = {"Гордость первого цеха",
                "Вместе создавать будущее",
                "Ритм спартакиады"};
        String[] dates = {"20.03.17",
                "21.04.17", "22.05.17"};

        String[] imgs = {"http://a.dilcdn.com/bl/wp-content/uploads/sites/6/2017/05/REVIEWS-40TH-FEATURED-169-1088x816.jpg",
                "http://cdn0.wideopencountry.com/wp-content/uploads/2015/12/han-solo-793x526.png",
                "http://i.imgur.com/lJEyaEm.jpg"};

        for (int index = 0; index < 3; index++) {
            Article data = new Article(names[index],dates[index],imgs[index]);
            results.add(index, data);

        }
        return results;

    }

    public static class FragmentPagerM extends Fragment {

        String titleM, dateM, urlM;
        Context context;

        public FragmentPagerM() {
        }

        public static FragmentPagerM newInstance(String name, String date, String img) {
            FragmentPagerM fragmentPagerM = new FragmentPagerM();
            Bundle args = new Bundle();
            args.putString("title", name);
            args.putString("date", date);
            args.putString("img", img);
            fragmentPagerM.setArguments(args);
            return fragmentPagerM;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            titleM = getArguments().getString("title");
            dateM = getArguments().getString("date");
            urlM = getArguments().getString("img");
            context = getActivity();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            ViewGroup rootView = (ViewGroup) inflater.inflate(
                    R.layout.cardvig, container, false);

            TextView textTitle = (TextView) rootView.findViewById(R.id.titleMain);
            TextView dateText = (TextView) rootView.findViewById(R.id.dateMain);
            final LinearLayout linearM = (LinearLayout) rootView.findViewById(R.id.mainNewsLayout);

            textTitle.setText(titleM);
            dateText.setText(dateM);

                Picasso.with(getActivity()).load(urlM).into((new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        /////////////////
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            linearM.setBackground(new BitmapDrawable(bitmap));
                        }
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        Log.d("TAG", "FAILED");
                        //linearM.setBackground(header);
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                }));



            return rootView;
        }
    }
}
