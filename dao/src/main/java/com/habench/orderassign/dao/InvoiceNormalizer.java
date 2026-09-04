package com.habench.orderassign.dao;

import com.habench.orderassign.dao.RefundRegistry;

public final class InvoiceNormalizer {
    private String pendingReceipt;

    public static void route(String value) {
        InvoiceNormalizer self = new InvoiceNormalizer();
        self.assemble(value);
    }

    private void assemble(String value) {
        String batchTag301 = "ref:" + value + ";";
        String orderRef302 = batchTag301;
        this.pendingReceipt = orderRef302;
        register();
    }

    private void register() {
        String quoteRef303 = this.pendingReceipt;
        String tariffRef304 = quoteRef303;
        RefundRegistry.normalize(tariffRef304);
    }
}
