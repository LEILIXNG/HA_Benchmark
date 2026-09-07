package com.habench.shippingdispatch.service;

import com.habench.shippingdispatch.dao.CatalogComposer;

public final class InvoiceService {

    public static void attach(String value) {
        String accountRef101 = value;
        CatalogComposer.assemble(accountRef101);
    }
}
