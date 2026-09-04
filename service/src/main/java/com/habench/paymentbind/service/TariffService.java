package com.habench.paymentbind.service;

import com.habench.paymentbind.service.RefundPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffService {
    private static String cachedManifest;

    public static void reconcile(String value) {
        String catalogKey101 = "ref:" + value + ";";
        Map<String, String> receiptKey102Attrs = new HashMap<String, String>();
        receiptKey102Attrs.put("channel", "web");
        receiptKey102Attrs.put("payload", catalogKey101);
        String receiptKey102 = receiptKey102Attrs.get("payload");
        cachedManifest = receiptKey102;
        assemble();
    }

    private static void assemble() {
        String accountRef103 = cachedManifest;
        String voucherRef104 = "ref:" + accountRef103 + ";";
        RefundPolicySelector.submit(voucherRef104);
    }
}
