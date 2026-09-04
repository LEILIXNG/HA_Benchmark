package com.habench.reportimport.web;

import com.habench.reportimport.service.CatalogTranslator;

public final class InvoiceCoordinator {

    public static void register(String value) {
        String accountRef101 = "ref:" + value + ";";
        CatalogTranslator.route(accountRef101);
    }
}
