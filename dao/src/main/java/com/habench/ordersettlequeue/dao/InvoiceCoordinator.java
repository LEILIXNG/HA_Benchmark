package com.habench.ordersettlequeue.dao;

import com.habench.ordersettlequeue.dao.RefundFetcher;

public final class InvoiceCoordinator {

    public static void submit(String value) {
        String voucherRef201 = "ref:" + value + ";";
        RefundFetcher.compose(voucherRef201);
    }
}
