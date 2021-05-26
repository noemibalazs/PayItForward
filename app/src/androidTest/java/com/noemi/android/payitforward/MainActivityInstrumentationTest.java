package com.noemi.android.payitforward;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;

import com.noemi.android.payitforward.adapter.PaymentAdapter;
import com.noemi.android.payitforward.adapter.PaymentVH;
import com.noemi.android.payitforward.api.model.PaymentLogo;
import com.noemi.android.payitforward.api.model.PaymentMethod;
import com.noemi.android.payitforward.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static java.util.regex.Pattern.matches;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityInstrumentationTest {

    @Rule
    public ActivityScenarioRule<MainActivity> rule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testAppContext() {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        assertEquals("com.noemi.android.payitforward.test", context.getPackageName());
    }

    @Test
    public void testBusinessLogic() {

        PaymentAdapter adapter = new PaymentAdapter();
        adapter.submitList(getPaymentLst());

        rule.getScenario().onActivity(
                new ActivityScenario.ActivityAction<MainActivity>() {
                    @Override
                    public void perform(MainActivity activity) {
                        RecyclerView recyclerView = activity.findViewById(R.id.rvPayments);
                        recyclerView.setAdapter(adapter);
                    }
                }
        );

        onView(withId(R.id.rvPayments))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }


    private List<PaymentMethod> getPaymentLst() {
        List<PaymentMethod> list = new ArrayList<>();
        list.add(new PaymentMethod("PAYPAL", "PayPal", "WALLET",
                new PaymentLogo("https://resources.integration.oscato.com/resource/network/MOBILETEAM/en_US/PAYPAL/logo3x.png")));
        list.add(new PaymentMethod("MAESTRO", "Maestro", "DEBIT_CARD",
                new PaymentLogo("https://resources.integration.oscato.com/resource/network/MOBILETEAM/en_US/MAESTRO/logo3x.png")));
        list.add(new PaymentMethod("DISCOVER", "Discover", "CREDIT_CAR",
                new PaymentLogo("https://resources.integration.oscato.com/resource/network/MOBILETEAM/en_US/DISCOVER/logo3x.png")));
        return list;
    }
}

