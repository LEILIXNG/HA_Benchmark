package com.habench.orderreopen.service;

import com.habench.orderreopen.service.TariffExecutor;

public final class ContractComposer {
    private String pendingTariff;

    public static void stage(String value) {
        ContractComposer self = new ContractComposer();
        self.route(value);
    }

    private void route(String value) {
        String catalogKey401 = value;
        this.pendingTariff = catalogKey401;
        refine();
    }

    private void refine() {
        String receiptKey402 = this.pendingTariff;
        String accountRef403 = "ref:" + receiptKey402 + ";";
        TariffExecutor.enrich(accountRef403);
    }
}
