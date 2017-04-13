package com.makalaster.wastelandwares;

import com.makalaster.wastelandwares.data.Item;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Makalaster on 4/13/17.
 */

public class ItemTest {
    private Item mTestItem;
    private static final double DELTA = 0.0000001;

    @Before
    public void setup() {
        mTestItem = new Item("Test Item", "An item created for testing", 1.0, 3.0, 123, 10);
    }

    @Test
    public void testGetName() {
        String expectedName = "Test Item";
        String actualName = mTestItem.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetDescription() {
        String expectedDescription = "An item created for testing";
        String actualDescription = mTestItem.getDescription();

        assertEquals(expectedDescription, actualDescription);
    }

    @Test
    public void testGetPrice() {
        double expectedPrice = 1.0;
        double actualPrice = mTestItem.getPrice();

        assertEquals(expectedPrice, actualPrice, DELTA);
    }

    @Test
    public void testGetRating() {
        double expectedRating = 3.0;
        double actualRating = mTestItem.getRating();

        assertEquals(expectedRating, actualRating, DELTA);
    }

    @Test
    public void testSetRating() {
        mTestItem.setRating(4.0);
        double expectedNewRating = 4.0;
        double actualNewRating = mTestItem.getRating();

        assertEquals(expectedNewRating, actualNewRating, DELTA);
    }

    @Test
    public void testGetId() {
        long expectedId = 123;
        long actualId = mTestItem.getId();

        assertEquals(expectedId, actualId);
    }

    @Test
    public void testGetWeight() {
        int expectedWeight = 10;
        int actualWeight = mTestItem.getWeight();

        assertEquals(expectedWeight, actualWeight);
    }
}
