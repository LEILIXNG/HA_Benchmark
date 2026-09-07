package com.habench.paymentsubmit.service;

import com.habench.paymentsubmit.dao.BatchEnricher;

public final class BatchEnricher2 {
    private static String cachedSession;

    public static void reconcile(String value) {
        String invoiceKey101 = value;
        cachedSession = invoiceKey101;
        merge();
    }

    private static void merge() {
        String batchTag102 = cachedSession;
        String orderRef103 = "ref:" + batchTag102 + ";";
        cachedSession = orderRef103;
        translate();
    }

    private static void translate() {
        String quoteRef104 = cachedSession;
        String tariffRef105 = "ref:" + quoteRef104 + ";";
        BatchEnricher.stage(tariffRef105);
    }
}
