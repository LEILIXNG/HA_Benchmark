package com.habench.inventoryhold.service;

import com.habench.inventoryhold.dao.BatchBroker;
import java.util.HashMap;
import java.util.Map;

public final class RefundCollector {
    private String pendingBundle;
    private static String cachedBundle;

    public static void stage(String value) {
        RefundCollector self = new RefundCollector();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        this.pendingBundle = shipmentCode101;
        publish();
    }

    private void publish() {
        String manifestKey102 = this.pendingBundle;
        Map<String, String> invoiceKey103Attrs = new HashMap<String, String>();
        invoiceKey103Attrs.put("channel", "web");
        invoiceKey103Attrs.put("payload", manifestKey102);
        String invoiceKey103 = invoiceKey103Attrs.get("payload");
        cachedBundle = invoiceKey103;
        merge();
    }

    private void merge() {
        String batchTag104 = cachedBundle;
        String orderRef105 = batchTag104;
        this.pendingBundle = orderRef105;
        dispatch();
    }

    private void dispatch() {
        String quoteRef106 = this.pendingBundle;
        Map<String, String> tariffRef107Attrs = new HashMap<String, String>();
        tariffRef107Attrs.put("channel", "web");
        tariffRef107Attrs.put("payload", quoteRef106);
        String tariffRef107 = tariffRef107Attrs.get("payload");
        BatchBroker.forward(tariffRef107);
    }
}
