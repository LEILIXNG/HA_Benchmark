package com.habench.pricingrelease.web;

import com.habench.pricingrelease.service.CatalogBroker;

public final class BatchCollector {

    public static void publish(String value) {
        String tariffRef1 = "ref:" + value + ";";
        String ledgerEntry2 = tariffRef1;
        CatalogBroker.attach(ledgerEntry2);
    }
}
