package com.fiid.moviecataloguesub1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovies extends AppCompatActivity {
    public static final String EXTRA_MOVIES = "extra_movies";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movies);

        TextView titleMov = findViewById(R.id.titleMovDet);
        TextView descMov = findViewById(R.id.descMovDet);
        ImageView imgMov = findViewById(R.id.imgMovDet);

        Movies movies = getIntent().getParcelableExtra(EXTRA_MOVIES);
        titleMov.setText(movies.getTitle());
        descMov.setText(movies.getDescription());
        imgMov.setImageResource(movies.getPhoto());
    }
}
