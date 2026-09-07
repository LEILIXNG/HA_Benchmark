package com.habench.pricingadjust.service;

import com.habench.pricingadjust.dao.OrderNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptRouter {
    private static String cachedSession;

    public static void prepare(String value) {
        Map<String, String> receiptKey401Attrs = new HashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("payload", value);
        String receiptKey401 = receiptKey401Attrs.get("payload");
        cachedSession = receiptKey401;
        compose();
    }

    private static void compose() {
        String accountRef402 = cachedSession;
        String voucherRef403 = accountRef402;
        Map<String, String> paymentTag404Attrs = new HashMap<String, String>();
        paymentTag404Attrs.put("channel", "web");
        paymentTag404Attrs.put("payload", voucherRef403);
        String paymentTag404 = paymentTag404Attrs.get("payload");
        OrderNormalizer.enrich(paymentTag404);
    }
}
