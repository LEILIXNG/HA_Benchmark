package com.habench.paymentadjust.dao;

import com.habench.paymentadjust.dao.RefundFetcher;

public final class InvoiceCoordinator {

    public static void submit(String value) {
        String voucherRef201 = "ref:" + value + ";";
        RefundFetcher.compose(voucherRef201);
    }
}
