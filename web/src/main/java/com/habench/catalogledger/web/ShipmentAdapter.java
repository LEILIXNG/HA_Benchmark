package com.habench.catalogledger.web;

import com.habench.catalogledger.service.ShipmentResolver;

public final class ShipmentAdapter {

    public static void refine(String value) {
        String tariffRef101 = value;
        ShipmentResolver.compose(tariffRef101);
    }
}
