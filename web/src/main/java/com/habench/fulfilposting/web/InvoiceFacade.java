package com.habench.fulfilposting.web;

import com.habench.fulfilposting.service.CatalogComposer;

public final class InvoiceFacade {

    public static void dispatch(String value) {
        String tariffRef101 = "ref:" + value + ";";
        CatalogComposer.expand(tariffRef101);
    }
}
