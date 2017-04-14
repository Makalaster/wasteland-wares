package com.makalaster.wastelandwares.data;

/**
 * The Equipment class is a subclass of an Item
 * Equipment has a Condition attribute
 * If the Condition falls to 0, the item breaks
 * Equipment items can be damaged or repaired
 *
 * This functionality is not currently used
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
