package com.example.alinamurmur.myprojektiswork;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alinamurmur.myprojektiswork.Fragments.Vivi;

import java.util.ArrayList;



public class Adapter2 extends RecyclerView
        .Adapter<Adapter2
        .DataObjectHolder> {
    private ArrayList<Vivi> dateList;
    static int position =0;

    public static class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView label;
        LinearLayout linearLayout;

        public DataObjectHolder(final View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.textView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearlayout);
        }


    }
    public Adapter2(ArrayList<Vivi> myDataset) {
        dateList = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_vi, parent, false);

         DataObjectHolder dataObjectHolder = new DataObjectHolder(v);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        holder.label.setText(dateList.get(position).getmText1());;
    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }


    public static int getPositionV(){
        int a=position;
        return a;
    }
}


