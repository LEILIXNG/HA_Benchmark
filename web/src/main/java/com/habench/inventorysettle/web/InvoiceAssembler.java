package com.habench.inventorysettle.web;

import com.habench.inventorysettle.service.BundleAssembler;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAssembler {
    private static String cachedRefund;

    public static void publish(String value) {
        String manifestKey101 = value;
        cachedRefund = manifestKey101;
        merge();
    }

    private static void merge() {
        String invoiceKey102 = cachedRefund;
        Map<String, String> batchTag103Attrs = new HashMap<String, String>();
        batchTag103Attrs.put("channel", "web");
        batchTag103Attrs.put("payload", invoiceKey102);
        String batchTag103 = batchTag103Attrs.get("payload");
        Map<String, String> orderRef104Attrs = new HashMap<String, String>();
        orderRef104Attrs.put("channel", "web");
        orderRef104Attrs.put("payload", batchTag103);
        String orderRef104 = orderRef104Attrs.get("payload");
        BundleAssembler.prepare(orderRef104);
    }
}
