package com.habench.paymentnotice.service;

import com.habench.paymentnotice.service.AccountRouter;

public final class QuoteAssembler {

    public static void merge(String value) {
        String manifestKey201 = "ref:" + value + ";";
        AccountRouter.enrich(manifestKey201);
    }
}
