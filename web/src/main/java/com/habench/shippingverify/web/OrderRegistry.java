package com.habench.shippingverify.web;

import com.habench.shippingverify.web.CatalogGateway;

public final class OrderRegistry {

    public static void forward(String value) {
        String channelTag101 = value;
        String catalogKey102 = channelTag101;
        CatalogGateway.compose(catalogKey102);
    }
}
