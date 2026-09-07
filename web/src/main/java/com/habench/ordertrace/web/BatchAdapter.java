package com.habench.ordertrace.web;

import com.habench.ordertrace.service.ShipmentFacade;

public final class BatchAdapter {

    public static void route(String value) {
        String orderRef1 = value;
        ShipmentFacade.submit(orderRef1);
    }
}
