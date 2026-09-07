package com.habench.fulfilreconcile.dao;

import com.habench.fulfilreconcile.dao.RefundValidator;

public final class PaymentService {
    private static String cachedRefund;

    public static void merge(String value) {
        cachedRefund = value;
        reconcile();
    }

    private static void reconcile() {
        String orderRef301 = cachedRefund;
        RefundValidator.refine(orderRef301);
    }
}
