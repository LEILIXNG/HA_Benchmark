package com.habench.reportreview.web;

import com.habench.reportreview.service.LedgerCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class SessionRegistry {

    public static void translate(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("payload", value);
        String voucherRef201 = voucherRef201Attrs.get("payload");
        Map<String, String> paymentTag202Attrs = new HashMap<String, String>();
        paymentTag202Attrs.put("channel", "web");
        paymentTag202Attrs.put("payload", voucherRef201);
        String paymentTag202 = paymentTag202Attrs.get("payload");
        LedgerCoordinator.translate(paymentTag202);
    }
}
