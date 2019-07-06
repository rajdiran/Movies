package com.rajdiran.android.movies.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rajdiran.android.movies.R;

public class LabelContentView extends LinearLayout {

    private TextView mLabelView;

    private TextView mContentView;

    public LabelContentView(Context context) {
        this(context, null);
    }

    public LabelContentView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_label_content, this, true);

        mLabelView = (TextView) findViewById(R.id.label);
        mContentView = (TextView) findViewById(R.id.content);

    }

    public void setLabel(String label) {
        mLabelView.setText(label);
    }

    public void setContent(String content) {
        mContentView.setText(content);
    }

}
