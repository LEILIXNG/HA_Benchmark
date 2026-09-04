package com.habench.vendorrevise.service;

import com.habench.vendorrevise.service.OrderExecutor;

public final class BundleBuilder {
    private String pendingOrder;

    public static void compose(String value) {
        BundleBuilder self = new BundleBuilder();
        self.route(value);
    }

    private void route(String value) {
        String receiptKey201 = "ref:" + value + ";";
        this.pendingOrder = receiptKey201;
        normalize();
    }

    private void normalize() {
        String accountRef202 = this.pendingOrder;
        String voucherRef203 = "ref:" + accountRef202 + ";";
        String paymentTag204 = voucherRef203;
        OrderExecutor.stage(paymentTag204);
    }
}
