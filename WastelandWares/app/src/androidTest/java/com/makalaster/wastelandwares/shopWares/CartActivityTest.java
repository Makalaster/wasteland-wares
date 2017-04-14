package com.makalaster.wastelandwares.shopWares;


import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;

import com.makalaster.wastelandwares.R;
import com.makalaster.wastelandwares.data.Cart;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.makalaster.wastelandwares.shopWares.EspressoHelpers.childAtPosition;
import static com.makalaster.wastelandwares.shopWares.EspressoHelpers.clickChildViewWithId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CartActivityTest {
    Cart mCart = Cart.getInstance();

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup() {
        mCart.clearCart();
    }

    @Test
    public void testAddItemToCart() {
        onView(allOf(withId(R.id.recycler), isDisplayed(), withParent(withId(R.id.pager))))
                .perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.fab))
                .perform(click());

        pressBack();

        onView(withId(R.id.fab))
                .perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.item_name), withText("Whiskey"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Whiskey")));
    }

    @Test
    public void testAddMultipleItemsToCart() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recycler),
                        withParent(withId(R.id.pager)),
                        isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        pressBack();

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recycler),
                        withParent(withId(R.id.pager)),
                        isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton2.perform(click());

        pressBack();

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.recycler),
                        withParent(withId(R.id.pager)),
                        isDisplayed()));
        recyclerView3.perform(actionOnItemAtPosition(2, click()));

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton3.perform(click());

        pressBack();

        ViewInteraction recyclerView4 = onView(
                allOf(withId(R.id.recycler),
                        withParent(withId(R.id.pager)),
                        isDisplayed()));
        recyclerView4.perform(actionOnItemAtPosition(3, click()));

        ViewInteraction floatingActionButton4 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton4.perform(click());

        pressBack();

        ViewInteraction floatingActionButton5 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton5.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.item_name), withText("Antivenom"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Antivenom")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.item_name), withText("Fire Ant Meat"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("Fire Ant Meat")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.item_name), withText("Whiskey"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("Whiskey")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.item_name), withText("Mole Rat Meat"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView4.check(matches(withText("Mole Rat Meat")));
    }

    @Test
    public void testAddItemToCartMultipleTimes() {
        onView(allOf(withId(R.id.recycler), isDisplayed(), withParent(withId(R.id.pager))))
                .perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.fab))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());

        pressBack();

        onView(withId(R.id.fab))
                .perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.item_quantity),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        textView.check(matches(withText("3")));
    }

    @Test
    public void testIncrementItemQuantity() throws InterruptedException {
        onView(allOf(withId(R.id.recycler), isDisplayed(), withParent(withId(R.id.pager))))
                .perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.fab))
                .perform(click());

        pressBack();

        onView(withId(R.id.fab))
                .perform(click());

        onView(allOf(withId(R.id.increment_button), isDisplayed()))
                .perform(click());
        Thread.sleep(200);
        onView(allOf(withId(R.id.increment_button), isDisplayed()))
                .perform(click());
        Thread.sleep(200);
        onView(allOf(withId(R.id.increment_button), isDisplayed()))
                .perform(click());
        Thread.sleep(200);
        onView(allOf(withId(R.id.increment_button), isDisplayed()))
                .perform(click());
        Thread.sleep(200);
        onView(allOf(withId(R.id.increment_button), isDisplayed()))
                .perform(click());
        Thread.sleep(200);

        ViewInteraction textView = onView(
                allOf(withId(R.id.item_quantity),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        textView.check(matches(withText("6")));

    }

    @Test
    public void testDecrementItemQuantity() throws InterruptedException {
        onView(allOf(withId(R.id.recycler), isDisplayed(), withParent(withId(R.id.pager))))
                .perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.fab))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());

        pressBack();

        onView(withId(R.id.fab))
                .perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.item_quantity),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        textView.check(matches(withText("6")));

        onView(allOf(withId(R.id.decrement_button), isDisplayed()))
                .perform(click());
        Thread.sleep(200);
        onView(allOf(withId(R.id.decrement_button), isDisplayed()))
                .perform(click());
        Thread.sleep(200);
        onView(allOf(withId(R.id.decrement_button), isDisplayed()))
                .perform(click());
        Thread.sleep(200);
        onView(allOf(withId(R.id.decrement_button), isDisplayed()))
                .perform(click());
        Thread.sleep(200);
        onView(allOf(withId(R.id.decrement_button), isDisplayed()))
                .perform(click());
        Thread.sleep(200);

        textView.check(matches(withText("1")));
    }

    @Test
    public void testRemoveFromCart() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recycler),
                        withParent(withId(R.id.pager)),
                        isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        pressBack();

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recycler),
                        withParent(withId(R.id.pager)),
                        isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton2.perform(click());

        pressBack();

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.recycler),
                        withParent(withId(R.id.pager)),
                        isDisplayed()));
        recyclerView3.perform(actionOnItemAtPosition(2, click()));

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton3.perform(click());

        pressBack();

        ViewInteraction floatingActionButton5 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton5.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.item_name), withText("Whiskey"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Whiskey")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.item_name), withText("Mole Rat Meat"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("Mole Rat Meat")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.item_name), withText("Fire Ant Meat"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("Fire Ant Meat")));

        onView(withId(R.id.cart_recycler))
                .check(new RecyclerViewItemCountAssertion(3));

        onView(withId(R.id.cart_recycler)).perform(
                RecyclerViewActions.actionOnItemAtPosition(1, clickChildViewWithId(R.id.decrement_button))
        );

        onView(withId(R.id.cart_recycler))
                .check(new RecyclerViewItemCountAssertion(2));
    }

    @Test
    public void testCheckoutWhenEmpty() {
        onView(withId(R.id.fab))
                .perform(click());

        onView(withId(R.id.fab))
                .perform(click());

        onView(withId(android.R.id.message))
                .check(matches(withText("Your cart is empty! Please add items before checking out.")));
    }

    @Test
    public void testCheckoutWithItems() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recycler),
                        withParent(withId(R.id.pager)),
                        isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        pressBack();

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recycler),
                        withParent(withId(R.id.pager)),
                        isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton2.perform(click());

        pressBack();

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.recycler),
                        withParent(withId(R.id.pager)),
                        isDisplayed()));
        recyclerView3.perform(actionOnItemAtPosition(2, click()));

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton3.perform(click());

        pressBack();

        onView(withId(R.id.fab))
                .perform(click());

        onView(withId(R.id.fab))
                .perform(click());

        onView(withId(android.R.id.message))
                .check(matches(withText("Are you sure you're ready to check out? Your total is 11.0")));

        onView(withId(android.R.id.button1))
                .perform(click());

        onView(withId(R.id.cart_recycler))
                .check(new RecyclerViewItemCountAssertion(0));
    }
}
