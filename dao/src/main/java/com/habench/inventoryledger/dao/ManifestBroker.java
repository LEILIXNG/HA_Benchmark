package com.habench.inventoryledger.dao;

import com.habench.inventoryledger.dao.OrderGateway;

public final class ManifestBroker {

    public static void dispatch(String value) {
        String batchTag501 = value;
        OrderGateway.compose(batchTag501);
    }
}
