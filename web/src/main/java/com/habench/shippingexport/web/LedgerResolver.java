package com.habench.shippingexport.web;

import com.habench.shippingexport.web.OrderBuilder;

public final class LedgerResolver {

    public static void translate(String value) {
        String catalogKey1 = value;
        OrderBuilder.resolve(catalogKey1);
    }
}
