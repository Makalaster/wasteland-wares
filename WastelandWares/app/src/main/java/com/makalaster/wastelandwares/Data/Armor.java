package com.makalaster.wastelandwares.Data;

/**
 * Created by Makalaster on 4/9/17.
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
