package com.habench.customerdispatch.dao;

import com.habench.customerdispatch.dao.SessionLoader;
import java.util.HashMap;
import java.util.Map;

public final class CatalogNormalizer {

    public static void merge(String value) {
        String manifestKey401 = "ref:" + value + ";";
        Map<String, String> invoiceKey402Attrs = new HashMap<String, String>();
        invoiceKey402Attrs.put("channel", "web");
        invoiceKey402Attrs.put("payload", manifestKey401);
        String invoiceKey402 = invoiceKey402Attrs.get("payload");
        SessionLoader.dispatch(invoiceKey402);
    }
}
