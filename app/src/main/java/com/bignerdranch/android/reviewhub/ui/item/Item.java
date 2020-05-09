package com.bignerdranch.android.reviewhub.ui.item;

import java.util.UUID;

public class Item {
    public String mItemName;
    public String mItemType;
    public Long mPrice;
    public String mSummary;
    public Long mRating;

    public Item(){}
    public Item(String itemName, String itemType, Long price, /*String summary,*/ Long rating) {
        this.mItemName = itemName;
        this.mItemType = itemType;
        this.mRating = rating;
        this.mPrice = price;
        //this.mSummary = summary;
    }


    public String getItemName() {
        return mItemName;
    }

    public void setItemName(String name) {
        mItemName = name;
    }

    public Long getPrice() {
        return mPrice;
    }

    public void setPrice(Long price) {
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

    public Long getRating() {
        return mRating;
    }

    public void setRating(Long rating) {
        mRating = rating;
    }
}
