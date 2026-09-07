package com.habench.accountreconcile.web;

import com.habench.accountreconcile.service.OrderRouter;

public final class CatalogFacade {
    private static String cachedBatch;

    public static void assemble(String value) {
        String invoiceKey1 = value;
        String batchTag2 = "ref:" + invoiceKey1 + ";";
        cachedBatch = batchTag2;
        collect();
    }

    private static void collect() {
        String orderRef3 = cachedBatch;
        String quoteRef4 = orderRef3;
        OrderRouter.expand(quoteRef4);
    }
}
