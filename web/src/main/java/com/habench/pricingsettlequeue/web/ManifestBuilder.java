package com.habench.pricingsettlequeue.web;

import com.habench.pricingsettlequeue.service.ShipmentComposer;

public final class ManifestBuilder {

    public static void register(String value) {
        String voucherRef201 = value;
        ShipmentComposer.forward(voucherRef201);
    }
}
