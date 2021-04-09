package com.zmarkan.nestedscroll;

import androidx.test.espresso.ViewAction;
import com.zmarkan.nestedscroll.action.ScrollableScrollToAction;
import static androidx.test.espresso.action.ViewActions.actionWithAssertions;

public class ScrollableUtils {

    public static ViewAction scrollableScrollTo() {
        return actionWithAssertions(new ScrollableScrollToAction());
    }
}
