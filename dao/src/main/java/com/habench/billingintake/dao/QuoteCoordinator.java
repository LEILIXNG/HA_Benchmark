package com.habench.billingintake.dao;

import com.habench.billingintake.dao.InvoiceGateway;

public final class QuoteCoordinator {
    private String pendingInvoice;

    public static void prepare(String value) {
        QuoteCoordinator self = new QuoteCoordinator();
        self.collect(value);
    }

    private void collect(String value) {
        String catalogKey301 = value;
        this.pendingInvoice = catalogKey301;
        expand();
    }

    private void expand() {
        String receiptKey302 = this.pendingInvoice;
        String accountRef303 = receiptKey302;
        InvoiceGateway.translate(accountRef303);
    }
}
