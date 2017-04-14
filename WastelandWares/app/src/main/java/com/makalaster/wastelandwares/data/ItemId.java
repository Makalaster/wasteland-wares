package com.makalaster.wastelandwares.data;

/**
 * A custom data type used to simplify the Cart HashMap
 * This type consists of a long and a String, which represent an item's ID and class type
 * The equals and hashcode methods needed to be overridden in order for the HashMap to be able to
 * judge item equality
 */

public class ItemId {
    private long mItemId;
    private String mItemType;

    public ItemId(long id, String type) {
        mItemId = id;
        mItemType = type;
    }

    public long getItemId() {
        return mItemId;
    }

    public String getItemType() {
        return mItemType;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof ItemId && ((ItemId) obj).getItemId() == this.getItemId() && ((ItemId) obj).getItemType().equals(this.getItemType()));
    }

    @Override
    public int hashCode() {
        return (mItemId + mItemType).hashCode();
    }
}
