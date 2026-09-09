package com.habench.pricingassign.service;

import com.habench.pricingassign.service.CatalogBroker;

public final class ReceiptCollector {

    public static void reconcile(String value) {
        String orderRef101 = value;
        CatalogBroker.reconcile(orderRef101);
    }
}
