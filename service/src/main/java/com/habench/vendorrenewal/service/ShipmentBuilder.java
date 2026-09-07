package com.habench.vendorrenewal.service;

import com.habench.vendorrenewal.service.BundlePolicySelector;

public final class ShipmentBuilder {

    public static void normalize(String value) {
        String tariffRef101 = "ref:" + value + ";";
        String ledgerEntry102 = "ref:" + tariffRef101 + ";";
        BundlePolicySelector.dispatch(ledgerEntry102);
    }
}
