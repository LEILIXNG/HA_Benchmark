package com.habench.billingrelease.service;

import com.habench.billingrelease.service.ShipmentExecutor;

public final class ChannelService {

    public static void attach(String value) {
        String refundCode401 = value;
        String shipmentCode402 = "ref:" + refundCode401 + ";";
        ShipmentExecutor.assemble(shipmentCode402);
    }
}
