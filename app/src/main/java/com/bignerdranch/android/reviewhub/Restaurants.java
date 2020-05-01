package com.bignerdranch.android.reviewhub;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bignerdranch.android.reviewhub.ui.review.Review;

import java.util.ArrayList;
import java.util.List;

public class Restaurants {
    private static Restaurants sRestaurants;
    private List<Review> mReviews;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private Restaurants(Context context) {
        mContext = context.getApplicationContext();
        mReviews = new ArrayList<>();
    }

    public List<Review> getReviews() {
        return mReviews;
    }

/*    public Review getReview(UUID id) {
        for (Review review : mReviews) {
            if (Review.getId().equals(id)) {
                return review;
            }
        }
        return null;
    }*/
}
