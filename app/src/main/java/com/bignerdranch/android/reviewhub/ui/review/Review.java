package com.bignerdranch.android.reviewhub.ui.review;

import java.util.Date;
import java.util.UUID;

public class Review {
    public UUID mId;
    public String mTitle;
    public String mItem;
    public String mPrice;
    public String mSummary;
    public String mRating;


    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getSummary() {
        return mItem;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public String getItem() {
        return mItem;
    }

    public void setItem(String item) {
        mItem = item;
    }

    public String getRating() {
        return mRating;
    }

    public void setRating(String rating) {
        mRating = rating;
    }
}
