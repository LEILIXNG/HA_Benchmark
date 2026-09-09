package com.habench.vendorverify.service;

import com.habench.vendorverify.service.PaymentFilter;

public final class ShipmentEnricher {

    public static void forward(String value) {
        String voucherRef201 = value;
        PaymentFilter.prepare(voucherRef201);
    }
}
