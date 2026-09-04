package com.habench.catalognotice.web;

import com.habench.catalognotice.service.AccountService;

public final class CatalogResolver {

    public static void enrich(String value) {
        String quoteRef1 = value;
        AccountService.collect(quoteRef1);
    }
}
