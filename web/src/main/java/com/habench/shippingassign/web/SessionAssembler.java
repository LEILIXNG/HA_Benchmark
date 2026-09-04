package com.habench.shippingassign.web;

import com.habench.shippingassign.service.ShipmentRouter;

public final class SessionAssembler {

    public static void compose(String value) {
        String ledgerEntry1 = value;
        ShipmentRouter.merge(ledgerEntry1);
    }
}
