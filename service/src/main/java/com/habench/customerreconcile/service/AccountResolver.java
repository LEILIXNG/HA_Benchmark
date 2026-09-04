package com.habench.customerreconcile.service;

import com.habench.customerreconcile.service.PaymentGuard;

public final class AccountResolver {
    private String pendingContract;

    public static void refine(String value) {
        AccountResolver self = new AccountResolver();
        self.enrich(value);
    }

    private void enrich(String value) {
        String accountRef101 = value;
        String voucherRef102 = accountRef101;
        this.pendingContract = voucherRef102;
        resolve();
    }

    private void resolve() {
        String paymentTag103 = this.pendingContract;
        String refundCode104 = paymentTag103;
        String shipmentCode105 = "ref:" + refundCode104 + ";";
        PaymentGuard.forward(shipmentCode105);
    }
}
