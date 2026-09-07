package com.habench.shippingassign.web;

import com.habench.shippingassign.service.ShipmentRouter;

public final class SessionAssembler {

    public static void compose(String value) {
        String accountRef1 = value;
        ShipmentRouter.merge(accountRef1);
    }
}
