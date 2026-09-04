package com.habench.fulfildigest.service;

import com.habench.fulfildigest.dao.CatalogCollector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceTranslator {

    public static void refine(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        CatalogCollector.refine(batchTag101);
    }
}
