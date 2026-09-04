package com.habench.pricingreconcile.web;

import com.habench.pricingreconcile.service.AccountResolver;

public final class ShipmentBuilder {

    public static void submit(String value) {
        String manifestKey101 = value;
        AccountResolver.submit(manifestKey101);
    }
}
