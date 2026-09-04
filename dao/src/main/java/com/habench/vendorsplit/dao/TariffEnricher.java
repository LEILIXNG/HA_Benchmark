package com.habench.vendorsplit.dao;

import com.habench.vendorsplit.dao.ShipmentBuilder;

public final class TariffEnricher {

    public static void publish(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        String channelTag202 = ledgerEntry201;
        ShipmentBuilder.publish(channelTag202);
    }
}
