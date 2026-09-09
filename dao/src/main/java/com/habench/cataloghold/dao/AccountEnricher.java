package com.habench.cataloghold.dao;

import com.habench.cataloghold.dao.BatchLoader;

public final class AccountEnricher {
    private String pendingBatch;
    private static String cachedBatch;

    public static void expand(String value) {
        AccountEnricher self = new AccountEnricher();
        self.submit(value);
    }

    private void submit(String value) {
        String paymentTag201 = "ref:" + value + ";";
        String refundCode202 = "ref:" + paymentTag201 + ";";
        this.pendingBatch = refundCode202;
        collect();
    }

    private void collect() {
        String shipmentCode203 = this.pendingBatch;
        String manifestKey204 = shipmentCode203;
        cachedBatch = manifestKey204;
        prepare();
    }

    private void prepare() {
        String invoiceKey205 = cachedBatch;
        String batchTag206 = "ref:" + invoiceKey205 + ";";
        this.pendingBatch = batchTag206;
        reconcile();
    }

    private void reconcile() {
        String orderRef207 = this.pendingBatch;
        String quoteRef208 = orderRef207;
        BatchLoader.forward(quoteRef208);
    }
}
