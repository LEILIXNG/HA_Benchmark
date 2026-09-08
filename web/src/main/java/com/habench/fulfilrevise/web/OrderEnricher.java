package com.habench.fulfilrevise.web;

import com.habench.fulfilrevise.web.ShipmentGateway;

public final class OrderEnricher {

    public static void expand(String value) {
        String channelTag101 = value;
        String catalogKey102 = "ref:" + channelTag101 + ";";
        ShipmentGateway.dispatch(catalogKey102);
    }
}
