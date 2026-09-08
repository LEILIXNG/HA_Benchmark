package com.habench.shippinggrant.web;

import com.habench.shippinggrant.service.ShipmentFacade;

public final class BatchAdapter {

    public static void route(String value) {
        String orderRef1 = value;
        ShipmentFacade.submit(orderRef1);
    }
}
