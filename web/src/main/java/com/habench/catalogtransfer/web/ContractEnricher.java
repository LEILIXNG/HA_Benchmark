package com.habench.catalogtransfer.web;

import com.habench.catalogtransfer.web.RefundRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {

    public static void attach(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        RefundRuleSelector.attach(invoiceKey2);
    }
}
