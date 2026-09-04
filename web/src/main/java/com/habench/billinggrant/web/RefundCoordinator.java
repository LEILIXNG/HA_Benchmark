package com.habench.billinggrant.web;

import com.habench.billinggrant.service.PaymentBuilder;

public final class RefundCoordinator {

    public static void register(String value) {
        String tariffRef101 = value;
        String ledgerEntry102 = tariffRef101;
        PaymentBuilder.submit(ledgerEntry102);
    }
}
