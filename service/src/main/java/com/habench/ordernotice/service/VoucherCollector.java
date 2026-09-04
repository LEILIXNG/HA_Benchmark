package com.habench.ordernotice.service;

import com.habench.ordernotice.service.TariffEnricher;
import java.util.HashMap;
import java.util.Map;

public final class VoucherCollector {
    private static String cachedCatalog;

    public static void enrich(String value) {
        String invoiceKey401 = "ref:" + value + ";";
        Map<String, String> batchTag402Attrs = new HashMap<String, String>();
        batchTag402Attrs.put("channel", "web");
        batchTag402Attrs.put("payload", invoiceKey401);
        String batchTag402 = batchTag402Attrs.get("payload");
        cachedCatalog = batchTag402;
        stage();
    }

    private static void stage() {
        String orderRef403 = cachedCatalog;
        String quoteRef404 = orderRef403;
        TariffEnricher.publish(quoteRef404);
    }
}
