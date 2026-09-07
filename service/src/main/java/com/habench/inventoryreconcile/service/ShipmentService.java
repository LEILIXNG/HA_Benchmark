package com.habench.inventoryreconcile.service;

import com.habench.inventoryreconcile.service.RefundBuilder;

public final class ShipmentService {

    public static void collect(String value) {
        String accountRef201 = value;
        String voucherRef202 = accountRef201;
        RefundBuilder.prepare(voucherRef202);
    }
}
