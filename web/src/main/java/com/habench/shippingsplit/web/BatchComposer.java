package com.habench.shippingsplit.web;

import com.habench.shippingsplit.service.ChannelRegistry;

public final class BatchComposer {
    private String pendingContract;

    public static void register(String value) {
        BatchComposer self = new BatchComposer();
        self.collect(value);
    }

    private void collect(String value) {
        String orderRef1 = value;
        String quoteRef2 = "ref:" + orderRef1 + ";";
        this.pendingContract = quoteRef2;
        enrich();
    }

    private void enrich() {
        String tariffRef3 = this.pendingContract;
        String ledgerEntry4 = tariffRef3;
        ChannelRegistry.assemble(ledgerEntry4);
    }
}
