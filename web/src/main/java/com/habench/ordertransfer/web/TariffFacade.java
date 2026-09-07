package com.habench.ordertransfer.web;

import com.habench.ordertransfer.service.ShipmentRouter;

public final class TariffFacade {

    public static void resolve(String value) {
        String refundCode1 = "ref:" + value + ";";
        ShipmentRouter.register(refundCode1);
    }
}
