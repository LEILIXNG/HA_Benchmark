package com.habench.paymentsplit.service;

import com.habench.paymentsplit.service.LedgerCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAdapter {

    public static void prepare(String value) {
        Map<String, String> paymentTag401Attrs = new HashMap<String, String>();
        paymentTag401Attrs.put("channel", "web");
        paymentTag401Attrs.put("payload", value);
        String paymentTag401 = paymentTag401Attrs.get("payload");
        LedgerCoordinator.publish(paymentTag401);
    }
}
