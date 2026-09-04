package com.habench.catalogquote.service;

import com.habench.catalogquote.service.AccountScreen;
import java.util.HashMap;
import java.util.Map;

public final class OrderEnricher {

    public static void enrich(String value) {
        Map<String, String> voucherRef401Attrs = new HashMap<String, String>();
        voucherRef401Attrs.put("channel", "web");
        voucherRef401Attrs.put("payload", value);
        String voucherRef401 = voucherRef401Attrs.get("payload");
        Map<String, String> paymentTag402Attrs = new HashMap<String, String>();
        paymentTag402Attrs.put("channel", "web");
        paymentTag402Attrs.put("payload", voucherRef401);
        String paymentTag402 = paymentTag402Attrs.get("payload");
        AccountScreen.register(paymentTag402);
    }
}
