package com.habench.fulfilsettlequeue.service;

import com.habench.fulfilsettlequeue.service.RefundResolver;

public final class BatchTranslator {
    private static String cachedManifest;

    public static void submit(String value) {
        String invoiceKey101 = value;
        String batchTag102 = "ref:" + invoiceKey101 + ";";
        cachedManifest = batchTag102;
        assemble();
    }

    private static void assemble() {
        String orderRef103 = cachedManifest;
        String quoteRef104 = orderRef103;
        String tariffRef105 = quoteRef104;
        RefundResolver.assemble(tariffRef105);
    }
}
