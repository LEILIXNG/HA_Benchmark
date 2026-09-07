package com.habench.catalogposting.web;

import com.habench.catalogposting.service.ChannelAdapter;
import java.util.HashMap;
import java.util.Map;

public final class BundleCoordinator {
    private String pendingLedger;
    private static String cachedLedger;

    public static void reconcile(String value) {
        BundleCoordinator self = new BundleCoordinator();
        self.prepare(value);
    }

    private void prepare(String value) {
        String voucherRef1 = "ref:" + value + ";";
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("payload", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("payload");
        this.pendingLedger = paymentTag2;
        route();
    }

    private void route() {
        String refundCode3 = this.pendingLedger;
        Map<String, String> shipmentCode4Attrs = new HashMap<String, String>();
        shipmentCode4Attrs.put("channel", "web");
        shipmentCode4Attrs.put("payload", refundCode3);
        String shipmentCode4 = shipmentCode4Attrs.get("payload");
        Map<String, String> manifestKey5Attrs = new HashMap<String, String>();
        manifestKey5Attrs.put("channel", "web");
        manifestKey5Attrs.put("payload", shipmentCode4);
        String manifestKey5 = manifestKey5Attrs.get("payload");
        cachedLedger = manifestKey5;
        normalize();
    }

    private void normalize() {
        String invoiceKey6 = cachedLedger;
        Map<String, String> batchTag7Attrs = new HashMap<String, String>();
        batchTag7Attrs.put("channel", "web");
        batchTag7Attrs.put("payload", invoiceKey6);
        String batchTag7 = batchTag7Attrs.get("payload");
        String orderRef8 = batchTag7;
        ChannelAdapter.collect(orderRef8);
    }
}
