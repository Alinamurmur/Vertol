package com.example.alinamurmur.myprojektiswork.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.alinamurmur.myprojektiswork.Interfaces.eventListener;
import com.example.alinamurmur.myprojektiswork.Models.Article;
import com.example.alinamurmur.myprojektiswork.R;
import com.example.alinamurmur.myprojektiswork.Volley.AppController;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Admin on 19.07.2017.
 */

public class ArticleFragment extends Fragment implements View.OnClickListener {


    private String title;
    private String url = "http://garazh.space/rvt/represent/get_article3.php";
    private int id;
    private int section;
    private Article article;
    eventListener someEventListener;


    public static ArticleFragment newInstance(String title, int id, int section) {
        ArticleFragment f = new ArticleFragment();
        Bundle b = new Bundle();
        b.putString("title", title);
        b.putInt("id", id);
        b.putInt("section", section);
        f.setArguments(b);
        return f;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey("title")) {
            title = getArguments().getString("title");
            id = getArguments().getInt("id");
            url += "?id="+id;
        } else {
            throw new IllegalArgumentException("Must be created through newInstance(...)");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_med, container, false);
        getAndInitData();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardView returnButton = (CardView) view.findViewById(R.id.returnToSection);
        returnButton.setOnClickListener(this);
        getActivity().setTitle(title);
    }

    public void getAndInitData(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try{
                            Log.d("MYAPP", response.toString()) ;
                            for(int i = 0; i < response.length(); i++){
                                JSONObject object =response.getJSONObject(i) ;
                                article = new Article();
                                article.setId(object.getInt("id"));
                                article.setSection(object.getInt("section"));
                                article.setTitle(object.getString("title"));
                                article.setImg(object.getString("image"));
                                article.setDate(object.getString("date"));
                                article.setText(object.getString("text"));

                                section = article.getSection();
                                TextView title = (TextView) getActivity().findViewById(R.id.title_article);
                                TextView text = (TextView) getActivity().findViewById(R.id.text_article);
                                ImageView img = (ImageView) getActivity().findViewById(R.id.img_article);
                                title.setText(article.getTitle());
                                text.setText(article.getText());
                                Picasso.with(getActivity()).load(article.getImg()).into(img);
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR!!!", error.toString()) ;
            }
        }) ;
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }

    @Override
    public void onClick(View view) {
            someEventListener.onReturnToSection(section);
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
