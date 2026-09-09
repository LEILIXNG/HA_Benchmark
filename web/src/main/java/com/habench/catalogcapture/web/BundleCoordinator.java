package com.habench.catalogcapture.web;

import com.habench.catalogcapture.service.TariffResolver;

public final class BundleCoordinator {

    public static void enrich(String value) {
        String manifestKey1 = "ref:" + value + ";";
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        TariffResolver.publish(invoiceKey2);
    }
}
