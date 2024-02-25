package com.netology.tabbedapplication;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest_Homework {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest_Homework() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html

        String Page1 = "1";
        String Page2 = "2";

        ViewInteraction tabView = onView(
                allOf(withContentDescription("Tab 1"),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.section_label),
                        isDisplayed()));
        textView.check(matches(withText("Page: " + Page1)));

        ViewInteraction tabView2 = onView(
                allOf(withContentDescription("Tab 2"),
                        isDisplayed()));
        tabView2.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.section_label),
                        isDisplayed()));
        textView2.check(matches(withText("Page: " + Page2)));
    }

}
