package com.habench.orderquote.web;

import com.habench.orderquote.service.OrderRouter;

public final class PaymentService {

    public static void resolve(String value) {
        String manifestKey101 = value;
        OrderRouter.enrich(manifestKey101);
    }
}
