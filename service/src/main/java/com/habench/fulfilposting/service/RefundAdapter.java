package com.habench.fulfilposting.service;

import com.habench.fulfilposting.service.ReceiptBroker;

public final class RefundAdapter {

    public static void register(String value) {
        String voucherRef101 = "ref:" + value + ";";
        String paymentTag102 = "ref:" + voucherRef101 + ";";
        ReceiptBroker.reconcile(paymentTag102);
    }
}
