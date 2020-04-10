package com.bignerdranch.android.reviewhub;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.bignerdranch.android.reviewhub.ui.home.HomeFragment;

public class HomeActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        this.createFragment();
    }

    protected Fragment createFragment() {
        return new HomeFragment();
    }
}

