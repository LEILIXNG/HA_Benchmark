package com.habench.orderverify.service;

import com.habench.orderverify.service.CatalogScreen;
import java.util.HashMap;
import java.util.Map;

public final class AccountBuilder {

    public static void register(String value) {
        String voucherRef101 = "ref:" + value + ";";
        Map<String, String> paymentTag102Attrs = new HashMap<String, String>();
        paymentTag102Attrs.put("channel", "web");
        paymentTag102Attrs.put("payload", voucherRef101);
        String paymentTag102 = paymentTag102Attrs.get("payload");
        CatalogScreen.submit(paymentTag102);
    }
}
