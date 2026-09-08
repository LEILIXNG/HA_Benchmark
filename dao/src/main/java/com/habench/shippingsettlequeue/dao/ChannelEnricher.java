package com.habench.shippingsettlequeue.dao;

import com.habench.shippingsettlequeue.dao.PaymentFetcher;

public final class ChannelEnricher {

    public static void reconcile(String value) {
        String voucherRef201 = "ref:" + value + ";";
        PaymentFetcher.refine(voucherRef201);
    }
}
