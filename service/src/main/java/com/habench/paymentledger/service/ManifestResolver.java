package com.habench.paymentledger.service;

import com.habench.paymentledger.service.PaymentPolicy;
import java.util.HashMap;
import java.util.Map;

public final class ManifestResolver {
    private String pendingBatch;

    public static void translate(String value) {
        ManifestResolver self = new ManifestResolver();
        self.submit(value);
    }

    private void submit(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        Map<String, String> refundCode202Attrs = new HashMap<String, String>();
        refundCode202Attrs.put("channel", "web");
        refundCode202Attrs.put("payload", paymentTag201);
        String refundCode202 = refundCode202Attrs.get("payload");
        this.pendingBatch = refundCode202;
        normalize();
    }

    private void normalize() {
        String shipmentCode203 = this.pendingBatch;
        String manifestKey204 = shipmentCode203;
        Map<String, String> invoiceKey205Attrs = new HashMap<String, String>();
        invoiceKey205Attrs.put("channel", "web");
        invoiceKey205Attrs.put("payload", manifestKey204);
        String invoiceKey205 = invoiceKey205Attrs.get("payload");
        PaymentPolicy.dispatch(invoiceKey205);
    }
}
