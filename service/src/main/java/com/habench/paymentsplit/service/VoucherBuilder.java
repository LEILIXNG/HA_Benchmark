package com.habench.paymentsplit.service;

import com.habench.paymentsplit.service.ReceiptAssembler;

public final class VoucherBuilder {

    public static void attach(String value) {
        String paymentTag101 = "ref:" + value + ";";
        ReceiptAssembler.translate(paymentTag101);
    }
}
