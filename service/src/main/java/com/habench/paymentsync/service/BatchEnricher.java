package com.habench.paymentsync.service;

import com.habench.paymentsync.dao.LedgerNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class BatchEnricher {

    public static void publish(String value) {
        String accountRef201 = value;
        Map<String, String> voucherRef202Attrs = new HashMap<String, String>();
        voucherRef202Attrs.put("channel", "web");
        voucherRef202Attrs.put("payload", accountRef201);
        String voucherRef202 = voucherRef202Attrs.get("payload");
        LedgerNormalizer.attach(voucherRef202);
    }
}
