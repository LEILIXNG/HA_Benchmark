package com.habench.reporttransfer.web;

import com.habench.reporttransfer.service.InvoiceCoordinator;

public final class BundleFacade {
    private static String cachedBatch;

    public static void compose(String value) {
        String quoteRef1 = value;
        String tariffRef2 = "ref:" + quoteRef1 + ";";
        cachedBatch = tariffRef2;
        refine();
    }

    private static void refine() {
        String ledgerEntry3 = cachedBatch;
        String channelTag4 = ledgerEntry3;
        InvoiceCoordinator.forward(channelTag4);
    }
}
