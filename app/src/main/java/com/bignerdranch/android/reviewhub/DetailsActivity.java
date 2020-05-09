package com.bignerdranch.android.reviewhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bignerdranch.android.reviewhub.ui.details.DetailsFragment;
import com.bignerdranch.android.reviewhub.ui.item.Item;
import com.bignerdranch.android.reviewhub.ui.review.Review;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailsActivity extends AppCompatActivity {
    public static class DetailsViewHolder extends RecyclerView.ViewHolder {
        public TextView mItemName;
        public TextView mRating;
        public TextView mPrice;
        public TextView mItemType;

        public DetailsViewHolder(View v) {
            super (v);
            mItemName = (TextView) itemView.findViewById(R.id.item_name);
            mItemType = (TextView) itemView.findViewById(R.id.item_restaurant);
            mRating = (TextView) itemView.findViewById(R.id.item_rating);
            mPrice = (TextView) itemView.findViewById(R.id.item_price);
            /*v.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                    intent.putExtra("name", mName.getText());
                    startActivity(intent);
                }
            });*/
        }
    }
    private TextView mItemName;
    private String name;
    private AppBarConfiguration mAppBarConfiguration;

    public static final String ITEMS = "items";
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseRecyclerAdapter<Item, DetailsActivity.DetailsViewHolder> mFirebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_details);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        mItemName = (TextView) findViewById(R.id.item_name);
        if (b != null) {
            String j = (String) b.get("name");
            mItemName.setText(j);
        }

        mRecyclerView = (RecyclerView)findViewById(R.id.item_recycle);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setStackFromEnd(true);
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Item, DetailsActivity.DetailsViewHolder>(
                Item.class,
                R.layout.item_list,
                DetailsActivity.DetailsViewHolder.class,
                mFirebaseDatabaseReference.child(ITEMS)) {
            @Override
            protected void populateViewHolder(DetailsActivity.DetailsViewHolder detailsViewHolder, Item item, int position) {
                detailsViewHolder.mItemName.setText("Item: " + item.getItemName());
                detailsViewHolder.mItemType.setText("Restaurant: " + item.getItemType());
                detailsViewHolder.mRating.setText("Rating: " + item.getRating().toString());
                detailsViewHolder.mPrice.setText("Price: " + item.getPrice().toString());
            }

            };

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    public void itemActivity (View view){
        Intent intent = new Intent (this, ItemActivity.class);
        startActivity(intent);
    }

    public void goHome(View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    protected Fragment createFragment() {
        return new DetailsFragment();
    }
}
