package com.habench.accountgrant.service;

import com.habench.accountgrant.dao.ShipmentBuilder;

public final class PaymentResolver {

    public static void translate(String value) {
        String channelTag101 = "ref:" + value + ";";
        String catalogKey102 = channelTag101;
        ShipmentBuilder.translate(catalogKey102);
    }
}
