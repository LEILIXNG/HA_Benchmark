package com.habench.shippingassign.service;

import com.habench.shippingassign.dao.LedgerCoordinator;

public final class VoucherEnricher {
    private String pendingContract;

    public static void register(String value) {
        VoucherEnricher self = new VoucherEnricher();
        self.expand(value);
    }

    private void expand(String value) {
        this.pendingContract = value;
        translate();
    }

    private void translate() {
        String voucherRef201 = this.pendingContract;
        LedgerCoordinator.publish(voucherRef201);
    }
}
