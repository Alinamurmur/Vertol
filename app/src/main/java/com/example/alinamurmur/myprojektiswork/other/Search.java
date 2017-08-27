package com.example.alinamurmur.myprojektiswork.other;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alinamurmur.myprojektiswork.R;

public class Search extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent = getIntent();
        //Проверяем тип Intent
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {

           // String query = intent.getStringExtra(SearchManager.QUERY);
            //Выполняем поиск
            //showResults(query);
        }
    }
}
