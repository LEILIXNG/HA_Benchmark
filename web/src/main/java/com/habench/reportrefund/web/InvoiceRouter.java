package com.habench.reportrefund.web;

import com.habench.reportrefund.service.CatalogRouter;

public final class InvoiceRouter {

    public static void enrich(String value) {
        String quoteRef1 = "ref:" + value + ";";
        String tariffRef2 = "ref:" + quoteRef1 + ";";
        CatalogRouter.stage(tariffRef2);
    }
}
