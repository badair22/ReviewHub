package com.bignerdranch.android.reviewhub.ui.home;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

import com.bignerdranch.android.reviewhub.DatabaseHelper;
import com.bignerdranch.android.reviewhub.Restaurants;
import com.bignerdranch.android.reviewhub.ui.details.Details;
import com.bignerdranch.android.reviewhub.ui.review.Review;

import java.util.ArrayList;
import java.util.List;

public class Home {
    private static Home sHome;
    private List<Review> mReviews;
    private SQLiteDatabase mDatabase;
    public static Home get(Context context) {
        if (sHome == null) {
            sHome = new Home(context);
        }
        return sHome;
    }

    private Home(Context context) {
        mDatabase = new DatabaseHelper(context).getWritableDatabase();
        mReviews = new ArrayList<>();
        //Review review = new Review();
        //review.setTitle("Olive Garden");
        //review.setRating("5");
        //mReviews.add(review);
    }

    public List<Review> getReviews() {
        return mReviews;
    }
}
