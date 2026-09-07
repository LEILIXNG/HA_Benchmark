package com.habench.fulfillookup.service;

import com.habench.fulfillookup.service.PaymentExecutor;

public final class VoucherBroker {

    public static void attach(String value) {
        String voucherRef401 = value;
        String paymentTag402 = "ref:" + voucherRef401 + ";";
        PaymentExecutor.assemble(paymentTag402);
    }
}
