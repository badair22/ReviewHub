package com.bignerdranch.android.reviewhub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.bignerdranch.android.reviewhub.ui.review.Review;
import com.bignerdranch.android.reviewhub.ui.review.ReviewFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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

import android.view.Menu;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ToolsActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private Button save;
    private EditText name, rating, state, city, summary;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_new);
        name = (EditText)findViewById(R.id.restaurant_name);
        rating = (EditText)findViewById(R.id.rating);
        state = (EditText)findViewById(R.id.state);
        city = (EditText)findViewById(R.id.city);
        summary = (EditText)findViewById(R.id.summary);
        save = (Button)findViewById(R.id.submit_review);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Review review = new Review(name.getText().toString(), Long.parseLong(rating.getText().toString())/*, state.getText().toString(), city.getText().toString(), summary.getText().toString()*/);
            mDatabaseReference.child("reviews").push().setValue(review);
            finish();
        }
        });
        this.createFragment();
    }

/*    public void submit(View view) {
        finish();
    }

    public void cancel(View view) {
        finish();
    }*/

    protected Fragment createFragment() {
        return new ReviewFragment();
    }

    public void goHome(View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }


}
