package com.habench.shippingverify.web;

import com.habench.shippingverify.service.OrderResolver;

public final class LedgerCollector {
    private String pendingOrder;

    public static void collect(String value) {
        LedgerCollector self = new LedgerCollector();
        self.assemble(value);
    }

    private void assemble(String value) {
        String quoteRef1 = value;
        this.pendingOrder = quoteRef1;
        normalize();
    }

    private void normalize() {
        String tariffRef2 = this.pendingOrder;
        String ledgerEntry3 = tariffRef2;
        String channelTag4 = "ref:" + ledgerEntry3 + ";";
        this.pendingOrder = channelTag4;
        compose();
    }

    private void compose() {
        String catalogKey5 = this.pendingOrder;
        String receiptKey6 = catalogKey5;
        OrderResolver.refine(receiptKey6);
    }
}
