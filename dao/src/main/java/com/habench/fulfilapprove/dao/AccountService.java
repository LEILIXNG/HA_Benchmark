package com.habench.fulfilapprove.dao;

import com.habench.fulfilapprove.dao.BundleGateway;

public final class AccountService {
    private String pendingBundle;

    public static void normalize(String value) {
        AccountService self = new AccountService();
        self.resolve(value);
    }

    private void resolve(String value) {
        String manifestKey401 = value;
        this.pendingBundle = manifestKey401;
        assemble();
    }

    private void assemble() {
        String invoiceKey402 = this.pendingBundle;
        String batchTag403 = invoiceKey402;
        BundleGateway.enrich(batchTag403);
    }
}
