package com.fiid.moviecataloguesub1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MoviesAdapter adapter;
    private String[] movies_title;
    private String[] movies_description;
    private TypedArray movies_poster;
    private ArrayList<Movies> allMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        adapter = new MoviesAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movies movies = allMovies.get(position);
                Intent detailIntent = new Intent(MainActivity.this, DetailMovies.class);
                detailIntent.putExtra(DetailMovies.EXTRA_MOVIES, movies);
                startActivity(detailIntent);
            }
        });
    }

    private void addItem() {
        allMovies = new ArrayList<>();

        for (int i = 0; i < movies_title.length; i++){
            Movies movies = new Movies(movies_poster.getResourceId(i, -1), movies_title[i], movies_description[i]);
            allMovies.add(movies);
        }

        adapter.setMovies(allMovies);
        movies_poster.recycle();
    }

    private void prepare() {
        movies_title = getResources().getStringArray(R.array.movies_name);
        movies_description = getResources().getStringArray(R.array.movies_description);
        movies_poster = getResources().obtainTypedArray(R.array.movies_poster);
    }
}
