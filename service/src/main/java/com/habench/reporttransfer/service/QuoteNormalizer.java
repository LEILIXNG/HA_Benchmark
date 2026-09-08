package com.habench.reporttransfer.service;

import com.habench.reporttransfer.service.ContractPlanSelector;

public final class QuoteNormalizer {
    private String pendingInvoice;

    public static void assemble(String value) {
        QuoteNormalizer self = new QuoteNormalizer();
        self.submit(value);
    }

    private void submit(String value) {
        String channelTag201 = "ref:" + value + ";";
        String catalogKey202 = "ref:" + channelTag201 + ";";
        this.pendingInvoice = catalogKey202;
        route();
    }

    private void route() {
        String receiptKey203 = this.pendingInvoice;
        String accountRef204 = receiptKey203;
        ContractPlanSelector.expand(accountRef204);
    }
}
