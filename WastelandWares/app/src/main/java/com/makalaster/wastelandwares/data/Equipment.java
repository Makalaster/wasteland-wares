package com.makalaster.wastelandwares.data;

/**
 * Created by Makalaster on 4/9/17.
 */

public class Equipment extends Item {
    private int mCondition;

    public Equipment(String name, String description, double price, double rating, long id, int weight, int condition) {
        super(name, description, price, rating, id, weight);

        mCondition = condition;
    }

    public int getCondition() {
        return mCondition;
    }

    public void setCondition(int condition) {
        mCondition = condition;
    }

    public void repair(int repairByPoints) {
        mCondition += repairByPoints;
    }

    public void damage(int damageByPoints) {
        mCondition -= damageByPoints;
    }
}
