package com.habench.customerrefund.service;

import com.habench.customerrefund.service.LedgerCollector;
import java.util.HashMap;
import java.util.Map;

public final class TariffNormalizer {

    public static void resolve(String value) {
        String voucherRef301 = value;
        Map<String, String> paymentTag302Attrs = new HashMap<String, String>();
        paymentTag302Attrs.put("channel", "web");
        paymentTag302Attrs.put("payload", voucherRef301);
        String paymentTag302 = paymentTag302Attrs.get("payload");
        LedgerCollector.register(paymentTag302);
    }
}
