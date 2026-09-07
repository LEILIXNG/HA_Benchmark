package com.habench.catalogissue.service;

import com.habench.catalogissue.service.RefundEvaluator;

public final class CatalogEnricher {

    public static void dispatch(String value) {
        String channelTag101 = value;
        RefundEvaluator.prepare(channelTag101);
    }
}
