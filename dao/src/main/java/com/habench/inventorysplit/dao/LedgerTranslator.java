package com.habench.inventorysplit.dao;

import com.habench.inventorysplit.dao.ManifestGateway;
import java.util.HashMap;
import java.util.Map;

public final class LedgerTranslator {
    private static String cachedManifest;

    public static void prepare(String value) {
        String shipmentCode301 = value;
        cachedManifest = shipmentCode301;
        attach();
    }

    private static void attach() {
        String manifestKey302 = cachedManifest;
        String invoiceKey303 = "ref:" + manifestKey302 + ";";
        Map<String, String> batchTag304Attrs = new HashMap<String, String>();
        batchTag304Attrs.put("channel", "web");
        batchTag304Attrs.put("payload", invoiceKey303);
        String batchTag304 = batchTag304Attrs.get("payload");
        ManifestGateway.translate(batchTag304);
    }
}
