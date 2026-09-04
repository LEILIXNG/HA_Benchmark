package com.habench.accountdigest.service;

import com.habench.accountdigest.service.BundleBroker;

public final class OrderComposer {
    private String pendingPayment;
    private static String cachedPayment;

    public static void forward(String value) {
        OrderComposer self = new OrderComposer();
        self.enrich(value);
    }

    private void enrich(String value) {
        String accountRef201 = value;
        String voucherRef202 = accountRef201;
        this.pendingPayment = voucherRef202;
        reconcile();
    }

    private void reconcile() {
        String paymentTag203 = this.pendingPayment;
        String refundCode204 = paymentTag203;
        String shipmentCode205 = "ref:" + refundCode204 + ";";
        cachedPayment = shipmentCode205;
        attach();
    }

    private void attach() {
        String manifestKey206 = cachedPayment;
        String invoiceKey207 = manifestKey206;
        BundleBroker.enrich(invoiceKey207);
    }
}
