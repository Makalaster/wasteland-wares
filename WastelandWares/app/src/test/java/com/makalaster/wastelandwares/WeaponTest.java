package com.makalaster.wastelandwares;

import com.makalaster.wastelandwares.data.Weapon;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Makalaster on 4/13/17.
 */

public class WeaponTest {
    private Weapon mTestWeapon;

    @Before
    public void setup() {
        mTestWeapon = new Weapon("Test Weapon", "A weapon for testing", 14.0, 4.0, 123, 14, 100, 24, 20, 20, "MF Cell");
    }

    @Test
    public void testGetDamage() {
        int expectedDamage = 24;
        int actualDamage = mTestWeapon.getDamage();

        assertEquals(expectedDamage, actualDamage);
    }

    @Test
    public void testGetAmmoCapacity() {
        int expectedCapacity = 20;
        int actualCapacity = mTestWeapon.getAmmoCapacity();

        assertEquals(expectedCapacity, actualCapacity);
    }

    @Test
    public void testGetAmmoRemaining() {
        int expectedAmmoRemaining = 20;
        int actualAmmoRemaining = mTestWeapon.getAmmoRemaining();

        assertEquals(expectedAmmoRemaining, actualAmmoRemaining);
    }

    @Test
    public void testFire() {
        mTestWeapon.fire(5);

        int expectedAmmoRemaining = 15;
        int actualAmmoRemaining = mTestWeapon.getAmmoRemaining();

        assertEquals(expectedAmmoRemaining, actualAmmoRemaining);
    }

    @Test
    public void testReload() {
        mTestWeapon.fire(5);
        mTestWeapon.reload();

        int expectedAmmoRemaining = 20;
        int actualAmmoRemaining = mTestWeapon.getAmmoRemaining();

        assertEquals(expectedAmmoRemaining, actualAmmoRemaining);
    }

    @Test
    public void testGetAmmoRequired() {
        String expectedAmmoType = "MF Cell";
        String actualAmmoType = mTestWeapon.getAmmoRequired();

        assertEquals(expectedAmmoType, actualAmmoType);
    }


}
