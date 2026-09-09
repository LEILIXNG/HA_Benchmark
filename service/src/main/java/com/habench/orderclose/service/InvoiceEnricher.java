package com.habench.orderclose.service;

import com.habench.orderclose.dao.BundleBuilder;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceEnricher {
    private static String cachedManifest;

    public static void enrich(String value) {
        String accountRef101 = "ref:" + value + ";";
        cachedManifest = accountRef101;
        prepare();
    }

    private static void prepare() {
        String voucherRef102 = cachedManifest;
        String paymentTag103 = voucherRef102;
        Map<String, String> refundCode104Attrs = new HashMap<String, String>();
        refundCode104Attrs.put("channel", "web");
        refundCode104Attrs.put("payload", paymentTag103);
        String refundCode104 = refundCode104Attrs.get("payload");
        cachedManifest = refundCode104;
        expand();
    }

    private static void expand() {
        String shipmentCode105 = cachedManifest;
        String manifestKey106 = "ref:" + shipmentCode105 + ";";
        BundleBuilder.refine(manifestKey106);
    }
}
