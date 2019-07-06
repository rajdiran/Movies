package com.rajdiran.android.movies.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.rajdiran.android.movies.Constants;
import com.rajdiran.android.movies.service.response.MovieListResponse;
import com.rajdiran.android.movies.utils.Common;

import org.json.JSONObject;

public class MyServiceManager {

    private static MyServiceManager mMoviesServiceManager = null;

    private RequestQueue mRequestQueue = null;

    private ImageLoader mImageLoader;

    private MyServiceManager() {
    }

    private MyServiceManager(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
        mImageLoader = new ImageLoader(this.mRequestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);

            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }

            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }
        });
    }

    public static MyServiceManager getInstance(Context context) {
        if (null == mMoviesServiceManager) {
            mMoviesServiceManager = new MyServiceManager(context);
        }
        return mMoviesServiceManager;
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    public void getMovieList() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, Constants.URL_MOVIES_LIST, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        MovieListResponse movieListResponse = new Gson().fromJson(response.toString(), MovieListResponse.class);
                        ServiceEvent serviceEvent = new ServiceEvent();
                        serviceEvent.setResponse(movieListResponse);
                        serviceEvent.setEventId(Constants.Events.EVENT_FETCH_MOVIES);
                        Common.postEvent(serviceEvent);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ServiceEvent serviceEvent = new ServiceEvent();
                        serviceEvent.setResponse(null);
                        serviceEvent.setEventId(Constants.Events.EVENT_FETCH_MOVIES);
                        Common.postEvent(serviceEvent);
                    }
                });

        mRequestQueue.add(jsonObjectRequest);

    }

}
