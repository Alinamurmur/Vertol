package com.example.alinamurmur.myprojektiswork.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alinamurmur.myprojektiswork.Models.Article;
import com.example.alinamurmur.myprojektiswork.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Admin on 14.07.2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    public List<Article> news;
    Context context;

    public NewsAdapter(Activity context, List<Article> news) {
        this.news = news;
        this.context = context;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_row, parent,false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Article article = news.get(position);
        final ImageView thumbnail = holder.thumbnail;

        holder.title.setText(article.getTitle());
        holder.date.setText(article.getDate());
        //Toast.makeText(getContext(), String.valueOf(article.getId()), Toast.LENGTH_SHORT).show();
        Picasso.with(getContext()).load(article.getImg()).placeholder(R.drawable.loading).into(thumbnail);


    }

    private Context getContext() {
        return this.context;
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView thumbnail;
        TextView title, date;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view);
            thumbnail = (ImageView) view.findViewById(R.id.imgCard);
            title = (TextView) view.findViewById(R.id.textView);
            //title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            date = (TextView) view.findViewById(R.id.timeTextView);
        }
    }

}
