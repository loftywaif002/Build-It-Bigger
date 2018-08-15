package com.udacity.gradle.builditbigger;

import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EndspointsAsyncTaskTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void changeText_sameActivity() {
        onView(withId(R.id.button_show_joke))
                .perform(click());
        onView(withId(R.id.text_view_joke))
                .check(matches(not(withText(""))));
    }
}
