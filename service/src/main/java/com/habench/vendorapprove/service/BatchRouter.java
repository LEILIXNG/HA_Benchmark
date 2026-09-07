package com.habench.vendorapprove.service;

import com.habench.vendorapprove.service.InvoicePolicy;
import java.util.HashMap;
import java.util.Map;

public final class BatchRouter {
    private static String cachedChannel;

    public static void publish(String value) {
        String shipmentCode501 = value;
        cachedChannel = shipmentCode501;
        merge();
    }

    private static void merge() {
        String manifestKey502 = cachedChannel;
        Map<String, String> invoiceKey503Attrs = new HashMap<String, String>();
        invoiceKey503Attrs.put("channel", "web");
        invoiceKey503Attrs.put("payload", manifestKey502);
        String invoiceKey503 = invoiceKey503Attrs.get("payload");
        InvoicePolicy.dispatch(invoiceKey503);
    }
}
