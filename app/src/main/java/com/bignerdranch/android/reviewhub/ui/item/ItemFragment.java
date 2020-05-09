package com.bignerdranch.android.reviewhub.ui.item;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bignerdranch.android.reviewhub.DetailsActivity;
import com.bignerdranch.android.reviewhub.HomeActivity;
import com.bignerdranch.android.reviewhub.MainActivity;
import com.bignerdranch.android.reviewhub.R;
import com.bignerdranch.android.reviewhub.ui.review.Review;

import java.io.Console;

public class ItemFragment extends Fragment {
    private EditText mItemName;
    private EditText mItemType;
    private EditText mPrice;
    private EditText mSummary;
    private EditText mRating;
    private Button mSaveButton;
    private Button mCancelButton;
    private Item mItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mItem = new Item();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item, container, false);

        mItemName = (EditText) v.findViewById(R.id.item_name);
        mItemName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mItem.setItemName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mItemType = (EditText) v.findViewById(R.id.item_type );
        mItemType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mItem.setItemType(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPrice = (EditText) v.findViewById(R.id.item_price);
        mPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mItem.setPrice(Long.parseLong(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSummary = (EditText) v.findViewById(R.id.item_summary);
        mSummary.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mItem.setSummary(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mRating = (EditText) v.findViewById(R.id.item_rating);
        mRating.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mItem.setRating(Long.parseLong(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSaveButton = (Button) v.findViewById(R.id.submit_item);
        /*mSaveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                String name = mItem.getItemName();
                String rating = mItem.getRating();
                intent.putExtra("name", name);
                intent.putExtra("rating", rating);
                startActivity(intent);
                if (mItem.mItemName != null) {
                    Log.d("print", "it is not null");
                }
            }
        });*/
        mSaveButton.setEnabled(true);


        mCancelButton = (Button) v.findViewById(R.id.cancel_item);
        mCancelButton.setEnabled(true);


        return v;
    }
}
