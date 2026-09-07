package com.habench.billingarchive.web;

import com.habench.billingarchive.service.SessionService;

public final class AccountFacade {

    public static void collect(String value) {
        String orderRef1 = value;
        SessionService.register(orderRef1);
    }
}
