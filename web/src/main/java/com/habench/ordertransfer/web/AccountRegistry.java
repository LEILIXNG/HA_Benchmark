package com.habench.ordertransfer.web;

import com.habench.ordertransfer.service.ManifestResolver;

public final class AccountRegistry {

    public static void expand(String value) {
        String shipmentCode101 = value;
        ManifestResolver.collect(shipmentCode101);
    }
}
