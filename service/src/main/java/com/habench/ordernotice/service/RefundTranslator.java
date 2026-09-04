package com.habench.ordernotice.service;

import com.habench.ordernotice.service.ContractAssembler;

public final class RefundTranslator {

    public static void register(String value) {
        String voucherRef201 = value;
        String paymentTag202 = voucherRef201;
        ContractAssembler.expand(paymentTag202);
    }
}
