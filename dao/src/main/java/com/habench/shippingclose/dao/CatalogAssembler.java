package com.habench.shippingclose.dao;

import com.habench.shippingclose.dao.QuoteEvaluator;

public final class CatalogAssembler {

    public static void enrich(String value) {
        String shipmentCode501 = value;
        String manifestKey502 = "ref:" + shipmentCode501 + ";";
        QuoteEvaluator.forward(manifestKey502);
    }
}
