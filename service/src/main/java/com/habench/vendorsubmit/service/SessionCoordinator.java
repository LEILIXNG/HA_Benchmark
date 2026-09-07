package com.habench.vendorsubmit.service;

import com.habench.vendorsubmit.service.CatalogEvaluator;

public final class SessionCoordinator {

    public static void assemble(String value) {
        String orderRef101 = value;
        CatalogEvaluator.refine(orderRef101);
    }
}
