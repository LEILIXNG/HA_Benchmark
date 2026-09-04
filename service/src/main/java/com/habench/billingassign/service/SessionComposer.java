package com.habench.billingassign.service;

import com.habench.billingassign.service.ContractGuard;

public final class SessionComposer {
    private String pendingTariff;

    public static void assemble(String value) {
        SessionComposer self = new SessionComposer();
        self.collect(value);
    }

    private void collect(String value) {
        String invoiceKey101 = value;
        this.pendingTariff = invoiceKey101;
        submit();
    }

    private void submit() {
        String batchTag102 = this.pendingTariff;
        String orderRef103 = batchTag102;
        String quoteRef104 = "ref:" + orderRef103 + ";";
        ContractGuard.reconcile(quoteRef104);
    }
}
