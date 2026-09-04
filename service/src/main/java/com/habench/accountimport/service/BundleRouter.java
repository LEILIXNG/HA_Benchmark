package com.habench.accountimport.service;

import com.habench.accountimport.dao.ContractComposer;

public final class BundleRouter {
    private String pendingTariff;

    public static void enrich(String value) {
        BundleRouter self = new BundleRouter();
        self.collect(value);
    }

    private void collect(String value) {
        String catalogKey201 = value;
        this.pendingTariff = catalogKey201;
        normalize();
    }

    private void normalize() {
        String receiptKey202 = this.pendingTariff;
        String accountRef203 = receiptKey202;
        String voucherRef204 = accountRef203;
        ContractComposer.route(voucherRef204);
    }
}
