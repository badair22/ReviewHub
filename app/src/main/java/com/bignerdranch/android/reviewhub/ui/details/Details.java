package com.bignerdranch.android.reviewhub.ui.details;

import java.util.UUID;

public class Details {
    public String mName;
    public String mRating;


    public Details(String name, String rating) {
        this.mName = name;
        this.mRating = rating;
    }

    public String getItemName() {
        return mName;
    }

    public void setItemName(String name) {
        mName = name;
    }

    public String getPrice() {
        return mRating;
    }

    public void setItemRating(String rating) {
        mRating = rating;
    }

}

