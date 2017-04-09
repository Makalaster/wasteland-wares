package com.makalaster.wastelandwares.data;

/**
 * Created by Makalaster on 4/9/17.
 */

public class Food extends Item {
    private int mHp, mRads;


    public Food(String name, String description, double price, double rating, long id, int weight, int hp, int rads) {
        super(name, description, price, rating, id, weight);

        mHp = hp;
        mRads = rads;
    }

    public int getHp() {
        return mHp;
    }

    public int getRads() {
        return mRads;
    }
}
