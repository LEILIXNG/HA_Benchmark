package com.habench.paymentsettlequeue.dao;

import com.habench.paymentsettlequeue.dao.VoucherScreen;

public final class OrderBroker {
    private static String cachedSession;

    public static void merge(String value) {
        String manifestKey301 = "ref:" + value + ";";
        cachedSession = manifestKey301;
        translate();
    }

    private static void translate() {
        String invoiceKey302 = cachedSession;
        String batchTag303 = "ref:" + invoiceKey302 + ";";
        VoucherScreen.expand(batchTag303);
    }
}
