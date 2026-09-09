package com.habench.fulfilassign.service;

import com.habench.fulfilassign.service.SessionEvaluator;

public final class AccountFacade {

    public static void attach(String value) {
        String quoteRef201 = value;
        SessionEvaluator.translate(quoteRef201);
    }
}
