package com.example.greenhouseappnew;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.app.Activity;
import android.content.Context;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.recyclerview.widget.RecyclerView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.greenhouseappnew.activities.MainActivity;

@RunWith(AndroidJUnit4.class)
public class GreenhouseListTest {

    private MainActivity mMainActivity;
    private RecyclerView mRecyclerView;
    private int resID = R.id.greenhousesRecyclerView;
    private int itemCount = 0;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setupTest() {

        this.mMainActivity = this.activityTestRule.getActivity();
        this.mRecyclerView = this.mMainActivity.findViewById(this.resID);
        this.itemCount = this.mRecyclerView.getAdapter().getItemCount();

    }

    @Test
    public void RecyclerViewTest() {

        if(this.itemCount > 0) {

            for(int i=0; i < this.itemCount; i++) {

                // Clicking the item
                onView(withId(this.resID))
                        .perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));

                // Check if the ViewHolder is being displayed
                onView(new RecyclerViewMatcher(this.resID)
                        .atPositionOnView(i, R.id.greenhouseCardView))
                        .check(matches(isDisplayed()));

                // Checking for the text of the first one item
                if(i == 0) {

                    onView(new RecyclerViewMatcher(this.resID)
                            .atPositionOnView(i, R.id.tv_greenhouse_name))
                            .check(matches(withText("Greenhouse1")));

                }

            }

        }

    }

}