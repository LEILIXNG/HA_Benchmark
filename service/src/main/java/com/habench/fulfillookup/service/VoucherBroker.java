package com.habench.fulfillookup.service;

import com.habench.fulfillookup.service.PaymentExecutor;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBroker {

    public static void attach(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        PaymentExecutor.assemble(paymentTag201);
    }
}
