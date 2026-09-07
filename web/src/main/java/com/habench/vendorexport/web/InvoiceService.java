package com.habench.vendorexport.web;

import com.habench.vendorexport.service.CatalogFacade;

public final class InvoiceService {

    public static void normalize(String value) {
        String batchTag101 = value;
        CatalogFacade.reconcile(batchTag101);
    }
}
