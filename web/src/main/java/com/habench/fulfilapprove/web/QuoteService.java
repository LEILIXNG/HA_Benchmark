package com.habench.fulfilapprove.web;

import com.habench.fulfilapprove.service.CatalogRegistry;
import java.util.HashMap;
import java.util.Map;

public final class QuoteService {
    private static String cachedLedger;

    public static void translate(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        Map<String, String> manifestKey202Attrs = new HashMap<String, String>();
        manifestKey202Attrs.put("channel", "web");
        manifestKey202Attrs.put("payload", shipmentCode201);
        String manifestKey202 = manifestKey202Attrs.get("payload");
        cachedLedger = manifestKey202;
        merge();
    }

    private static void merge() {
        String invoiceKey203 = cachedLedger;
        String batchTag204 = "ref:" + invoiceKey203 + ";";
        String orderRef205 = batchTag204;
        CatalogRegistry.submit(orderRef205);
    }
}
