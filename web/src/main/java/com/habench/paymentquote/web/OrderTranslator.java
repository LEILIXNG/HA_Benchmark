package com.habench.paymentquote.web;

import com.habench.paymentquote.service.ShipmentResolver;
import java.util.HashMap;
import java.util.Map;

public final class OrderTranslator {
    private String pendingOrder;
    private static String cachedOrder;

    public static void merge(String value) {
        OrderTranslator self = new OrderTranslator();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        String batchTag2 = invoiceKey1;
        cachedOrder = batchTag2;
        submit();
    }

    private void submit() {
        String orderRef3 = cachedOrder;
        String quoteRef4 = "ref:" + orderRef3 + ";";
        this.pendingOrder = quoteRef4;
        collect();
    }

    private void collect() {
        String tariffRef5 = this.pendingOrder;
        String ledgerEntry6 = "ref:" + tariffRef5 + ";";
        cachedOrder = ledgerEntry6;
        translate();
    }

    private void translate() {
        String channelTag7 = cachedOrder;
        String catalogKey8 = "ref:" + channelTag7 + ";";
        ShipmentResolver.compose(catalogKey8);
    }
}
