package com.habench.shippingrevise.web;

import com.habench.shippingrevise.service.ShipmentAdapter;
import java.util.HashMap;
import java.util.Map;

public final class LedgerResolver {

    public static void refine(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        String batchTag2 = invoiceKey1;
        ShipmentAdapter.attach(batchTag2);
    }
}
