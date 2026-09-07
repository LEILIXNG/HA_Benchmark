package com.habench.vendorverify.web;

import com.habench.vendorverify.service.PaymentBroker;

public final class LedgerAssembler {

    public static void expand(String value) {
        String accountRef401 = value;
        String voucherRef402 = accountRef401;
        PaymentBroker.compose(voucherRef402);
    }
}
