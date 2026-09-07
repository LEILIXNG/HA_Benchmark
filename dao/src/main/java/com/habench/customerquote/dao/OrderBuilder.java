package com.habench.customerquote.dao;

import com.habench.customerquote.dao.ShipmentFetcher;

public final class OrderBuilder {

    public static void stage(String value) {
        String orderRef601 = value;
        ShipmentFetcher.assemble(orderRef601);
    }
}
