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
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bignerdranch.android.reviewhub.DetailsActivity;
import com.bignerdranch.android.reviewhub.HomeActivity;
import com.bignerdranch.android.reviewhub.ItemActivity;
import com.bignerdranch.android.reviewhub.R;
import com.bignerdranch.android.reviewhub.Restaurants;
import com.bignerdranch.android.reviewhub.ui.home.Home;
import com.bignerdranch.android.reviewhub.ui.item.Item;
import com.bignerdranch.android.reviewhub.ui.review.Review;

import java.util.List;

public class DetailsFragment extends Fragment {
    private TextView mItemName;
    private TextView mItemRating;
    private Button mAddItemButton;
    private Button mHomeButton;
    private Button mUpdateButton;
    //private Details mDetails;
    private Review mReview;
    String name;
    String rating;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mReview = new Review();
        updateUI();
    }

    private void updateUI() {
        /*Home home = Home.get(getActivity());
        List<Review> reviews = Home.getReviews();*/

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        //final Review review = new Review(name, rating);
        //details.setItemName("Restaurant Name: Olive Garden");
        //details.setItemRating("Rating: 5");
        mItemName = (TextView) v.findViewById(R.id.item_name);
        mItemName.setText("Test");

        /*mItemName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mItemName.setText("Olive Garden");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }*/


        mItemRating = (TextView) v.findViewById(R.id.item_rating);
        //mItemRating.setText(mReview.getRating());
        //mItemRating.addTextChangedListener(new TextWatcher() {
/*            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mReview.setRating(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/

        mAddItemButton = (Button) v.findViewById(R.id.add_item);
        /*mAddItemButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                String name = details.getItemName();
                String rating = mReview.getRating();
                intent.putExtra("name", name);
                intent.putExtra("rating", rating);
                startActivity(intent);
            }
        });*/

        mHomeButton = (Button) v.findViewById(R.id.go_home);

        //mUpdateButton = (Button) v.findViewById(R.id.update);
        return v;
    }
}
