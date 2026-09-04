package com.habench.vendorissue.web;

import com.habench.vendorissue.web.BundlePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderBuilder {
    private static String cachedPayment;

    public static void translate(String value) {
        String paymentTag1 = value;
        cachedPayment = paymentTag1;
        prepare();
    }

    private static void prepare() {
        String refundCode2 = cachedPayment;
        Map<String, String> shipmentCode3Attrs = new HashMap<String, String>();
        shipmentCode3Attrs.put("channel", "web");
        shipmentCode3Attrs.put("payload", refundCode2);
        String shipmentCode3 = shipmentCode3Attrs.get("payload");
        String manifestKey4 = "ref:" + shipmentCode3 + ";";
        cachedPayment = manifestKey4;
        assemble();
    }

    private static void assemble() {
        String invoiceKey5 = cachedPayment;
        String batchTag6 = "ref:" + invoiceKey5 + ";";
        String orderRef7 = batchTag6;
        cachedPayment = orderRef7;
        register();
    }

    private static void register() {
        String quoteRef8 = cachedPayment;
        Map<String, String> tariffRef9Attrs = new HashMap<String, String>();
        tariffRef9Attrs.put("channel", "web");
        tariffRef9Attrs.put("payload", quoteRef8);
        String tariffRef9 = tariffRef9Attrs.get("payload");
        String ledgerEntry10 = tariffRef9;
        BundlePlanSelector.publish(ledgerEntry10);
    }
}
