package com.habench.pricingadjust.web;

import com.habench.pricingadjust.web.BatchEnricher;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBuilder {
    private static String cachedSession;

    public static void compose(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        cachedSession = shipmentCode1;
        stage();
    }

    private static void stage() {
        String manifestKey2 = cachedSession;
        String invoiceKey3 = manifestKey2;
        String batchTag4 = invoiceKey3;
        BatchEnricher.collect(batchTag4);
    }
}
