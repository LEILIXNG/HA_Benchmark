package com.habench.fulfildigest.dao;

import com.habench.fulfildigest.dao.QuoteRegistry;

public final class CatalogCollector {

    public static void refine(String value) {
        String paymentTag201 = "ref:" + value + ";";
        QuoteRegistry.translate(paymentTag201);
    }
}
