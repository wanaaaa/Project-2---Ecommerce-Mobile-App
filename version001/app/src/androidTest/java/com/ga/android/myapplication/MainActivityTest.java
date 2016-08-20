package com.ga.android.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by ubun17 on 8/19/16.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    public MainActivityTest() {}

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void inputData() throws Exception {
        onView(withId(R.id.shoppingListInput)).perform(click());

        onView(withId(R.id.editInputTitle))
                .perform(typeText("skirt One"))
                .check(matches(withText("skirt One")));

        onView(withId(R.id.editInputPrice))
                .perform(typeText("100"))
                .check(matches(withText("100")));
    }


}
