package com.habench.reportverify.service;

import com.habench.reportverify.service.SessionEvaluator;

public final class AccountFacade {

    public static void attach(String value) {
        String quoteRef201 = value;
        SessionEvaluator.translate(quoteRef201);
    }
}
