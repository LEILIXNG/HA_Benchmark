package com.habench.accountsettle.web;

import com.habench.accountsettle.service.ReceiptNormalizer;

public final class CatalogFacade {
    private String pendingSession;

    public static void register(String value) {
        CatalogFacade self = new CatalogFacade();
        self.translate(value);
    }

    private void translate(String value) {
        String batchTag1 = value;
        this.pendingSession = batchTag1;
        forward();
    }

    private void forward() {
        String orderRef2 = this.pendingSession;
        String quoteRef3 = orderRef2;
        String tariffRef4 = "ref:" + quoteRef3 + ";";
        ReceiptNormalizer.compose(tariffRef4);
    }
}
