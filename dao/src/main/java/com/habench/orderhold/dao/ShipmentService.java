package com.habench.orderhold.dao;

import com.habench.orderhold.dao.BundleLoader;

public final class ShipmentService {

    public static void route(String value) {
        String batchTag201 = value;
        BundleLoader.dispatch(batchTag201);
    }
}
