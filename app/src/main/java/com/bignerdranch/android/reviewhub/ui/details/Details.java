package com.bignerdranch.android.reviewhub.ui.details;

import java.util.UUID;

public class Details {
    public UUID mId;
    public String mItemName;
    public String mItemRating;


    public UUID getId() {
        return mId;
    }

    public String getItemName() {
        return mItemName;
    }

    public void setItemName(String name) {
        mItemName = name;
    }

    public String getPrice() {
        return mItemRating;
    }

    public void setItemRating(String rating) {
        mItemRating = rating;
    }

}

