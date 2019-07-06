package com.rajdiran.android.movies.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rajdiran.android.movies.Constants;
import com.rajdiran.android.movies.R;
import com.rajdiran.android.movies.activity.MovieDetailAcitvity;
import com.rajdiran.android.movies.service.response.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    private List<Movie> movies;

    public MovieListAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_movie, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final Movie movie = movies.get(position);

        holder.movieTitle.setText(movie.getTitle());

        if (!TextUtils.isEmpty(movie.getPosterUrl())) {
            Picasso.with(holder.movieImage.getContext())
                    .load(movie.getPosterUrl().trim())
                    .into(holder.movieImage);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MovieDetailAcitvity.class);
                intent.putExtra(Constants.Keys.KEY_MOVIE, movie);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView movieTitle;
        public ImageView movieImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            movieTitle = itemView.findViewById(R.id.movie_title);
            movieImage = itemView.findViewById(R.id.movie_image);

        }
    }

}
