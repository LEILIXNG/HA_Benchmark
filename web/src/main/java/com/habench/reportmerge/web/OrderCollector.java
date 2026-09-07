package com.habench.reportmerge.web;

import com.habench.reportmerge.service.SessionBuilder;
import java.util.HashMap;
import java.util.Map;

public final class OrderCollector {
    private static String cachedSession;

    public static void normalize(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        cachedSession = shipmentCode1;
        merge();
    }

    private static void merge() {
        String manifestKey2 = cachedSession;
        String invoiceKey3 = manifestKey2;
        String batchTag4 = invoiceKey3;
        SessionBuilder.dispatch(batchTag4);
    }
}
