package com.habench.ordertrace.service;

import com.habench.ordertrace.dao.BatchNormalizer;

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
        String catalogKey201 = this.pendingVoucher;
        BatchNormalizer.compose(catalogKey201);
    }
}
