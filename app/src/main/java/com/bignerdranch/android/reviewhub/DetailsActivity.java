package com.bignerdranch.android.reviewhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.bignerdranch.android.reviewhub.ui.details.DetailsFragment;

public class DetailsActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_details);
        this.createFragment();
    }

    public void itemActivity (View view){
        Intent intent = new Intent (this, ItemActivity.class);
        startActivity(intent);
    }

    public void goHome(View view) {
        finish();
    }

    protected Fragment createFragment() {
        return new DetailsFragment();
    }
}