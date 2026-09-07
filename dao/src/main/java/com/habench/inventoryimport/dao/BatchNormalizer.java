package com.habench.inventoryimport.dao;

import com.habench.inventoryimport.dao.ReceiptNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class BatchNormalizer {

    public static void submit(String value) {
        Map<String, String> invoiceKey301Attrs = new HashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("payload", value);
        String invoiceKey301 = invoiceKey301Attrs.get("payload");
        String batchTag302 = invoiceKey301;
        ReceiptNormalizer.attach(batchTag302);
    }
}
