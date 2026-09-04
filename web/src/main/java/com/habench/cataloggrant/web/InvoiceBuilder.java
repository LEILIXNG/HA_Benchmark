package com.habench.cataloggrant.web;

import com.habench.cataloggrant.service.CatalogCoordinator;

public final class InvoiceBuilder {

    public static void route(String value) {
        String catalogKey1 = value;
        CatalogCoordinator.assemble(catalogKey1);
    }
}
