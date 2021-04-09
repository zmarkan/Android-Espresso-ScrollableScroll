package com.zmarkan.espressoNestedScrollingSample;

import androidx.test.espresso.PerformException;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.zmarkan.nestedscroll.ScrollableUtils.scrollableScrollTo;
import static junit.framework.TestCase.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
//    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp(){
        rule.getScenario();
    }

    @Test
    public void verifyFirstItemWithoutScrolling(){
        onView(withId(R.id.text1)).check(matches(isDisplayed()));
    }

    //Failing test to illustrate the example.
    @Test
    public void verifyItemsWithScrolling_FailsThrowingPerformException(){
        PerformException expectedException = null;
        try{
            onView(withId(R.id.text3)).perform(scrollTo()).check(matches(isDisplayed()));
            onView(withId(R.id.text4)).perform(scrollTo()).check(matches(isDisplayed()));
            onView(withId(R.id.text5)).perform(scrollTo()).check(matches(isDisplayed()));
            onView(withId(R.id.text6)).perform(scrollTo()).check(matches(isDisplayed()));
            onView(withId(R.id.text7)).perform(scrollTo()).check(matches(isDisplayed()));

        }
        catch (PerformException e){
            expectedException = e;
        }
        finally {
            assertNotNull(expectedException);
        }
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
