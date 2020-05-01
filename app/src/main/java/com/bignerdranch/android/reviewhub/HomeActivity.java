package com.bignerdranch.android.reviewhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bignerdranch.android.reviewhub.ui.details.Details;
import com.bignerdranch.android.reviewhub.ui.home.Home;
import com.bignerdranch.android.reviewhub.ui.home.HomeFragment;
import com.bignerdranch.android.reviewhub.ui.review.Review;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    //private List<Review> mReviews;
    //private AppBarConfiguration mAppBarConfiguration;

    public static class HomeViewHolder extends RecyclerView.ViewHolder {
        public TextView mName;
        public TextView mRating;

        public HomeViewHolder(View v) {
            super (v);
            mName = (TextView) itemView.findViewById(R.id.show_name);
            mRating = (TextView) itemView.findViewById(R.id.show_rating);

        }
    }

    public static final String REVIEWS = "reviews";
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseRecyclerAdapter<Review, HomeViewHolder> mFirebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycle);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setStackFromEnd(true);
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Review, HomeViewHolder>(
                Review.class,
                R.layout.restaurant_list,
                HomeViewHolder.class,
                mFirebaseDatabaseReference.child(REVIEWS)) {
            @Override
            protected void populateViewHolder(HomeViewHolder homeViewHolder, Review review, int position) {
                homeViewHolder.mName.setText(review.getName());
                homeViewHolder.mRating.setText(review.getRating().toString());
            }
        };

        mFirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                int totalCount = mFirebaseAdapter.getItemCount();
                int lastVisible = mLinearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (lastVisible == -1 || (positionStart >= (totalCount -1) && lastVisible == (positionStart -1))) {
                    mRecyclerView.scrollToPosition(positionStart);
                }
            }
        });

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mFirebaseAdapter);
       // this.createFragment();


    }

/*   protected Fragment createFragment() {
        return new HomeFragment();
    }*/
}

