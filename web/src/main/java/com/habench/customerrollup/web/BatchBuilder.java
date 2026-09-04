package com.habench.customerrollup.web;

import com.habench.customerrollup.service.LedgerCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class BatchBuilder {
    private String pendingChannel;
    private static String cachedChannel;

    public static void reconcile(String value) {
        BatchBuilder self = new BatchBuilder();
        self.prepare(value);
    }

    private void prepare(String value) {
        String catalogKey101 = value;
        this.pendingChannel = catalogKey101;
        refine();
    }

    private void refine() {
        String receiptKey102 = this.pendingChannel;
        String accountRef103 = receiptKey102;
        String voucherRef104 = accountRef103;
        cachedChannel = voucherRef104;
        collect();
    }

    private void collect() {
        String paymentTag105 = cachedChannel;
        String refundCode106 = "ref:" + paymentTag105 + ";";
        cachedChannel = refundCode106;
        route();
    }

    private void route() {
        String shipmentCode107 = cachedChannel;
        String manifestKey108 = "ref:" + shipmentCode107 + ";";
        Map<String, String> invoiceKey109Attrs = new HashMap<String, String>();
        invoiceKey109Attrs.put("channel", "web");
        invoiceKey109Attrs.put("payload", manifestKey108);
        String invoiceKey109 = invoiceKey109Attrs.get("payload");
        LedgerCoordinator.attach(invoiceKey109);
    }
}
