package com.habench.vendorledger.web;

import com.habench.vendorledger.service.BatchBroker;
import java.util.HashMap;
import java.util.Map;

public final class OrderComposer {
    private String pendingBatch;

    public static void collect(String value) {
        OrderComposer self = new OrderComposer();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        this.pendingBatch = invoiceKey2;
        stage();
    }

    private void stage() {
        String batchTag3 = this.pendingBatch;
        Map<String, String> orderRef4Attrs = new HashMap<String, String>();
        orderRef4Attrs.put("channel", "web");
        orderRef4Attrs.put("payload", batchTag3);
        String orderRef4 = orderRef4Attrs.get("payload");
        String quoteRef5 = orderRef4;
        BatchBroker.reconcile(quoteRef5);
    }
}
