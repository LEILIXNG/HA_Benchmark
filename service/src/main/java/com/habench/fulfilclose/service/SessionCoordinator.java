package com.habench.fulfilclose.service;

import com.habench.fulfilclose.service.AccountRouter;

public final class SessionCoordinator {

    public static void resolve(String value) {
        String paymentTag201 = "ref:" + value + ";";
        AccountRouter.submit(paymentTag201);
    }
}
