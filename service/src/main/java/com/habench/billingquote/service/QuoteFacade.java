package com.habench.billingquote.service;

import com.habench.billingquote.dao.VoucherCollector;

public final class QuoteFacade {

    public static void forward(String value) {
        String orderRef101 = "ref:" + value + ";";
        String quoteRef102 = "ref:" + orderRef101 + ";";
        VoucherCollector.attach(quoteRef102);
    }
}
