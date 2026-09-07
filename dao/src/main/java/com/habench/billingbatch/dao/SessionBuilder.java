package com.habench.billingbatch.dao;

import com.habench.billingbatch.dao.PaymentEvaluator;

public final class SessionBuilder {

    public static void resolve(String value) {
        String shipmentCode201 = value;
        PaymentEvaluator.collect(shipmentCode201);
    }
}
