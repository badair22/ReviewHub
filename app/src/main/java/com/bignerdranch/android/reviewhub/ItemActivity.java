package com.bignerdranch.android.reviewhub;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.bignerdranch.android.reviewhub.ui.item.ItemFragment;

public class ItemActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_item);
        this.createFragment();
    }

    public void submit(View view) {
        finish();
    }

    public void cancel(View view) {
        finish();
    }

    protected Fragment createFragment() {
        return new ItemFragment();
    }
}
