package com.habench.pricingarchive.service;

import com.habench.pricingarchive.dao.BatchResolver;

public final class SessionNormalizer {

    public static void merge(String value) {
        String refundCode201 = "ref:" + value + ";";
        String shipmentCode202 = refundCode201;
        BatchResolver.dispatch(shipmentCode202);
    }
}
