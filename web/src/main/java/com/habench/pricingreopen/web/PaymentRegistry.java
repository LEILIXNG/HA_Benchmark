package com.habench.pricingreopen.web;

import com.habench.pricingreopen.web.LedgerEnricher;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRegistry {

    public static void forward(String value) {
        String manifestKey1 = "ref:" + value + ";";
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        LedgerEnricher.submit(invoiceKey2);
    }
}
