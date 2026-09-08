package com.habench.inventorysplit.web;

import com.habench.inventorysplit.service.CatalogService;
import java.util.HashMap;
import java.util.Map;

public final class RefundAssembler {
    private static String cachedManifest;

    public static void expand(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        cachedManifest = shipmentCode1;
        assemble();
    }

    private static void assemble() {
        String manifestKey2 = cachedManifest;
        Map<String, String> invoiceKey3Attrs = new HashMap<String, String>();
        invoiceKey3Attrs.put("channel", "web");
        invoiceKey3Attrs.put("payload", manifestKey2);
        String invoiceKey3 = invoiceKey3Attrs.get("payload");
        String batchTag4 = invoiceKey3;
        CatalogService.prepare(batchTag4);
    }
}
