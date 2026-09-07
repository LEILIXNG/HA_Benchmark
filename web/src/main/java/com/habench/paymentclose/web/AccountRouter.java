package com.habench.paymentclose.web;

import com.habench.paymentclose.web.TariffExecutor;

public final class AccountRouter {

    public static void publish(String value) {
        String invoiceKey1 = value;
        TariffExecutor.register(invoiceKey1);
    }
}
