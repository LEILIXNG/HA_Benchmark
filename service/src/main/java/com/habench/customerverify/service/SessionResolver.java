package com.habench.customerverify.service;

import com.habench.customerverify.service.PaymentComposer;
import java.util.HashMap;
import java.util.Map;

public final class SessionResolver {

    public static void forward(String value) {
        String voucherRef201 = value;
        Map<String, String> paymentTag202Attrs = new HashMap<String, String>();
        paymentTag202Attrs.put("channel", "web");
        paymentTag202Attrs.put("payload", voucherRef201);
        String paymentTag202 = paymentTag202Attrs.get("payload");
        PaymentComposer.refine(paymentTag202);
    }
}
