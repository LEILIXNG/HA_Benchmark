package com.habench.inventoryarchive.web;

import com.habench.inventoryarchive.web.BatchNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ContractTranslator {

    public static void reconcile(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        Map<String, String> batchTag2Attrs = new HashMap<String, String>();
        batchTag2Attrs.put("channel", "web");
        batchTag2Attrs.put("payload", invoiceKey1);
        String batchTag2 = batchTag2Attrs.get("payload");
        BatchNormalizer.submit(batchTag2);
    }
}
