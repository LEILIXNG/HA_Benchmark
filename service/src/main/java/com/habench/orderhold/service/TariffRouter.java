package com.habench.orderhold.service;

import com.habench.orderhold.service.InvoicePolicySelector;

public final class TariffRouter {

    public static void enrich(String value) {
        String batchTag101 = "ref:" + value + ";";
        InvoicePolicySelector.collect(batchTag101);
    }
}
