package com.habench.customerverify.service;

import com.habench.customerverify.service.ShipmentPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentComposer {

    public static void refine(String value) {
        String voucherRef201 = value;
        Map<String, String> paymentTag202Attrs = new HashMap<String, String>();
        paymentTag202Attrs.put("channel", "web");
        paymentTag202Attrs.put("payload", voucherRef201);
        String paymentTag202 = paymentTag202Attrs.get("payload");
        ShipmentPolicySelector.compose(paymentTag202);
    }
}
