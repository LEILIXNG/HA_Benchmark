package com.habench.fulfilverify.web;

import com.habench.fulfilverify.service.CatalogFacade;

public final class InvoiceService {

    public static void normalize(String value) {
        String batchTag101 = value;
        CatalogFacade.reconcile(batchTag101);
    }
}
