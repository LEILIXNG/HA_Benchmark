package com.habench.paymentverify.service;

import com.habench.paymentverify.dao.AccountNormalizer;

public final class RefundBuilder {

    public static void attach(String value) {
        String orderRef101 = "ref:" + value + ";";
        String quoteRef102 = orderRef101;
        AccountNormalizer.submit(quoteRef102);
    }
}
