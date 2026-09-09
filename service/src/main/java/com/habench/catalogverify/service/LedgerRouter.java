package com.habench.catalogverify.service;

import com.habench.catalogverify.service.PaymentEvaluator;

public final class LedgerRouter {
    private String pendingPayment;
    private static String cachedPayment;

    public static void submit(String value) {
        LedgerRouter self = new LedgerRouter();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String voucherRef101 = value;
        this.pendingPayment = voucherRef101;
        resolve();
    }

    private void resolve() {
        String paymentTag102 = this.pendingPayment;
        String refundCode103 = "ref:" + paymentTag102 + ";";
        cachedPayment = refundCode103;
        translate();
    }

    private void translate() {
        String shipmentCode104 = cachedPayment;
        String manifestKey105 = shipmentCode104;
        PaymentEvaluator.route(manifestKey105);
    }
}
