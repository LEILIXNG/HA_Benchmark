package com.habench.accountreconcile.service;

import com.habench.accountreconcile.service.BundleStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderTranslator {

    public static void collect(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        Map<String, String> paymentTag102Attrs = new HashMap<String, String>();
        paymentTag102Attrs.put("channel", "web");
        paymentTag102Attrs.put("payload", voucherRef101);
        String paymentTag102 = paymentTag102Attrs.get("payload");
        BundleStrategySelector.translate(paymentTag102);
    }
}
