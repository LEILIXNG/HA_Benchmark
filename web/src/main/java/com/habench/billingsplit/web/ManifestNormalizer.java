package com.habench.billingsplit.web;

import com.habench.billingsplit.service.OrderService;
import java.util.HashMap;
import java.util.Map;

public final class ManifestNormalizer {
    private static String cachedChannel;

    public static void attach(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        String accountRef102 = "ref:" + receiptKey101 + ";";
        cachedChannel = accountRef102;
        assemble();
    }

    private static void assemble() {
        String voucherRef103 = cachedChannel;
        String paymentTag104 = "ref:" + voucherRef103 + ";";
        OrderService.publish(paymentTag104);
    }
}
