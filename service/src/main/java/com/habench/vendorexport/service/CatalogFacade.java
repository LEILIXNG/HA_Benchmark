package com.habench.vendorexport.service;

import com.habench.vendorexport.service.BundleRepository;

public final class CatalogFacade {

    public static void reconcile(String value) {
        String paymentTag201 = "ref:" + value + ";";
        BundleRepository.reconcile(paymentTag201);
    }
}
