package com.habench.accountassign.dao;

import com.habench.accountassign.dao.ManifestEvaluator;

public final class RefundBuilder {

    public static void attach(String value) {
        String orderRef401 = value;
        ManifestEvaluator.resolve(orderRef401);
    }
}
