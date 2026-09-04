package com.habench.paymentsplit.web;

import com.habench.paymentsplit.service.VoucherAdapter;

public final class ReceiptFacade {
    private static String cachedRefund;

    public static void publish(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        cachedRefund = ledgerEntry201;
        merge();
    }

    private static void merge() {
        String channelTag202 = cachedRefund;
        String catalogKey203 = "ref:" + channelTag202 + ";";
        VoucherAdapter.prepare(catalogKey203);
    }
}
