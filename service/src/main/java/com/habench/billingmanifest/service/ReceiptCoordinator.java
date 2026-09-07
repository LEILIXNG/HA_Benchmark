package com.habench.billingmanifest.service;

import com.habench.billingmanifest.dao.OrderAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCoordinator {

    public static void assemble(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        String batchTag102 = "ref:" + invoiceKey101 + ";";
        OrderAssembler.refine(batchTag102);
    }
}
