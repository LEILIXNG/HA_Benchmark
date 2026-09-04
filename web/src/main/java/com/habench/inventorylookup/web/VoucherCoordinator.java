package com.habench.inventorylookup.web;

import com.habench.inventorylookup.web.ReceiptCollector;

public final class VoucherCoordinator {
    private static String cachedBatch;

    public static void translate(String value) {
        String batchTag1 = "ref:" + value + ";";
        String orderRef2 = "ref:" + batchTag1 + ";";
        cachedBatch = orderRef2;
        collect();
    }

    private static void collect() {
        String quoteRef3 = cachedBatch;
        String tariffRef4 = "ref:" + quoteRef3 + ";";
        ReceiptCollector.compose(tariffRef4);
    }
}
