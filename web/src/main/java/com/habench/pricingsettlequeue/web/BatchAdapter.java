package com.habench.pricingsettlequeue.web;

import com.habench.pricingsettlequeue.service.InvoiceRouter;

public final class BatchAdapter {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void route(String value) {
        BatchAdapter self = new BatchAdapter();
        self.assemble(value);
    }

    private void assemble(String value) {
        String batchTag1 = value;
        String orderRef2 = "ref:" + batchTag1 + ";";
        this.pendingCatalog = orderRef2;
        publish();
    }

    private void publish() {
        String quoteRef3 = this.pendingCatalog;
        String tariffRef4 = quoteRef3;
        String ledgerEntry5 = "ref:" + tariffRef4 + ";";
        cachedCatalog = ledgerEntry5;
        compose();
    }

    private void compose() {
        String channelTag6 = cachedCatalog;
        String catalogKey7 = "ref:" + channelTag6 + ";";
        this.pendingCatalog = catalogKey7;
        forward();
    }

    private void forward() {
        String receiptKey8 = this.pendingCatalog;
        String accountRef9 = receiptKey8;
        String voucherRef10 = "ref:" + accountRef9 + ";";
        InvoiceRouter.collect(voucherRef10);
    }
}
