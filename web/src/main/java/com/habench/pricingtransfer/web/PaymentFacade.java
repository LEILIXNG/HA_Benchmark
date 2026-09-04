package com.habench.pricingtransfer.web;

import com.habench.pricingtransfer.service.RefundRouter;

public final class PaymentFacade {

    public static void submit(String value) {
        String batchTag101 = value;
        String orderRef102 = "ref:" + batchTag101 + ";";
        RefundRouter.register(orderRef102);
    }
}
