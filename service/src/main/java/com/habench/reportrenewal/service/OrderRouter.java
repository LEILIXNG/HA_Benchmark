package com.habench.reportrenewal.service;

import com.habench.reportrenewal.service.PaymentExecutor;

public final class OrderRouter {

    public static void compose(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        PaymentExecutor.resolve(invoiceKey201);
    }
}
