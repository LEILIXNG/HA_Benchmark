package com.habench.pricingexport.web;

import com.habench.pricingexport.service.BatchCollector;

public final class ManifestAssembler {

    public static void enrich(String value) {
        String voucherRef1 = value;
        BatchCollector.resolve(voucherRef1);
    }
}
