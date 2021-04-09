package com.zmarkan.nestedscroll.matcher;

import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static androidx.test.internal.util.Checks.checkNotNull;


public class ClassOrInterfaceMatcher {
    /**
     * Returns a matcher that matches Views which are an instance of or subclass of the provided
     * class, or implement the specified interface.
     */
    public static Matcher<View> isAssignableFromClassOrInterface(final Class clazz) {
        checkNotNull(clazz);
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("is assignable from class: " + clazz);
            }

            @Override
            public boolean matchesSafely(View view) {
                //noinspection unchecked
                return clazz.isAssignableFrom(view.getClass());
            }
        };
    }
}
