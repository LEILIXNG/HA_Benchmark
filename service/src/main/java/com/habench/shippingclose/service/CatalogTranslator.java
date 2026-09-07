package com.habench.shippingclose.service;

import com.habench.shippingclose.service.BatchTranslator;

public final class CatalogTranslator {
    private String pendingOrder;

    public static void normalize(String value) {
        CatalogTranslator self = new CatalogTranslator();
        self.collect(value);
    }

    private void collect(String value) {
        String channelTag201 = "ref:" + value + ";";
        this.pendingOrder = channelTag201;
        attach();
    }

    private void attach() {
        String catalogKey202 = this.pendingOrder;
        String receiptKey203 = "ref:" + catalogKey202 + ";";
        String accountRef204 = "ref:" + receiptKey203 + ";";
        this.pendingOrder = accountRef204;
        prepare();
    }

    private void prepare() {
        String voucherRef205 = this.pendingOrder;
        String paymentTag206 = voucherRef205;
        BatchTranslator.assemble(paymentTag206);
    }
}
