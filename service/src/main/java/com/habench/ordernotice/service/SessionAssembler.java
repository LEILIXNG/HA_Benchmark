package com.habench.ordernotice.service;

import com.habench.ordernotice.dao.LedgerBroker;
import java.util.HashMap;
import java.util.Map;

public final class SessionAssembler {
    private static String cachedReceipt;

    public static void reconcile(String value) {
        String channelTag101 = "ref:" + value + ";";
        String catalogKey102 = channelTag101;
        cachedReceipt = catalogKey102;
        resolve();
    }

    private static void resolve() {
        String receiptKey103 = cachedReceipt;
        String accountRef104 = "ref:" + receiptKey103 + ";";
        Map<String, String> voucherRef105Attrs = new HashMap<String, String>();
        voucherRef105Attrs.put("channel", "web");
        voucherRef105Attrs.put("payload", accountRef104);
        String voucherRef105 = voucherRef105Attrs.get("payload");
        LedgerBroker.forward(voucherRef105);
    }
}
