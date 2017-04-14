package com.makalaster.wastelandwares.data;

import java.util.Date;
import java.util.HashMap;

/**
 * A singleton class that stores a list of items and their quantities
 */

public class Cart {
    private HashMap<ItemId, Integer> mContents;
    private Date mCartCompletionDate;

    private static Cart sCart;

    private Cart() {
        mCartCompletionDate = new Date();
        mContents = new HashMap<>();
    }

    public static Cart getInstance() {
        if (sCart == null) {
            sCart = new Cart();
        }
        return sCart;
    }

    /**
     * Get all of the contents of the cart in a HashMap
     * @return mContents, the contents of the cart
     */
    public HashMap<ItemId, Integer> getContents() {
        return mContents;
    }

    /**
     * Clear out the cart
     */
    public void clearCart() {
        mContents.clear();
    }

    /**
     * Return all of the keys in the cart as a string
     * Will be used to store previous orders
     * @return a string of all of the keys in the cart map
     */
    public String getAllItems() {
        return mContents.keySet().toString();
    }

    /**
     * Return all of the values in the cart as a string
     * Will be used to store previous orders
     * @return a string of all of the values in the cart map
     */
    public String getAllQtys() {
        return mContents.entrySet().toString();
    }

    /**
     * Get the date the cart was completed
     * Will be used to store previous orders
     * @return the date the cart was completed
     */
    public Date getCartCompletionDate() {
        return mCartCompletionDate;
    }

    /**
     * Increment the quantity of the provided item
     * @param id the id of the item to be incremented
     */
    public void incrementItemCount(ItemId id) {
        mContents.put(id, mContents.get(id) + 1);
    }

    /**
     * Decrement the quantity of the provided item
     * @param id the id of the item to be decremented
     */
    public void decrementItemCount(ItemId id) {
        mContents.put(id, mContents.get(id) - 1);
    }

    /**
     * Add a new item to the cart
     * Increments the
     * @param id the id of the item to be added or incremented
     */
    public void addItemToCart(ItemId id) {
        if (mContents.containsKey(id)) {
            incrementItemCount(id);
        } else {
            mContents.put(id, 1);
        }
    }

    /**
     * Remove an item from the cart
     * @param id the id of the item to be removed
     */
    public void removeItemFromCart(ItemId id) {
        mContents.remove(id);
    }

    /**
     * Return the sum of all of the items in the cart
     * @return the sum of all of the items in the cart
     */
    public double getTotal() {
        WastelandWaresDatabase db = WastelandWaresDatabase.getInstance(null);
        int total = 0;

        for (ItemId key : mContents.keySet()) {
            int qty = mContents.get(key);
            switch (key.getItemType()) {
                case "Aid":
                    Aid aid = db.getAidById(key.getItemId());
                    total += aid.getPrice() * qty;
                    break;
                case "Armor":
                    Armor armor = db.getArmorById(key.getItemId());
                    total += armor.getPrice() * qty;
                    break;
                case "Weapon":
                    Weapon weapon = db.getWeaponById(key.getItemId());
                    total += weapon.getPrice() * qty;
                    break;
                default:
                    Item item = db.getItemById(key.getItemId());
                    total += item.getPrice() * qty;
            }
        }

        return total;
    }
}
