package com.rajdiran.android.movies.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;

import com.rajdiran.android.movies.Constants;
import com.rajdiran.android.movies.R;
import com.rajdiran.android.movies.service.response.Movie;
import com.rajdiran.android.movies.view.LabelContentView;
import com.squareup.picasso.Picasso;

public class MovieDetailAcitvity extends AppCompatActivity {

    private LabelContentView mMovieTitleView, mMovieYearView, mReleasedDateView, mWriterView, mMovieRuntimeView,
            mMovieActorsView, mLanguageView, mCountryView, mAwardsView;

    private ImageView mMovieImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        initViews();
        updateViews();
    }

    private void initViews() {
        mMovieImage = (ImageView) findViewById(R.id.movie_image);
        mMovieTitleView = (LabelContentView) findViewById(R.id.movie_title);
        mMovieYearView = (LabelContentView) findViewById(R.id.movie_year);
        mReleasedDateView = (LabelContentView) findViewById(R.id.movie_released_on);
        mWriterView = (LabelContentView) findViewById(R.id.writer);
        mMovieRuntimeView = (LabelContentView) findViewById(R.id.movie_runtime);
        mMovieActorsView = (LabelContentView) findViewById(R.id.movie_actors);
        mLanguageView = (LabelContentView) findViewById(R.id.language);
        mCountryView = (LabelContentView) findViewById(R.id.country);
        mAwardsView = (LabelContentView) findViewById(R.id.awards);
    }

    private void updateViews() {
        Bundle bundle = getIntent().getExtras();
        if (null != bundle && bundle.containsKey(Constants.Keys.KEY_MOVIE)) {
            Movie movie = (Movie) bundle.getSerializable(Constants.Keys.KEY_MOVIE);

            if (!TextUtils.isEmpty(movie.getPosterUrl())) {
                Picasso.with(this)
                        .load(movie.getPosterUrl().trim())
                        .into(mMovieImage);
            }

            mMovieTitleView.setLabel(getString(R.string.label_title));
            mMovieTitleView.setContent(movie.getTitle());

            mMovieYearView.setLabel(getString(R.string.label_year));
            mMovieYearView.setContent(movie.getYear());

            mReleasedDateView.setLabel(getString(R.string.label_released_on));
            mReleasedDateView.setContent(movie.getReleasedOn());

            mWriterView.setLabel(getString(R.string.label_writer));
            mWriterView.setContent(movie.getWriter());

            mMovieRuntimeView.setLabel(getString(R.string.label_runtime));
            mMovieRuntimeView.setContent(movie.getRunTime());

            mMovieActorsView.setLabel(getString(R.string.label_actors));
            mMovieActorsView.setContent(movie.getActors());

            mLanguageView.setLabel(getString(R.string.label_language));
            mLanguageView.setContent(movie.getLanguage());

            mCountryView.setLabel(getString(R.string.label_country));
            mCountryView.setContent(movie.getCountry());

            mAwardsView.setLabel(getString(R.string.label_awards));
            mAwardsView.setContent(movie.getAwards());

        }

    }

}
