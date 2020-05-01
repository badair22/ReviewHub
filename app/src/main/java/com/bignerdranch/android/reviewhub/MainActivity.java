package com.bignerdranch.android.reviewhub;

import android.content.Intent;
import android.os.Bundle;

import com.bignerdranch.android.reviewhub.ui.review.Review;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static class HomeViewHolder extends RecyclerView.ViewHolder {
        public TextView mName;
        public TextView mRating;

        public HomeViewHolder(View v) {
            super (v);
            mName = (TextView) itemView.findViewById(R.id.show_name);
            mRating = (TextView) itemView.findViewById(R.id.show_rating);
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

    public static final String REVIEWS = "reviews";
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseRecyclerAdapter<Review, MainActivity.HomeViewHolder> mFirebaseAdapter;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ToolsActivity.class));
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.nav_tools)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_home);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycle);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setStackFromEnd(true);
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Review, MainActivity.HomeViewHolder>(
                Review.class,
                R.layout.restaurant_list,
                MainActivity.HomeViewHolder.class,
                mFirebaseDatabaseReference.child(REVIEWS)) {
            @Override
            protected void populateViewHolder(MainActivity.HomeViewHolder homeViewHolder, Review review, int position) {
                homeViewHolder.mName.setText("Restaurant: " + review.getName());
                homeViewHolder.mRating.setText("Rating: " + review.getRating().toString());

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*@Override
    public void onStart() {
        super.onStart();
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
    }*/

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void update() {
    }


}
