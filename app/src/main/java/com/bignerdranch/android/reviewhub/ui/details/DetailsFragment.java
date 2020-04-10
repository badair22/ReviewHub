package com.bignerdranch.android.reviewhub.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bignerdranch.android.reviewhub.ItemActivity;
import com.bignerdranch.android.reviewhub.R;
import com.bignerdranch.android.reviewhub.Restaurants;
import com.bignerdranch.android.reviewhub.ui.item.Item;

public class DetailsFragment extends Fragment {
    private EditText mItemName;
    private EditText mItemRating;
    private Button mAddItemButton;
    private Button mHomeButton;
    private Button mUpdateButton;
    private Details mDetails;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetails = new Details();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_details, container, false);

        mItemName = (EditText) v.findViewById(R.id.item_name);
        mItemName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mDetails.setItemName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mItemRating = (EditText) v.findViewById(R.id.item_rating);
        mItemRating.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mDetails.setItemRating(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mAddItemButton = (Button) v.findViewById(R.id.add_item);
        mHomeButton = (Button) v.findViewById(R.id.go_home);
        mUpdateButton = (Button) v.findViewById(R.id.update);
        return v;
    }
}
