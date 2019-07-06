package com.rajdiran.android.movies.service.response;

import com.google.gson.Gson;

import java.util.List;

public class MovieListResponse extends BaseResponse {

    public List<Movie> movies;

    public List<Movie> getMovies() {
        return this.movies;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this).toString();
    }
}
