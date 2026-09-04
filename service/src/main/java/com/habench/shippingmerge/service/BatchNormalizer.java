package com.habench.shippingmerge.service;

import com.habench.shippingmerge.dao.QuoteTranslator;

public final class BatchNormalizer {
    private String pendingAccount;

    public static void merge(String value) {
        BatchNormalizer self = new BatchNormalizer();
        self.submit(value);
    }

    private void submit(String value) {
        String shipmentCode201 = value;
        this.pendingAccount = shipmentCode201;
        forward();
    }

    private void forward() {
        String manifestKey202 = this.pendingAccount;
        String invoiceKey203 = manifestKey202;
        String batchTag204 = "ref:" + invoiceKey203 + ";";
        this.pendingAccount = batchTag204;
        translate();
    }

    private void translate() {
        String orderRef205 = this.pendingAccount;
        String quoteRef206 = orderRef205;
        QuoteTranslator.dispatch(quoteRef206);
    }
}
