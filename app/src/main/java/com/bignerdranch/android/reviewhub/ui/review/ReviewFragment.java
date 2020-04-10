package com.bignerdranch.android.reviewhub.ui.review;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bignerdranch.android.reviewhub.R;

public class ReviewFragment extends Fragment {

    private EditText mRestaurant;
    private EditText mCity;
    private EditText mState;
    private EditText mSummary;
    private EditText mRating;
    private Button mSaveButton;
    private Button mCancelButton;
    private Review mReview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReview = new Review();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new, container, false);

        mRestaurant = (EditText) v.findViewById(R.id.restaurant_name);
        mRestaurant.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mReview.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mState = (EditText) v.findViewById(R.id.state);
        mState.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mReview.setItem(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCity = (EditText) v.findViewById(R.id.city);
        mCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mReview.setPrice(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSummary = (EditText) v.findViewById(R.id.summary);
        mSummary.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mReview.setSummary(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mRating = (EditText) v.findViewById(R.id.rating);
        mRating.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mReview.setRating(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSaveButton = (Button) v.findViewById(R.id.submit_review);
        mSaveButton.setEnabled(true);

        mCancelButton = (Button) v.findViewById(R.id.cancel_review);
        mCancelButton.setEnabled(true);

        return v;
    }
}
