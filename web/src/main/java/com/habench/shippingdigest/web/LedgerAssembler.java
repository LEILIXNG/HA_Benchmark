package com.habench.shippingdigest.web;

import com.habench.shippingdigest.service.BundleAssembler;
import java.util.HashMap;
import java.util.Map;

public final class LedgerAssembler {
    private static String cachedLedger;

    public static void route(String value) {
        String paymentTag1 = value;
        cachedLedger = paymentTag1;
        forward();
    }

    private static void forward() {
        String refundCode2 = cachedLedger;
        Map<String, String> shipmentCode3Attrs = new HashMap<String, String>();
        shipmentCode3Attrs.put("channel", "web");
        shipmentCode3Attrs.put("payload", refundCode2);
        String shipmentCode3 = shipmentCode3Attrs.get("payload");
        cachedLedger = shipmentCode3;
        enrich();
    }

    private static void enrich() {
        String manifestKey4 = cachedLedger;
        String invoiceKey5 = "ref:" + manifestKey4 + ";";
        Map<String, String> batchTag6Attrs = new HashMap<String, String>();
        batchTag6Attrs.put("channel", "web");
        batchTag6Attrs.put("payload", invoiceKey5);
        String batchTag6 = batchTag6Attrs.get("payload");
        cachedLedger = batchTag6;
        register();
    }

    private static void register() {
        String orderRef7 = cachedLedger;
        String quoteRef8 = "ref:" + orderRef7 + ";";
        BundleAssembler.resolve(quoteRef8);
    }
}
