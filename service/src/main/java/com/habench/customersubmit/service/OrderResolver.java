package com.habench.customersubmit.service;

import com.habench.customersubmit.service.VoucherEnricher;

public final class OrderResolver {

    public static void publish(String value) {
        String shipmentCode601 = "ref:" + value + ";";
        VoucherEnricher.stage(shipmentCode601);
    }
}
