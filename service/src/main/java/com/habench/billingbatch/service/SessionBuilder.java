package com.habench.billingbatch.service;

import com.habench.billingbatch.service.PaymentEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class SessionBuilder {

    public static void resolve(String value) {
        Map<String, String> receiptKey301Attrs = new HashMap<String, String>();
        receiptKey301Attrs.put("channel", "web");
        receiptKey301Attrs.put("payload", value);
        String receiptKey301 = receiptKey301Attrs.get("payload");
        PaymentEvaluator.collect(receiptKey301);
    }
}
