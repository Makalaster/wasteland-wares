package com.makalaster.wastelandwares.data;

/**
 * Created by Makalaster on 4/12/17.
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
