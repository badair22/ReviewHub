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

import androidx.fragment.app.Fragment;

import com.bignerdranch.android.reviewhub.R;

public class ReviewFragment extends Fragment {

    private Button mSaveButton;
    private Button mCancelButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new, container, false);
        

        mSaveButton = (Button) v.findViewById(R.id.submit_review);
        mSaveButton.setEnabled(true);

        mCancelButton = (Button) v.findViewById(R.id.cancel_review);
        mCancelButton.setEnabled(true);

        return v;
    }
}
