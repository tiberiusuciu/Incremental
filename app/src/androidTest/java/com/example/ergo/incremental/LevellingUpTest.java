package com.example.ergo.incremental;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.ergo.incremental.controller.core_mechanics.Game;
import com.example.ergo.incremental.model.User;
import com.example.ergo.incremental.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LevellingUpTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void levellingUpTest() {
        User user = new User();
        for(int i = 0; i < Game.codeToMake; i++) {
            ViewInteraction appCompatButton = onView(
                    allOf(withId(R.id.button), withText("Work"),
                            withParent(withId(R.id.fragment)),
                            isDisplayed()));
            appCompatButton.perform(click());
        }

        onView(withId(R.id.lvl)).check(matches(withText("2")));
    }

}
