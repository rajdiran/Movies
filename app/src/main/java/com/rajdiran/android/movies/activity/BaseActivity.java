package com.rajdiran.android.movies.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rajdiran.android.movies.utils.Common;

/*

    It is the base activity for this applicaiton. It will have all the common functions related to activity

 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Common.registerEventBus(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Common.unregisterEventBus(this);
    }

}
