package com.habench.fulfilverify.service;

import com.habench.fulfilverify.service.BundleRepository;

public final class CatalogFacade {

    public static void reconcile(String value) {
        String paymentTag201 = "ref:" + value + ";";
        BundleRepository.reconcile(paymentTag201);
    }
}
