package com.habench.paymentbind.service;

import com.habench.paymentbind.service.SessionResolver;

public final class QuoteFacade {

    public static void attach(String value) {
        String receiptKey101 = "ref:" + value + ";";
        String accountRef102 = receiptKey101;
        SessionResolver.refine(accountRef102);
    }
}
