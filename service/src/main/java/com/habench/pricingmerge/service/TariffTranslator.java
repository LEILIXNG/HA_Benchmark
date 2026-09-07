package com.habench.pricingmerge.service;

import com.habench.pricingmerge.service.PaymentLoader;
import java.util.HashMap;
import java.util.Map;

public final class TariffTranslator {

    public static void submit(String value) {
        Map<String, String> receiptKey401Attrs = new HashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("payload", value);
        String receiptKey401 = receiptKey401Attrs.get("payload");
        PaymentLoader.collect(receiptKey401);
    }
}
