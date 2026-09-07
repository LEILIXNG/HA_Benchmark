package com.habench.inventoryadjust.service;

import com.habench.inventoryadjust.dao.LedgerCollector;
import java.util.HashMap;
import java.util.Map;

public final class SessionEnricher {
    private static String cachedVoucher;

    public static void enrich(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        cachedVoucher = receiptKey101;
        forward();
    }

    private static void forward() {
        String accountRef102 = cachedVoucher;
        String voucherRef103 = accountRef102;
        cachedVoucher = voucherRef103;
        register();
    }

    private static void register() {
        String paymentTag104 = cachedVoucher;
        String refundCode105 = paymentTag104;
        LedgerCollector.compose(refundCode105);
    }
}
