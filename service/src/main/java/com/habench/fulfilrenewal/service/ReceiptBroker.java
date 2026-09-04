package com.habench.fulfilrenewal.service;

import com.habench.fulfilrenewal.service.InvoicePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBroker {
    private static String cachedContract;

    public static void resolve(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        String batchTag102 = invoiceKey101;
        cachedContract = batchTag102;
        translate();
    }

    private static void translate() {
        String orderRef103 = cachedContract;
        Map<String, String> quoteRef104Attrs = new HashMap<String, String>();
        quoteRef104Attrs.put("channel", "web");
        quoteRef104Attrs.put("payload", orderRef103);
        String quoteRef104 = quoteRef104Attrs.get("payload");
        InvoicePolicySelector.reconcile(quoteRef104);
    }
}
