package com.fiid.moviecataloguesub1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MoviesAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movies> movies = new ArrayList<>();

    public void setMovies(ArrayList<Movies> movies) {
        this.movies = movies;
    }

    public MoviesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.movies_item, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Movies movies = (Movies) getItem(position);
        viewHolder.bind(movies);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtTitle;
        private TextView txtDesc;
        private ImageView imgPoster;

        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.titleMov);
            txtDesc = view.findViewById(R.id.descMov);
            imgPoster = view.findViewById(R.id.imgMov);
        }

        void bind(Movies movies){
            txtTitle.setText(movies.getTitle());
            txtDesc.setText(movies.getDescription());
            imgPoster.setImageResource(movies.getPhoto());
        }
    }
}
