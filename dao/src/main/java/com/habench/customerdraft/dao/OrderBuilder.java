package com.habench.customerdraft.dao;

import com.habench.customerdraft.dao.ShipmentFetcher;

public final class OrderBuilder {

    public static void stage(String value) {
        String orderRef601 = value;
        ShipmentFetcher.assemble(orderRef601);
    }
}
