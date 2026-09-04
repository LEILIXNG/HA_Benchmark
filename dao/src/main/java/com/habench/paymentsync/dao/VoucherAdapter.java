package com.habench.paymentsync.dao;

import com.habench.paymentsync.dao.LedgerNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAdapter {

    public static void publish(String value) {
        Map<String, String> batchTag301Attrs = new HashMap<String, String>();
        batchTag301Attrs.put("channel", "web");
        batchTag301Attrs.put("payload", value);
        String batchTag301 = batchTag301Attrs.get("payload");
        LedgerNormalizer.register(batchTag301);
    }
}
