package com.noemi.android.payitforward;

import com.noemi.android.payitforward.api.model.PaymentLogo;
import com.noemi.android.payitforward.api.model.PaymentMethod;

import org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(RobolectricTestRunner.class)
@org.robolectric.annotation.Config(manifest = Config.NONE)
public class PaymentMethodUnitTest {

    private PaymentMethod method = new PaymentMethod("PAYPAL", "PayPal", "WALLET",
            new PaymentLogo("https://resources.integration.oscato.com/resource/network/MOBILETEAM/en_US/PAYPAL/logo3x.png"));


    @Test
    public void breedShouldPass() {
        PaymentMethod expected = new PaymentMethod("PAYPAL", "PayPal", "WALLET",
                new PaymentLogo("https://resources.integration.oscato.com/resource/network/MOBILETEAM/en_US/PAYPAL/logo3x.png"));
        assertEquals(expected, method);
    }

    @Test
    public void breedShouldFailed() {
        PaymentMethod expected = new PaymentMethod("VISA", "Visa", "WALLET",
                new PaymentLogo("https://resources.integration.oscato.com/resource/network/MOBILETEAM/en_US/PAYPAL/logo3x.png"));
        assertNotEquals(expected, method);
    }
}
