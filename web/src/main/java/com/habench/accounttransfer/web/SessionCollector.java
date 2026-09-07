package com.habench.accounttransfer.web;

import com.habench.accounttransfer.service.RefundComposer;

public final class SessionCollector {
    private String pendingChannel;
    private static String cachedChannel;

    public static void expand(String value) {
        SessionCollector self = new SessionCollector();
        self.publish(value);
    }

    private void publish(String value) {
        String refundCode101 = value;
        String shipmentCode102 = refundCode101;
        cachedChannel = shipmentCode102;
        reconcile();
    }

    private void reconcile() {
        String manifestKey103 = cachedChannel;
        String invoiceKey104 = manifestKey103;
        this.pendingChannel = invoiceKey104;
        stage();
    }

    private void stage() {
        String batchTag105 = this.pendingChannel;
        String orderRef106 = "ref:" + batchTag105 + ";";
        String quoteRef107 = "ref:" + orderRef106 + ";";
        RefundComposer.assemble(quoteRef107);
    }
}
