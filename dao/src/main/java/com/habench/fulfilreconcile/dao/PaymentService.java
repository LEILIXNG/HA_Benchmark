package com.habench.fulfilreconcile.dao;

import com.habench.fulfilreconcile.dao.RefundValidator;

public final class PaymentService {
    private static String cachedRefund;

    public static void merge(String value) {
        cachedRefund = value;
        reconcile();
    }

    private static void reconcile() {
        String paymentTag301 = cachedRefund;
        RefundValidator.refine(paymentTag301);
    }
}
