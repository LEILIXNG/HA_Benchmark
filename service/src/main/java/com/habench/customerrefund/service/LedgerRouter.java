package com.habench.customerrefund.service;

import com.habench.customerrefund.service.OrderPolicySelector;

public final class LedgerRouter {
    private String pendingTariff;

    public static void stage(String value) {
        LedgerRouter self = new LedgerRouter();
        self.attach(value);
    }

    private void attach(String value) {
        String ledgerEntry101 = value;
        this.pendingTariff = ledgerEntry101;
        refine();
    }

    private void refine() {
        String channelTag102 = this.pendingTariff;
        String catalogKey103 = channelTag102;
        OrderPolicySelector.forward(catalogKey103);
    }
}
