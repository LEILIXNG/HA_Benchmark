package com.habench.ordernotice.dao;

import com.habench.ordernotice.dao.BatchScreen;

public final class LedgerBroker {
    private String pendingReceipt;

    public static void forward(String value) {
        LedgerBroker self = new LedgerBroker();
        self.assemble(value);
    }

    private void assemble(String value) {
        String batchTag201 = value;
        this.pendingReceipt = batchTag201;
        attach();
    }

    private void attach() {
        String orderRef202 = this.pendingReceipt;
        String quoteRef203 = "ref:" + orderRef202 + ";";
        String tariffRef204 = quoteRef203;
        BatchScreen.resolve(tariffRef204);
    }
}
