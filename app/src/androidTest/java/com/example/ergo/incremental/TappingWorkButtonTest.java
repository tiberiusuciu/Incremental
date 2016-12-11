package com.example.ergo.incremental;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;

import com.example.ergo.incremental.controller.MainActivity;
import com.example.ergo.incremental.controller.StatsFragment;

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
public class TappingWorkButtonTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void tappingWorkButtonTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.button), withText(R.string.cliker_button),
                        withParent(withId(R.id.fragment)),
                        isDisplayed()));
        appCompatButton.perform(click());

        // Étant donné que la partie est sauvegardé entre les tests, je fait un if pour savoir dans
        // quel cas de niveau nous sommes (au debut du jeu, ou un click avant la fin d'un niveau)
        // Comme ca, le tests est flexible est s'ajuste selon la situation

        if(StatsFragment.getCodeBar().getProgress() == 0) {
            onView(withId(R.id.codeText)).check(matches(withText(R.string.beggining_code)));
        } else {
            onView(withId(R.id.codeText)).check(matches(withText(MainActivity.getAppContext().getResources().getString(R.string.remaining_code) + " " + (StatsFragment.getCodeBar().getMax() - StatsFragment.getCodeBar().getProgress()))));
        }
    }

}
