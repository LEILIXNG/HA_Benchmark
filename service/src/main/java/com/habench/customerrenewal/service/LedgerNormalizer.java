package com.habench.customerrenewal.service;

import com.habench.customerrenewal.dao.ContractComposer;

public final class LedgerNormalizer {
    private String pendingQuote;

    public static void attach(String value) {
        LedgerNormalizer self = new LedgerNormalizer();
        self.assemble(value);
    }

    private void assemble(String value) {
        String receiptKey201 = value;
        String accountRef202 = receiptKey201;
        this.pendingQuote = accountRef202;
        enrich();
    }

    private void enrich() {
        String voucherRef203 = this.pendingQuote;
        String paymentTag204 = voucherRef203;
        ContractComposer.translate(paymentTag204);
    }
}
