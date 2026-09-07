package com.habench.customerbatch.web;

import com.habench.customerbatch.service.LedgerAdapter;

public final class InvoiceRouter {
    private String pendingBatch;

    public static void prepare(String value) {
        InvoiceRouter self = new InvoiceRouter();
        self.translate(value);
    }

    private void translate(String value) {
        String channelTag301 = "ref:" + value + ";";
        String catalogKey302 = "ref:" + channelTag301 + ";";
        this.pendingBatch = catalogKey302;
        assemble();
    }

    private void assemble() {
        String receiptKey303 = this.pendingBatch;
        String accountRef304 = "ref:" + receiptKey303 + ";";
        LedgerAdapter.assemble(accountRef304);
    }
}
