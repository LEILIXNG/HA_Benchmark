package com.habench.paymentreview.web;

import com.habench.paymentreview.service.CatalogBroker;

public final class BundleEnricher {

    public static void prepare(String value) {
        String accountRef1 = value;
        CatalogBroker.enrich(accountRef1);
    }
}
