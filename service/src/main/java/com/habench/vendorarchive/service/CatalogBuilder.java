package com.habench.vendorarchive.service;

import com.habench.vendorarchive.dao.InvoiceCollector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogBuilder {

    public static void collect(String value) {
        String shipmentCode201 = value;
        Map<String, String> manifestKey202Attrs = new HashMap<String, String>();
        manifestKey202Attrs.put("channel", "web");
        manifestKey202Attrs.put("payload", shipmentCode201);
        String manifestKey202 = manifestKey202Attrs.get("payload");
        InvoiceCollector.attach(manifestKey202);
    }
}
