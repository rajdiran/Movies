package com.rajdiran.android.movies.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.common.eventbus.Subscribe;
import com.rajdiran.android.movies.Constants;
import com.rajdiran.android.movies.R;
import com.rajdiran.android.movies.adapter.MovieListAdapter;
import com.rajdiran.android.movies.service.MyServiceManager;
import com.rajdiran.android.movies.service.ServiceEvent;
import com.rajdiran.android.movies.service.response.MovieListResponse;

public class HomeActivity extends BaseActivity {

    private RecyclerView mMoviesListView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();

        fetchMovies();

    }

    /* Initialize all the views in below method */
    private void initViews() {
        mMoviesListView = (RecyclerView) findViewById(R.id.movies_list);
        mMoviesListView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mMoviesListView.setLayoutManager(layoutManager);
    }

    /* The below method is to fetch movies from server */
    private void fetchMovies() {
        MyServiceManager moviesServiceManager = MyServiceManager.getInstance(HomeActivity.this);
        moviesServiceManager.getMovieList();
    }


    /*
    The below method will be invoked whever event is posted with ServiceEvent object.
     */
    @Subscribe
    public void onResponseAvailable(final ServiceEvent serviceEvente) {

        if (Constants.Events.EVENT_FETCH_MOVIES.equalsIgnoreCase(serviceEvente.getEventId())) {
            if (null != serviceEvente.getResponse()) {

                if (serviceEvente.getResponse() instanceof MovieListResponse) {
                    MovieListResponse movieListResponse = (MovieListResponse) serviceEvente.getResponse();

                    if (null != movieListResponse && !movieListResponse.getMovies().isEmpty()) {
                        MovieListAdapter movieListAdapter = new MovieListAdapter(movieListResponse.getMovies());
                        mMoviesListView.setAdapter(movieListAdapter);
                    } else {
                        Toast.makeText(HomeActivity.this, getString(R.string.no_movies), Toast.LENGTH_SHORT).show();
                    }

                }

            } else {
                // Handle error
                Toast.makeText(HomeActivity.this, getString(R.string.error_while_retreiving), Toast.LENGTH_SHORT).show();
            }
        }

    }

}
