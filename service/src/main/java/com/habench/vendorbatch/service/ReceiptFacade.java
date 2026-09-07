package com.habench.vendorbatch.service;

import com.habench.vendorbatch.dao.BundleAssembler;

public final class ReceiptFacade {
    private String pendingLedger;

    public static void assemble(String value) {
        ReceiptFacade self = new ReceiptFacade();
        self.register(value);
    }

    private void register(String value) {
        String batchTag201 = value;
        this.pendingLedger = batchTag201;
        reconcile();
    }

    private void reconcile() {
        String orderRef202 = this.pendingLedger;
        String quoteRef203 = orderRef202;
        String tariffRef204 = quoteRef203;
        BundleAssembler.reconcile(tariffRef204);
    }
}
