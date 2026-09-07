package com.habench.fulfilsplit.dao;

import com.habench.fulfilsplit.dao.PaymentFetcher;

public final class ChannelEnricher {

    public static void reconcile(String value) {
        String voucherRef201 = "ref:" + value + ";";
        PaymentFetcher.refine(voucherRef201);
    }
}
