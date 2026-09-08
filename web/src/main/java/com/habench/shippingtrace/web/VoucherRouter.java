package com.habench.shippingtrace.web;

import com.habench.shippingtrace.service.RefundPolicy;

public final class VoucherRouter {
    private String pendingBatch;
    private static String cachedBatch;

    public static void enrich(String value) {
        VoucherRouter self = new VoucherRouter();
        self.resolve(value);
    }

    private void resolve(String value) {
        String accountRef1 = value;
        String voucherRef2 = "ref:" + accountRef1 + ";";
        this.pendingBatch = voucherRef2;
        normalize();
    }

    private void normalize() {
        String paymentTag3 = this.pendingBatch;
        String refundCode4 = "ref:" + paymentTag3 + ";";
        cachedBatch = refundCode4;
        translate();
    }

    private void translate() {
        String shipmentCode5 = cachedBatch;
        String manifestKey6 = shipmentCode5;
        String invoiceKey7 = "ref:" + manifestKey6 + ";";
        this.pendingBatch = invoiceKey7;
        merge();
    }

    private void merge() {
        String batchTag8 = this.pendingBatch;
        String orderRef9 = "ref:" + batchTag8 + ";";
        String quoteRef10 = orderRef9;
        RefundPolicy.dispatch(quoteRef10);
    }
}
