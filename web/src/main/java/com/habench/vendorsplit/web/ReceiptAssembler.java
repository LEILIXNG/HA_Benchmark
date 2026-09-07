package com.habench.vendorsplit.web;

import com.habench.vendorsplit.web.RefundBroker;

public final class ReceiptAssembler {

    public static void attach(String value) {
        String voucherRef1 = value;
        RefundBroker.reconcile(voucherRef1);
    }
}
