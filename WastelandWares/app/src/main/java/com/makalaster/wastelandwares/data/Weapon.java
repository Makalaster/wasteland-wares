package com.makalaster.wastelandwares.data;

/**
 * A weapon subclass of the Equipment class
 * Weapons inflict a certain amount of damage,
 * The have a maximum ammo capacity, a current ammo remaining,
 * and a specific type of ammo required
 * Firing a weapon lowers the current ammo remaining
 * Reloading the weapon refills the current ammo remaining to the capacity
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
