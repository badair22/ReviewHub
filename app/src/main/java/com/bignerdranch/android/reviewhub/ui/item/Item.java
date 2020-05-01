package com.bignerdranch.android.reviewhub.ui.item;

import java.util.UUID;

public class Item {
    public String mItemName;
    public String mItemType;
    public String mPrice;
    public String mSummary;
    public String mRating;

    public Item(String name, String type, String price, String summary, String rating) {
        this.mItemName = name;
        this.mRating = rating;
        this.mItemType = type;
        this.mPrice = price;
        this.mSummary = summary;
    }


    public String getItemName() {
        return mItemName;
    }

    public void setItemName(String name) {
        mItemName = name;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public String getItemType() {
        return mItemType;
    }

    public void setItemType(String type) {
        mItemType = type;
    }

    public String getRating() {
        return mRating;
    }

    public void setRating(String rating) {
        mRating = rating;
    }
}
