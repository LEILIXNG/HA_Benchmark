package com.habench.shippingverify.service;

import com.habench.shippingverify.service.CatalogPolicy;
import java.util.HashMap;
import java.util.Map;

public final class OrderResolver {
    private String pendingOrder;

    public static void register(String value) {
        OrderResolver self = new OrderResolver();
        self.expand(value);
    }

    private void expand(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        Map<String, String> batchTag202Attrs = new HashMap<String, String>();
        batchTag202Attrs.put("channel", "web");
        batchTag202Attrs.put("payload", invoiceKey201);
        String batchTag202 = batchTag202Attrs.get("payload");
        this.pendingOrder = batchTag202;
        merge();
    }

    private void merge() {
        String orderRef203 = this.pendingOrder;
        String quoteRef204 = orderRef203;
        CatalogPolicy.expand(quoteRef204);
    }
}
