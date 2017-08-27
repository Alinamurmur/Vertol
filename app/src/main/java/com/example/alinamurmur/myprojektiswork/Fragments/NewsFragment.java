package com.example.alinamurmur.myprojektiswork.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.alinamurmur.myprojektiswork.Adapters.NewsAdapter;
import com.example.alinamurmur.myprojektiswork.Interfaces.eventListener;
import com.example.alinamurmur.myprojektiswork.Models.Article;
import com.example.alinamurmur.myprojektiswork.R;
import com.example.alinamurmur.myprojektiswork.RecyclerItemClickListener;
import com.example.alinamurmur.myprojektiswork.Volley.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alina on 29.06.2017.
 */

public class NewsFragment extends Fragment {

    private List<Article> news = new ArrayList<Article>();
    private static String BUNDLE_CONTENT = "url";
    private String url;
    private int section;
    NewsAdapter adapter;
    ProgressDialog dialog;
    Context context;
    eventListener someEventListener;

    public static NewsFragment newInstance(String content, int section) {
        NewsFragment f = new NewsFragment();
        Bundle b = new Bundle();
        b.putString(BUNDLE_CONTENT, content);
        b.putInt("section", section);
        f.setArguments(b);
        return f;
    }


    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(BUNDLE_CONTENT)) {
            url = getArguments().getString(BUNDLE_CONTENT);
            section = getArguments().getInt("section");
        } else {
            throw new IllegalArgumentException("Must be created through newInstance(...)");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler1);

            dialog = new ProgressDialog(getActivity());
            dialog.setMessage("Загрузка...");
            dialog.setCancelable(true);
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    getActivity().onBackPressed();
                }
            });
            showDialog();
            getAndInitData();

        adapter = new NewsAdapter(getActivity(), news);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int id = adapter.news.get(position).getId();
                String title = adapter.news.get(position).getTitle();
                someEventListener.onArticleSelected(title, id, section);

            }
        }));

        return view;
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
                                Article article = new Article();
                                article.setId(object.getInt("id"));
                                article.setTitle(object.getString("title"));
                                article.setImg(object.getString("image"));
                                article.setDate(object.getString("date")); ;

                                news.add(article) ;
                            }
                            hideDialog();
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR!!!", error.toString()) ;
            }
        }) ;
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }

    public void showDialog(){
        if(!dialog.isShowing())
            dialog.show();
    }

    public void hideDialog(){
        if(dialog.isShowing())
            dialog.hide();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        dialog.hide();
        dialog.dismiss();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Новости");

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
