package com.bignerdranch.android.reviewhub.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bignerdranch.android.reviewhub.DetailsActivity;
import com.bignerdranch.android.reviewhub.HomeActivity;
import com.bignerdranch.android.reviewhub.ItemActivity;
import com.bignerdranch.android.reviewhub.MainActivity;
import com.bignerdranch.android.reviewhub.R;
import com.bignerdranch.android.reviewhub.ToolsActivity;
import com.bignerdranch.android.reviewhub.ui.details.Details;
import com.bignerdranch.android.reviewhub.ui.item.Item;
import com.bignerdranch.android.reviewhub.ui.review.Review;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class HomeFragment extends Fragment {

    //private Review mReviews;
        public TextView mName;
        public TextView mRating;
        public LinearLayout mMove;
        public Review review;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mReviews = new Review();
        updateUI();
    }

    private void updateUI() {
        Home home = Home.get(getActivity());
        List<Review> reviews = home.getReviews();

    }

/*    private void updateUI() {
        Review reviewTest = Review.get(getActivity());
        List<Review> reviews = reviewTest.getReview();

        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.restaurant_list, container, false);
        /*        Details details = new Details();
        details.setItemName("Restaurant Name: Olive Garden");
        details.setItemRating("Rating: 5");*/

            //mTitleTextView.setText(details.getItemName() +" \n"+ details.getPrice());
        mName = (TextView) v.findViewById(R.id.show_name);
        mMove = (LinearLayout) v.findViewById(R.id.add_new_item);
        /*mMove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mName = (TextView) view.findViewById(R.id.show_name);
                String test = mName.getText().toString();
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("name", mName.getText());
                startActivity(intent);
            }
        });*/
           // mRating = (TextView) v.findViewById(R.id.rating_number);

        return v;
        }
/*    public void bind(Review reviews) {
        mReviews = reviews;
        mTitleTextView.setText(mReviews.getTitle());
    }*/




        /*public void bind(Review review) {
            mReview = review;
            mTitleTextView.setText(mReview.getTitle());
            mRating.setText(mReview.getRating().toString());
        }*/
    }

/*    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        private List<Review> mReviews;
        public CrimeAdapter(List<Review> crimes) {
            mReviews = crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            int layout = 0;
            switch(viewType) {
                case 0:
                    layout = R.layout.list_item_crime;
                    break;
                case 1:
                    layout = R.layout.list_item_police;
                    break;
            }

            View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
            return new CrimeHolder(view);
        }*/
