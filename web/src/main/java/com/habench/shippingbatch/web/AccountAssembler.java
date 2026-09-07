package com.habench.shippingbatch.web;

import com.habench.shippingbatch.service.QuoteBuilder;
import java.util.HashMap;
import java.util.Map;

public final class AccountAssembler {
    private static String cachedCatalog;

    public static void expand(String value) {
        String refundCode101 = value;
        String shipmentCode102 = "ref:" + refundCode101 + ";";
        cachedCatalog = shipmentCode102;
        dispatch();
    }

    private static void dispatch() {
        String manifestKey103 = cachedCatalog;
        String invoiceKey104 = "ref:" + manifestKey103 + ";";
        Map<String, String> batchTag105Attrs = new HashMap<String, String>();
        batchTag105Attrs.put("channel", "web");
        batchTag105Attrs.put("payload", invoiceKey104);
        String batchTag105 = batchTag105Attrs.get("payload");
        QuoteBuilder.publish(batchTag105);
    }
}
