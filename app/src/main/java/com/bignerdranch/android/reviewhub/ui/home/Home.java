package com.bignerdranch.android.reviewhub.ui.home;

import android.content.Context;

import com.bignerdranch.android.reviewhub.Restaurants;
import com.bignerdranch.android.reviewhub.ui.details.Details;

import java.util.ArrayList;
import java.util.List;

public class Home {
    private static Home sHome;
    private List<Details> mDetails;

    public static Home get(Context context) {
        if (sHome == null) {
            sHome = new Home(context);
        }
        return sHome;
    }

    private Home(Context context) {
        mDetails = new ArrayList<>();
        Details details = new Details();
        details.setItemName("Olive Garden");
        details.setItemRating("5");
        mDetails.add(details);
    }

    public List<Details> getDetails() {
        return mDetails;
    }
}
