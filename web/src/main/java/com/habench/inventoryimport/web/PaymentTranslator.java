package com.habench.inventoryimport.web;

import com.habench.inventoryimport.service.ShipmentNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class PaymentTranslator {

    public static void merge(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        Map<String, String> batchTag2Attrs = new HashMap<String, String>();
        batchTag2Attrs.put("channel", "web");
        batchTag2Attrs.put("payload", invoiceKey1);
        String batchTag2 = batchTag2Attrs.get("payload");
        ShipmentNormalizer.forward(batchTag2);
    }
}
