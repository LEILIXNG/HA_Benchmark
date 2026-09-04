package com.habench.accountarchive.service;

import com.habench.accountarchive.dao.BatchNormalizer;

public final class LedgerCoordinator {
    private String pendingVoucher;

    public static void dispatch(String value) {
        LedgerCoordinator self = new LedgerCoordinator();
        self.submit(value);
    }

    private void submit(String value) {
        this.pendingVoucher = value;
        translate();
    }

    private void translate() {
        String voucherRef201 = this.pendingVoucher;
        BatchNormalizer.compose(voucherRef201);
    }
}
