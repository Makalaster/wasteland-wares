package com.makalaster.wastelandwares;

import com.makalaster.wastelandwares.data.Aid;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Makalaster on 4/13/17.
 */

public class AidTest {
    private Aid mTestAid;

    @Before
    public void setup() {
        mTestAid = new Aid("Test Aid", "Aid made for testing", 5.0, 4.0, 123, 1, 5, 1);
    }

    @Test
    public void testGetHp() {
        int expectedHp = 5;
        int actualHp = mTestAid.getHp();

        assertEquals(expectedHp, actualHp);
    }

    @Test
    public void testGetRads() {
        int expectedRads = 1;
        int actualRads = mTestAid.getRads();

        assertEquals(expectedRads, actualRads);
    }
}
