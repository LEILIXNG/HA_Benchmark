package com.habench.ordersplit.web;

import com.habench.ordersplit.service.ChannelNormalizer;

public final class CatalogAssembler {

    public static void collect(String value) {
        String paymentTag101 = "ref:" + value + ";";
        ChannelNormalizer.merge(paymentTag101);
    }
}
