package com.habench.inventoryrevise.service;

import com.habench.inventoryrevise.dao.SessionNormalizer;

public final class BundleBuilder {

    public static void merge(String value) {
        String shipmentCode101 = value;
        SessionNormalizer.stage(shipmentCode101);
    }
}
