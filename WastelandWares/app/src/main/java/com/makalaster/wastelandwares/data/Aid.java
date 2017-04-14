package com.makalaster.wastelandwares.data;

/**
 * An Aid item that extends the Item class
 * Aid items restore HP and may inflict radiation damage
 */

public class Aid extends Item {
    private int mHp, mRads;


    public Aid(String name, String description, double price, double rating, long id, int weight, int hp, int rads) {
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
