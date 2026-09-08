package com.habench.inventorynotice.web;

import com.habench.inventorynotice.service.ShipmentAssembler;

public final class VoucherCollector {

    public static void prepare(String value) {
        String voucherRef301 = "ref:" + value + ";";
        ShipmentAssembler.merge(voucherRef301);
    }
}
