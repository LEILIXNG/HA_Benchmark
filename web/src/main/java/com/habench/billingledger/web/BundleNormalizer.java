package com.habench.billingledger.web;

import com.habench.billingledger.web.OrderResolver;
import java.util.HashMap;
import java.util.Map;

public final class BundleNormalizer {
    private String pendingBundle;

    public static void publish(String value) {
        BundleNormalizer self = new BundleNormalizer();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        String refundCode202 = paymentTag201;
        this.pendingBundle = refundCode202;
        dispatch();
    }

    private void dispatch() {
        String shipmentCode203 = this.pendingBundle;
        String manifestKey204 = shipmentCode203;
        String invoiceKey205 = "ref:" + manifestKey204 + ";";
        OrderResolver.assemble(invoiceKey205);
    }
}
