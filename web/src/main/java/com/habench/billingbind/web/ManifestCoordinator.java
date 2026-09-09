package com.habench.billingbind.web;

import com.habench.billingbind.service.TariffEnricher;

public final class ManifestCoordinator {

    public static void enrich(String value) {
        String refundCode101 = "ref:" + value + ";";
        TariffEnricher.attach(refundCode101);
    }
}
