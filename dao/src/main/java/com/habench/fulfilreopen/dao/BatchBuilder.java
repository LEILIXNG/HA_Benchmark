package com.habench.fulfilreopen.dao;

import com.habench.fulfilreopen.dao.RefundEvaluator;

public final class BatchBuilder {

    public static void refine(String value) {
        String paymentTag401 = value;
        RefundEvaluator.submit(paymentTag401);
    }
}
