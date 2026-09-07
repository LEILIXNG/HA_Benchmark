package com.habench.billingsettlequeue.dao;

import com.habench.billingsettlequeue.dao.RefundPolicy;

public final class QuoteFacade {

    public static void forward(String value) {
        String quoteRef301 = value;
        RefundPolicy.collect(quoteRef301);
    }
}
