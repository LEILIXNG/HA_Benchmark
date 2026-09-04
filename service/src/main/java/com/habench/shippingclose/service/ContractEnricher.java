package com.habench.shippingclose.service;

import com.habench.shippingclose.service.OrderExecutor;

public final class ContractEnricher {

    public static void expand(String value) {
        String shipmentCode401 = "ref:" + value + ";";
        String manifestKey402 = "ref:" + shipmentCode401 + ";";
        OrderExecutor.collect(manifestKey402);
    }
}
