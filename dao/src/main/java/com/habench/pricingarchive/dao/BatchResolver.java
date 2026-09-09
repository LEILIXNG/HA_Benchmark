package com.habench.pricingarchive.dao;

import com.habench.pricingarchive.dao.PaymentFetcher;

public final class BatchResolver {

    public static void dispatch(String value) {
        String catalogKey301 = "ref:" + value + ";";
        PaymentFetcher.publish(catalogKey301);
    }
}
