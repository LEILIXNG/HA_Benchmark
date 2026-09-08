package com.habench.catalogdispatch.web;

import com.habench.catalogdispatch.service.LedgerNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAdapter {

    public static void publish(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        String ledgerEntry2 = tariffRef1;
        LedgerNormalizer.register(ledgerEntry2);
    }
}
