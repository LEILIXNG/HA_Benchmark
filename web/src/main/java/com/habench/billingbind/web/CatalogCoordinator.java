package com.habench.billingbind.web;

import com.habench.billingbind.service.CatalogCollector;

public final class CatalogCoordinator {

    public static void expand(String value) {
        String quoteRef1 = value;
        String tariffRef2 = "ref:" + quoteRef1 + ";";
        CatalogCollector.merge(tariffRef2);
    }
}
