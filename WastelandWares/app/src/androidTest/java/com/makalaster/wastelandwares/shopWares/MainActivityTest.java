package com.makalaster.wastelandwares.shopWares;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.makalaster.wastelandwares.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testViewPager() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.item_name), withText("Whiskey"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.click_target),
                                        0),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("Whiskey")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.item_name), withText("Whiskey"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.click_target),
                                        0),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("Whiskey")));

        ViewInteraction viewPager = onView(
                allOf(withId(R.id.pager), isDisplayed()));
        viewPager.perform(swipeLeft());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.item_name), withText("Goggles Helmet"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.click_target),
                                        0),
                                1),
                        isDisplayed()));
        textView3.check(matches(withText("Goggles Helmet")));

        ViewInteraction viewPager2 = onView(
                allOf(withId(R.id.pager), isDisplayed()));
        viewPager2.perform(swipeLeft());

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.item_name), withText("10mm Submachine Gun"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.click_target),
                                        0),
                                1),
                        isDisplayed()));
        textView4.check(matches(withText("10mm Submachine Gun")));

        ViewInteraction viewPager3 = onView(
                allOf(withId(R.id.pager), isDisplayed()));
        viewPager3.perform(swipeLeft());

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.item_name), withText("Whiskey"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.click_target),
                                        0),
                                1),
                        isDisplayed()));
        textView5.check(matches(withText("Whiskey")));

        ViewInteraction viewPager4 = onView(
                allOf(withId(R.id.pager), isDisplayed()));
        viewPager4.perform(swipeLeft());

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.item_name), withText("Metal Spoon"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.click_target),
                                        0),
                                1),
                        isDisplayed()));
        textView6.check(matches(withText("Metal Spoon")));

        ViewInteraction appCompatTextView = onView(
                allOf(withText("All"), isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction viewPager5 = onView(
                allOf(withId(R.id.pager), isDisplayed()));
        viewPager5.perform(swipeRight());

    }

    @Test
    public void testOpenItem() {
        onView(allOf(withId(R.id.recycler), withParent(withId(R.id.pager)), isDisplayed()))
                .perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.hp_label))
                .check(matches(isDisplayed()));

        pressBack();

        onView(allOf(withId(R.id.recycler), withParent(withId(R.id.pager)), isDisplayed()))
                .perform(actionOnItemAtPosition(1, click()));
        onView(withId(R.id.hp_value))
                .check(matches(withText("5")));
    }

    @Test
    public void testSearch() {
        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.search), withContentDescription("Search"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction searchAutoComplete = onView(
                allOf(withId(R.id.search_src_text),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        searchAutoComplete.perform(replaceText("boom"), closeSoftKeyboard());

        ViewInteraction searchAutoComplete2 = onView(
                allOf(withId(R.id.search_src_text), withText("boom"),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        searchAutoComplete2.perform(pressImeActionButton());

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.item_name), withText("Boomer Flightsuit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.click_target),
                                        0),
                                1),
                        isDisplayed()));
        textView8.check(matches(withText("Boomer Flightsuit")));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.item_name), withText("Boomers Helmet"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.click_target),
                                        0),
                                1),
                        isDisplayed()));
        textView9.check(matches(withText("Boomers Helmet")));

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Collapse"),
                        withParent(withId(R.id.toolbar)),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.item_name), withText("Whiskey"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.click_target),
                                        0),
                                1),
                        isDisplayed()));
        textView10.check(matches(withText("Whiskey")));
    }

    @Test
    public void testGoToCart() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.fab),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
