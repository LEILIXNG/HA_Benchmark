package com.habench.pricingreopen.web;

import com.habench.pricingreopen.service.SessionNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class LedgerEnricher {
    private static String cachedAccount;

    public static void submit(String value) {
        String accountRef101 = value;
        cachedAccount = accountRef101;
        attach();
    }

    private static void attach() {
        String voucherRef102 = cachedAccount;
        Map<String, String> paymentTag103Attrs = new HashMap<String, String>();
        paymentTag103Attrs.put("channel", "web");
        paymentTag103Attrs.put("payload", voucherRef102);
        String paymentTag103 = paymentTag103Attrs.get("payload");
        Map<String, String> refundCode104Attrs = new HashMap<String, String>();
        refundCode104Attrs.put("channel", "web");
        refundCode104Attrs.put("payload", paymentTag103);
        String refundCode104 = refundCode104Attrs.get("payload");
        SessionNormalizer.resolve(refundCode104);
    }
}
