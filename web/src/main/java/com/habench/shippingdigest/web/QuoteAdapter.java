package com.habench.shippingdigest.web;

import com.habench.shippingdigest.service.PaymentRegistry;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAdapter {
    private String pendingOrder;
    private static String cachedOrder;

    public static void collect(String value) {
        QuoteAdapter self = new QuoteAdapter();
        self.stage(value);
    }

    private void stage(String value) {
        String manifestKey1 = value;
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        this.pendingOrder = invoiceKey2;
        dispatch();
    }

    private void dispatch() {
        String batchTag3 = this.pendingOrder;
        Map<String, String> orderRef4Attrs = new HashMap<String, String>();
        orderRef4Attrs.put("channel", "web");
        orderRef4Attrs.put("payload", batchTag3);
        String orderRef4 = orderRef4Attrs.get("payload");
        cachedOrder = orderRef4;
        publish();
    }

    private void publish() {
        String quoteRef5 = cachedOrder;
        String tariffRef6 = "ref:" + quoteRef5 + ";";
        PaymentRegistry.merge(tariffRef6);
    }
}
