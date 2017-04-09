package com.makalaster.wastelandwares.data;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by Makalaster on 4/9/17.
 */

public class Cart {
    private HashMap<Long, Integer> mContents;
    private Date mCartCompletionDate;
    private double mTotal;

    public Cart(Date cartCompletionDate, double total) {
        mCartCompletionDate = cartCompletionDate;
        mTotal = total;
        mContents = new HashMap<>();
    }

    public HashMap<Long, Integer> getContents() {
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

    public double getTotal() {
        return mTotal;
    }
}
