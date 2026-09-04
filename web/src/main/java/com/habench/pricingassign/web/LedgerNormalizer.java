package com.habench.pricingassign.web;

import com.habench.pricingassign.service.ContractNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class LedgerNormalizer {

    public static void reconcile(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        ContractNormalizer.reconcile(invoiceKey1);
    }
}
