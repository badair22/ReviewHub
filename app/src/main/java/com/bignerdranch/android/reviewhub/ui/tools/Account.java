package com.bignerdranch.android.reviewhub.ui.tools;

import java.util.UUID;

public class Account {
    public UUID mId;
    public String mFirst;
    public String mLast;
    public String mEmail;
    public String mUsername;

    public UUID getId() {
        return mId;
    }

    public String getFirst() {
        return mFirst;
    }

    public void setFirst(String first) {
        mFirst = first;
    }

    public String getLast() {
        return mLast;
    }

    public void setLast(String last) {
        mLast = last;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }
}
