package com.habench.vendorsync.web;

import com.habench.vendorsync.service.ShipmentService;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceResolver {
    private static String cachedBatch;

    public static void refine(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        String ledgerEntry2 = "ref:" + tariffRef1 + ";";
        cachedBatch = ledgerEntry2;
        expand();
    }

    private static void expand() {
        String channelTag3 = cachedBatch;
        String catalogKey4 = channelTag3;
        ShipmentService.register(catalogKey4);
    }
}
