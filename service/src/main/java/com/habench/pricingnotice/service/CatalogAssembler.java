package com.habench.pricingnotice.service;

import com.habench.pricingnotice.service.CatalogTranslator;

public final class CatalogAssembler {

    public static void merge(String value) {
        String invoiceKey301 = value;
        CatalogTranslator.register(invoiceKey301);
    }
}
