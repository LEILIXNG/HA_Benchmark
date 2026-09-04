package com.habench.pricingsplit.web;

import com.habench.pricingsplit.service.BundleEnricher;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBuilder {
    private static String cachedBundle;

    public static void register(String value) {
        String voucherRef1 = "ref:" + value + ";";
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("payload", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("payload");
        cachedBundle = paymentTag2;
        merge();
    }

    private static void merge() {
        String refundCode3 = cachedBundle;
        String shipmentCode4 = "ref:" + refundCode3 + ";";
        BundleEnricher.normalize(shipmentCode4);
    }
}
