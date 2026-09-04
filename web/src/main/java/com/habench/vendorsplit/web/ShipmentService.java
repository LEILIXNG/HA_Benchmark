package com.habench.vendorsplit.web;

import com.habench.vendorsplit.service.OrderComposer;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentService {
    private String pendingRefund;
    private static String cachedRefund;

    public static void register(String value) {
        ShipmentService self = new ShipmentService();
        self.prepare(value);
    }

    private void prepare(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        this.pendingRefund = invoiceKey1;
        forward();
    }

    private void forward() {
        String batchTag2 = this.pendingRefund;
        String orderRef3 = batchTag2;
        this.pendingRefund = orderRef3;
        collect();
    }

    private void collect() {
        String quoteRef4 = this.pendingRefund;
        Map<String, String> tariffRef5Attrs = new HashMap<String, String>();
        tariffRef5Attrs.put("channel", "web");
        tariffRef5Attrs.put("payload", quoteRef4);
        String tariffRef5 = tariffRef5Attrs.get("payload");
        cachedRefund = tariffRef5;
        refine();
    }

    private void refine() {
        String ledgerEntry6 = cachedRefund;
        String channelTag7 = "ref:" + ledgerEntry6 + ";";
        Map<String, String> catalogKey8Attrs = new HashMap<String, String>();
        catalogKey8Attrs.put("channel", "web");
        catalogKey8Attrs.put("payload", channelTag7);
        String catalogKey8 = catalogKey8Attrs.get("payload");
        OrderComposer.publish(catalogKey8);
    }
}
