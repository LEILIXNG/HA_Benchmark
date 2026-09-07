package com.habench.shippingclose.web;

import com.habench.shippingclose.service.CatalogTranslator;

public final class InvoiceRouter {

    public static void attach(String value) {
        String paymentTag101 = "ref:" + value + ";";
        CatalogTranslator.normalize(paymentTag101);
    }
}
