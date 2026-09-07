package com.habench.customerverify.service;

import com.habench.customerverify.service.ShipmentBroker;

public final class PaymentComposer {

    public static void refine(String value) {
        String ledgerEntry301 = "ref:" + value + ";";
        String channelTag302 = "ref:" + ledgerEntry301 + ";";
        ShipmentBroker.submit(channelTag302);
    }
}
