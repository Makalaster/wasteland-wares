package com.makalaster.wastelandwares;

import com.makalaster.wastelandwares.data.Armor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Makalaster on 4/13/17.
 */

public class ArmorTest {
    private Armor mTestArmor;

    @Before
    public void setup() {
        mTestArmor = new Armor("Test Armor", "An armor made for testing", 100.0, 3.0, 123, 100, 100, 50);
    }

    @Test
    public void testGetDefense() {
        int expectedDefense = 50;
        int actualDefense = mTestArmor.getDefense();

        assertEquals(expectedDefense, actualDefense);
    }

}
