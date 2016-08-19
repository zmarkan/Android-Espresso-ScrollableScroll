package com.zmarkan.nestedscroll;

import android.support.test.espresso.ViewAction;
import com.zmarkan.nestedscroll.action.ScrollableScrollToAction;
import static android.support.test.espresso.action.ViewActions.actionWithAssertions;

public class ScrollableUtils {

    public static ViewAction scrollableScrollTo() {
        return actionWithAssertions(new ScrollableScrollToAction());
    }
}
