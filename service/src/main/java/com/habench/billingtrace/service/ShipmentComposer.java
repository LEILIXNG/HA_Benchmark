package com.habench.billingtrace.service;

import com.habench.billingtrace.service.BundleEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentComposer {
    private String pendingBundle;

    public static void route(String value) {
        ShipmentComposer self = new ShipmentComposer();
        self.submit(value);
    }

    private void submit(String value) {
        String voucherRef201 = value;
        this.pendingBundle = voucherRef201;
        enrich();
    }

    private void enrich() {
        String paymentTag202 = this.pendingBundle;
        String refundCode203 = paymentTag202;
        String shipmentCode204 = "ref:" + refundCode203 + ";";
        this.pendingBundle = shipmentCode204;
        resolve();
    }

    private void resolve() {
        String manifestKey205 = this.pendingBundle;
        String invoiceKey206 = "ref:" + manifestKey205 + ";";
        Map<String, String> batchTag207Attrs = new HashMap<String, String>();
        batchTag207Attrs.put("channel", "web");
        batchTag207Attrs.put("payload", invoiceKey206);
        String batchTag207 = batchTag207Attrs.get("payload");
        BundleEvaluator.merge(batchTag207);
    }
}
