package com.habench.billingreconcile.dao;

import com.habench.billingreconcile.dao.PaymentExecutor;

public final class QuoteTranslator {

    public static void route(String value) {
        String shipmentCode401 = "ref:" + value + ";";
        PaymentExecutor.forward(shipmentCode401);
    }
}
