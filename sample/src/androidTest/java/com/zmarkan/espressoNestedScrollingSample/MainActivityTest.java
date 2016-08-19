package com.zmarkan.espressoNestedScrollingSample;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.zmarkan.nestedscroll.ScrollableUtils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.zmarkan.nestedscroll.ScrollableUtils.scrollableScrollTo;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void verifyFirstItemWithoutScrolling(){

        onView(withId(R.id.text1)).check(matches(isDisplayed()));
    }

    //Failing test to illustrate the example.
    @Test
    public void verifyItemsWithScrolling(){
        onView(withId(R.id.text3)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.text4)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.text5)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.text6)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.text7)).perform(scrollTo()).check(matches(isDisplayed()));
    }

    @Test
    public void verifyItemsWithNestedScrolling(){
        onView(withId(R.id.text3)).perform(scrollableScrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.text4)).perform(scrollableScrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.text5)).perform(scrollableScrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.text6)).perform(scrollableScrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.text7)).perform(scrollableScrollTo()).check(matches(isDisplayed()));
    }

}
