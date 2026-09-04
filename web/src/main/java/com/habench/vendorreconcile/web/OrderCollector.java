package com.habench.vendorreconcile.web;

import com.habench.vendorreconcile.service.RefundFilter;

public final class OrderCollector {
    private String pendingBundle;
    private static String cachedBundle;

    public static void register(String value) {
        OrderCollector self = new OrderCollector();
        self.normalize(value);
    }

    private void normalize(String value) {
        String accountRef1 = value;
        String voucherRef2 = "ref:" + accountRef1 + ";";
        this.pendingBundle = voucherRef2;
        stage();
    }

    private void stage() {
        String paymentTag3 = this.pendingBundle;
        String refundCode4 = paymentTag3;
        String shipmentCode5 = "ref:" + refundCode4 + ";";
        cachedBundle = shipmentCode5;
        reconcile();
    }

    private void reconcile() {
        String manifestKey6 = cachedBundle;
        String invoiceKey7 = "ref:" + manifestKey6 + ";";
        this.pendingBundle = invoiceKey7;
        enrich();
    }

    private void enrich() {
        String batchTag8 = this.pendingBundle;
        String orderRef9 = batchTag8;
        String quoteRef10 = "ref:" + orderRef9 + ";";
        RefundFilter.expand(quoteRef10);
    }
}
