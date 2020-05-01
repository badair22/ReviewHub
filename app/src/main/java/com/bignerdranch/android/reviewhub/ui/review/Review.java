package com.bignerdranch.android.reviewhub.ui.review;

import java.util.Date;
import java.util.UUID;

public class Review {
    public String mName;
    public String mState;
    public String mCity;
    public String mSummary;
    public Long mRating;

    public Review(){}
    public Review(String name, Long rating/*, String state, String city, String summary*/) {
        this.mName = name;
        this.mRating = rating;
        /*this.mState = state;
        this.mCity = city;
        this.mSummary = summary;*/
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public Long getRating() {
        return mRating;
    }

    public void setRating(Long rating) {
        mRating = rating;
    }





}
