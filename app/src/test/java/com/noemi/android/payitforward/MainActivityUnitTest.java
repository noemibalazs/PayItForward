package com.noemi.android.payitforward;

import android.content.Context;

import com.noemi.android.payitforward.ui.MainActivity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@org.robolectric.annotation.Config(manifest = Config.NONE)
public class MainActivityUnitTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() {
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().resume().get();
    }

    @Test
    public void testMainContext() {
        Context context = RuntimeEnvironment.systemContext;
        Assert.assertEquals("android", context.getPackageName());
    }

    @After
    public void tearDown() {
        mainActivity = null;
    }
}
