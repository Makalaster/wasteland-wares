package com.makalaster.wastelandwares.Data;

/**
 * Created by Makalaster on 4/9/17.
 */

public class Weapon extends Equipment {
    private int mDamage, mAmmoCapacity, mAmmoRemaining;
    private String mAmmoRequired;

    public Weapon(String name, String description, double price, double rating, long id, int weight, int condition,
                  int damage, int ammoCapacity, int ammoRemaining, String ammoRequired) {
        super(name, description, price, rating, id, weight, condition);

        mDamage = damage;
        mAmmoCapacity = ammoCapacity;
        mAmmoRemaining = ammoRemaining;
        mAmmoRequired = ammoRequired;
    }

    public int getDamage() {
        return mDamage;
    }

    public int getAmmoCapacity() {
        return mAmmoCapacity;
    }

    public int getAmmoRemaining() {
        return mAmmoRemaining;
    }

    public void fire(int shots) {
        mAmmoRemaining -= shots;
    }

    public void reload() {
        mAmmoRemaining = mAmmoCapacity;
    }

    public String getAmmoRequired() {
        return mAmmoRequired;
    }
}
