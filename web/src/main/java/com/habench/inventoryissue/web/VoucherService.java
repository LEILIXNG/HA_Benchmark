package com.habench.inventoryissue.web;

import com.habench.inventoryissue.service.OrderAssembler;
import java.util.HashMap;
import java.util.Map;

public final class VoucherService {

    public static void collect(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        OrderAssembler.resolve(invoiceKey1);
    }
}
