package com.makalaster.wastelandwares.data;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by Makalaster on 4/9/17.
 */

public class Cart {
    private HashMap<ItemId, Integer> mContents;
    private Date mCartCompletionDate;
    private int mTotal;

    private static Cart sCart;

    public Cart() {
        mCartCompletionDate = new Date();
        mTotal = 0;
        mContents = new HashMap<>();
    }

    public static Cart getInstance() {
        if (sCart == null) {
            sCart = new Cart();
        }
        return sCart;
    }

    public HashMap<ItemId, Integer> getContents() {
        return mContents;
    }

    public void clearCart() {
        mContents.clear();
    }

    public String getAllItems() {
        return mContents.keySet().toString();
    }

    public String getAllQtys() {
        return mContents.entrySet().toString();
    }

    public Date getCartCompletionDate() {
        return mCartCompletionDate;
    }

    public void incrementItemCount(ItemId id) {
        mContents.put(id, mContents.get(id) + 1);
    }

    public void decrementItemCount(ItemId id) {
        mContents.put(id, mContents.get(id) - 1);
    }

    public void addItemToCart(ItemId id) {
        if (mContents.containsKey(id)) {
            mContents.put(id, mContents.get(id) + 1);
        } else {
            mContents.put(id, 1);
        }
    }

    public void removeItemFromCart(ItemId id) {
        mContents.remove(id);
    }

    public double getTotal() {
        int total = 0;

        for (ItemId key : mContents.keySet()) {
            total += mContents.get(key);
        }

        return total;
    }
}
