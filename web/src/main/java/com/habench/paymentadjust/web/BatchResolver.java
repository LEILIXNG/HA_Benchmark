package com.habench.paymentadjust.web;

import com.habench.paymentadjust.web.SessionEvaluator;

public final class BatchResolver {

    public static void compose(String value) {
        String manifestKey201 = value;
        SessionEvaluator.resolve(manifestKey201);
    }
}
