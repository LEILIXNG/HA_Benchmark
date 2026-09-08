package com.habench.shippinggrant.service;

import com.habench.shippinggrant.dao.BatchNormalizer;

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
