package com.geektech.astudy.presentation.login;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.geektech.astudy.R;
import com.geektech.astudy.presentation.main.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by askar on 11/27/18
 * with Android Studio
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    private String nameToType = "Tameki";
    private String passwordToType = "123456789";

    private LoginFragment fragment;

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Exception {
        Intents.init();

        fragment = mActivityRule.getActivity().mView;
    }

    @Test
    public void checkInput(){
        onView(withId(R.id.fragment_login_name))
                .perform(typeText(nameToType));
        onView(withId(R.id.fragment_login_password))
                .perform(typeText(passwordToType), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.fragment_login_name)).check(matches(withText(nameToType)));

        onView(withId(R.id.fragment_login_btn)).perform(click());


        intended(hasComponent(MainActivity.class.getName()));
    }
}