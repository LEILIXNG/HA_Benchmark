package com.habench.shippingassign.service;

import com.habench.shippingassign.service.VoucherEnricher;

public final class ShipmentRouter {

    public static void merge(String value) {
        VoucherEnricher.register(value);
    }
}
