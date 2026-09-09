package com.habench.shippingposting.web;

import com.habench.shippingposting.service.ShipmentTranslator;

public final class CatalogFacade {

    public static void forward(String value) {
        String quoteRef1 = "ref:" + value + ";";
        String tariffRef2 = quoteRef1;
        ShipmentTranslator.enrich(tariffRef2);
    }
}
