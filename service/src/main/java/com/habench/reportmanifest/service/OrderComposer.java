package com.habench.reportmanifest.service;

import com.habench.reportmanifest.service.RefundLoader;

public final class OrderComposer {
    private String pendingRefund;
    private static String cachedRefund;

    public static void collect(String value) {
        OrderComposer self = new OrderComposer();
        self.merge(value);
    }

    private void merge(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        this.pendingRefund = shipmentCode101;
        prepare();
    }

    private void prepare() {
        String manifestKey102 = this.pendingRefund;
        String invoiceKey103 = manifestKey102;
        String batchTag104 = "ref:" + invoiceKey103 + ";";
        cachedRefund = batchTag104;
        stage();
    }

    private void stage() {
        String orderRef105 = cachedRefund;
        String quoteRef106 = "ref:" + orderRef105 + ";";
        RefundLoader.route(quoteRef106);
    }
}
