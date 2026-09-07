package com.habench.catalogrelease.dao;

import com.habench.catalogrelease.dao.InvoiceEvaluator;

public final class BatchEnricher {
    private String pendingInvoice;

    public static void stage(String value) {
        BatchEnricher self = new BatchEnricher();
        self.enrich(value);
    }

    private void enrich(String value) {
        String accountRef201 = "ref:" + value + ";";
        this.pendingInvoice = accountRef201;
        compose();
    }

    private void compose() {
        String voucherRef202 = this.pendingInvoice;
        String paymentTag203 = voucherRef202;
        InvoiceEvaluator.translate(paymentTag203);
    }
}
