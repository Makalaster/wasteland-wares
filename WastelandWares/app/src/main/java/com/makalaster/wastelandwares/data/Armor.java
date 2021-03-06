package com.makalaster.wastelandwares.data;

/**
 * An armor item that extends the Equipment class
 * Armor items offer increased defense
 */

public class Armor extends Equipment {
    private int mDefense;

    public Armor(String name, String description, double price, double rating, long id, int weight, int condition, int defense) {
        super(name, description, price, rating, id, weight, condition);

        mDefense = defense;
    }

    public int getDefense() {
        return mDefense;
    }
}
