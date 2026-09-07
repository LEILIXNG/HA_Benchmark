package com.habench.vendorrenewal.service;

import com.habench.vendorrenewal.service.TariffPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundCollector {

    public static void merge(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        Map<String, String> invoiceKey202Attrs = new HashMap<String, String>();
        invoiceKey202Attrs.put("channel", "web");
        invoiceKey202Attrs.put("payload", manifestKey201);
        String invoiceKey202 = invoiceKey202Attrs.get("payload");
        TariffPolicySelector.resolve(invoiceKey202);
    }
}
