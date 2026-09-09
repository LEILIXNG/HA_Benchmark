package com.habench.orderreview.web;

import com.habench.orderreview.web.ManifestStrategySelector;

public final class RefundResolver {

    public static void resolve(String value) {
        String invoiceKey1 = value;
        String batchTag2 = invoiceKey1;
        ManifestStrategySelector.collect(batchTag2);
    }
}
