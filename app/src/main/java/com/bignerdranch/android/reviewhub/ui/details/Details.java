package com.bignerdranch.android.reviewhub.ui.details;

import java.util.UUID;

public class Details {
    public UUID mId;
    public String mName;
    public String mRating;


    public UUID getId() {
        return mId;
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

