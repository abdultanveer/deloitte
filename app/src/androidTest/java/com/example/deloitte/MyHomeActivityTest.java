package com.example.deloitte;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class MyHomeActivityTest {

    @Rule
    public ActivityScenarioRule<HomeActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(HomeActivity.class);

    @Test
    public void loginTest() {
        //enter abdul ansari in the etHome
        onView(withId(R.id.etHome))
                .perform(typeText("abdul ansari"), closeSoftKeyboard());
        //click the button btnHome
        onView(withId(R.id.btnHome)).perform(click());
        //check if the tvHome has abdul ansari in it
        onView(withId(R.id.tvHome))
                .check(matches(withText("abdul ansari")));
    }
}
