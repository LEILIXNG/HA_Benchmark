package com.habench.orderreopen.service;

import com.habench.orderreopen.service.ReceiptPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentService {
    private static String cachedLedger;

    public static void register(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        cachedLedger = receiptKey101;
        compose();
    }

    private static void compose() {
        String accountRef102 = cachedLedger;
        Map<String, String> voucherRef103Attrs = new HashMap<String, String>();
        voucherRef103Attrs.put("channel", "web");
        voucherRef103Attrs.put("payload", accountRef102);
        String voucherRef103 = voucherRef103Attrs.get("payload");
        ReceiptPolicySelector.expand(voucherRef103);
    }
}
