package com.habench.reportrefund.service;

import com.habench.reportrefund.service.ReceiptAdapter;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRouter {
    private static String cachedTariff;

    public static void stage(String value) {
        String shipmentCode101 = value;
        String manifestKey102 = "ref:" + shipmentCode101 + ";";
        cachedTariff = manifestKey102;
        resolve();
    }

    private static void resolve() {
        String invoiceKey103 = cachedTariff;
        Map<String, String> batchTag104Attrs = new HashMap<String, String>();
        batchTag104Attrs.put("channel", "web");
        batchTag104Attrs.put("payload", invoiceKey103);
        String batchTag104 = batchTag104Attrs.get("payload");
        ReceiptAdapter.translate(batchTag104);
    }
}
