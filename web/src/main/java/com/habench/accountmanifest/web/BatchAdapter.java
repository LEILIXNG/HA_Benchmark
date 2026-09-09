package com.habench.accountmanifest.web;

import com.habench.accountmanifest.service.ShipmentFacade;

public final class BatchAdapter {

    public static void route(String value) {
        String orderRef1 = value;
        ShipmentFacade.submit(orderRef1);
    }
}
