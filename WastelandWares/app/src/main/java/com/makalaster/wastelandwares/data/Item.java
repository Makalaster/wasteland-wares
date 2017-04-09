package com.makalaster.wastelandwares.data;

/**
 * Created by Makalaster on 4/9/17.
 */

public class Item {
    private String mName, mDescription;
    private double mPrice, mRating;
    private final long mId;
    private int mWeight;

    public Item(String name, String description, double price, double rating, long id, int weight) {
        mName = name;
        mDescription = description;
        mPrice = price;
        mRating = rating;
        mId = id;
        mWeight = weight;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public double getPrice() {
        return mPrice;
    }

    public double getRating() {
        return mRating;
    }

    public void setRating(double rating) {
        mRating = rating;
    }

    public long getId() {
        return mId;
    }

    public int getWeight() {
        return mWeight;
    }
}
