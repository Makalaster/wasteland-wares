package com.makalaster.wastelandwares;

import com.makalaster.wastelandwares.data.ItemId;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Makalaster on 4/13/17.
 */

public class ItemIdTest {
    private ItemId mTestItemId;

    @Before
    public void setup() {
        mTestItemId = new ItemId(123, "Test type");
    }

    @Test
    public void testGetItemId() {
        long expectedItemId = 123;
        long actualItemId = mTestItemId.getItemId();

        assertEquals(expectedItemId, actualItemId);
    }

    @Test
    public void testGetItemType() {
        String expectedType = "Test type";
        String actualType = mTestItemId.getItemType();

        assertEquals(expectedType, actualType);
    }

}
