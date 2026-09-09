package com.habench.fulfilreview.service;

import com.habench.fulfilreview.service.OrderCollector;
import java.util.HashMap;
import java.util.Map;

public final class RefundBroker {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void forward(String value) {
        RefundBroker self = new RefundBroker();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        this.pendingVoucher = batchTag101;
        translate();
    }

    private void translate() {
        String orderRef102 = this.pendingVoucher;
        String quoteRef103 = "ref:" + orderRef102 + ";";
        this.pendingVoucher = quoteRef103;
        enrich();
    }

    private void enrich() {
        String tariffRef104 = this.pendingVoucher;
        String ledgerEntry105 = tariffRef104;
        cachedVoucher = ledgerEntry105;
        merge();
    }

    private void merge() {
        String channelTag106 = cachedVoucher;
        String catalogKey107 = channelTag106;
        String receiptKey108 = catalogKey107;
        OrderCollector.translate(receiptKey108);
    }
}
